package piratesproject.ui.home;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.cells.ActivePlayerCell;
import piratesproject.cells.GameRecordCell;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.enums.SoundTrackStateEnum;
import piratesproject.forms.Settings.SettingsForm;
import piratesproject.forms.levels.LevelForm;
import piratesproject.forms.receivingInvitation.InvitationFormHandler;
import piratesproject.forms.sendinvitatation.SendInvitationFormHandler;
import piratesproject.forms.snakeGame.SnakeGameForm;
import piratesproject.forms.twoNames.TwoNamesForm;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.AvalabilePlayer;
import piratesproject.models.RecordModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.auth.login.LoginController;
import piratesproject.ui.game.replay.ReplayController;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.utils.BackgroundMusic;
import piratesproject.utils.FileHandler;
import piratesproject.utils.JsonUtils;

import piratesproject.utils.SharedModel;

public class HomePageController extends HomePage implements NetworkResponseHandler {

    private Stage myStage;
    private final ArrayList<String> songs;
    private int currentSong = 0;

    private NetworkAccessLayer networkAccessLayer;

    public HomePageController(Stage stage) {
        myStage = stage;
        networkAccessLayer = NetworkAccessLayer.getInstance();
        networkAccessLayer.setResponseHandler(this);
        songs = new ArrayList<>();
        songs.add(Pathes.SOUNDTRACK1_PATH);
        songs.add(Pathes.SOUNDTRACK2_PATH);
        songs.add(Pathes.SOUNDTRACK3_PATH);
        songs.add(Pathes.SOUNDTRACK4_PATH);
        
        if(SharedModel.getUser()!=null){
            networkAccessLayer.sentAvilableState(0);
        }

        initView();
        System.out.println("asjncja ncasj");
        setRecordsData();
        SharedModel.setGameRoom(null);
        if (!SharedModel.isSoundTrackStarted()) {
            playCurrentSong();
            SharedModel.setSoundTrackStarted(true);
        }
        if(SharedModel.getSoundTrackState() == SoundTrackStateEnum.paused){
            playBtn.setImage(new Image(getClass().getResource(Pathes.PLAY_LOGO_PATH).toExternalForm()));
        }
    }

    private void initView() {

        logoImage.setImage(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toExternalForm()));
        multiPlayersImage.setImage(new Image(getClass().getResource(Pathes.MULTIPLAYER_LOGO_PATH).toExternalForm()));
        computerImage.setImage(new Image(getClass().getResource(Pathes.COMPUTER_LOGO_PATH).toExternalForm()));
        playBtn.setImage(new Image(getClass().getResource(Pathes.PAUSE_LOGO_PATH).toExternalForm()));
        prevBtn.setImage(new Image(getClass().getResource(Pathes.PREV_LOGO_PATH).toExternalForm()));
        stopBtn.setImage(new Image(getClass().getResource(Pathes.STOP_LOGO_PATH).toExternalForm()));
        nextBtn.setImage(new Image(getClass().getResource(Pathes.NEXT_LOGO_PATH).toExternalForm()));
        snakeImage.setImage(new Image(getClass().getResource(Pathes.SNAKE_LOGO_PATH).toExternalForm()));


        box.setId("box");
        box0.setId("box");
        box1.setId("box");

        box.setSpacing(1000.0);
        hBox.setSpacing(5.0);
        hBox0.setSpacing(10.0);
        getStylesheets().add(Pathes.HOMEPAGE_STYLE_PATH);

        if (SharedModel.getUser() == null) {
            initGuestView();
        } else {
            initUserView();
        }
        
        onClicks();
    }

    private void initGuestView() {
        avatar.setImage(new Image(getClass().getResource(Pathes.GUEST_LOGO_PATH).toExternalForm()));
        userNameText.setText(Strings.SIGNIN_TEXT);
        userNameText.setUnderline(true);
        scoreText.setVisible(false);
        box0.setVisible(false);

    }

    private void initUserView() {
        userNameText.setText(SharedModel.getUser().getUserName());
        scoreText.setText("Score : " + SharedModel.getUser().getScore());
        avatar.setImage(new Image(getClass().getResource(Pathes.AVATAR_LOGO_PATH).toExternalForm()));
        networkAccessLayer.getOnlineUsers();
        
    }

    private void setPlayersData(ArrayList<UserModel> users) {
        if (users != null && !users.isEmpty()) {
            activePlayersListView.setItems(FXCollections.observableArrayList(users));
            activePlayersListView.setCellFactory(param -> new ActivePlayerCell());
        }

    }

    private void setRecordsData() {
        ArrayList<RecordModel> records = loadRecords();
        System.out.println("Records : "+records.size());
        ArrayList<RecordModel> myRecords = new ArrayList();
        String username ;
        if(SharedModel.getUser()!=null){
            username =SharedModel.getUser().getUserName();
        }
        else{
            username ="Guest";
        }
         
        if (records != null && !records.isEmpty()) {
            for (RecordModel record : records) {
                if (record.getPlayer1().getName().equals(username)
                        || record.getPlayer2().getName().equals(username)) {
                    myRecords.add(record);
                }
            }
        }
        if (myRecords != null && !myRecords.isEmpty()) {
            recordsListView.setItems(FXCollections.observableArrayList(myRecords));
            recordsListView.setCellFactory(param -> new GameRecordCell());
        }

    }

    private ArrayList<RecordModel> loadRecords() {
        return FileHandler.getAllRecords();
    }

    private void onClicks() {

        if (SharedModel.getUser() == null) {
            userNameText.setOnMouseClicked((MouseEvent event) -> {
                goToLogin();
            });
        } else {
            avatar.setOnMouseClicked((MouseEvent event) -> {
                openSettings();
            });
        }

        multiPlayersImage.setOnMouseClicked((MouseEvent event) -> {
            showTwoNames();
        });
        computerImage.setOnMouseClicked((MouseEvent event) -> {
            showLevels();
        });
        
        snakeImage.setOnMouseClicked((MouseEvent event) -> {
            SnakeGameForm form = new SnakeGameForm();
            form.display(myStage);
        });
        
        

        playBtn.setOnMouseClicked((MouseEvent event) -> {
            checkSound();
        });
        stopBtn.setOnMouseClicked((MouseEvent event) -> {
            stopSong();
        });
        prevBtn.setOnMouseClicked((MouseEvent event) -> {
            playPrevSong();
        });
        nextBtn.setOnMouseClicked((MouseEvent event) -> {
            playNextSong();

        });
        recordsListView.setOnMouseClicked(event -> {
            RecordModel selectedItem = recordsListView.getSelectionModel().getSelectedItem();

            if (selectedItem != null) {
                SharedModel.setSelectedRecord(selectedItem);
                goToReplay();
            }
        });
        
        activePlayersListView.setOnMouseClicked(event -> {
            UserModel selectedItem = activePlayersListView.getSelectionModel().getSelectedItem();
            SharedModel.setSelectedUser(selectedItem);
            SendInvitationFormHandler.display(myStage);
        });
        myStage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.R) {
                setRecordsData();
            }
        });
        
        
    }

    private void checkSound() {
        if (SharedModel.getSoundTrackState() == SoundTrackStateEnum.running) {
            pauseSong();
        } else if (SharedModel.getSoundTrackState() == SoundTrackStateEnum.paused) {
            resumeSong();
        } else {
            playCurrentSong();
        }
    }

    private void playNextSong() {
        if (currentSong < songs.size() - 1) {
            currentSong++;
        } else {
            currentSong = 0;
        }
        stopSong();
        playCurrentSong();
    }

    private void playPrevSong() {
        if (currentSong != 0) {
            currentSong--;
        } else {
            currentSong = songs.size() - 1;
        }
        stopSong();
        playCurrentSong();
    }

    private void playCurrentSong() {
        playBtn.setImage(new Image(getClass().getResource(Pathes.PAUSE_LOGO_PATH).toExternalForm()));
        BackgroundMusic.playMusic(songs.get(currentSong));
        SharedModel.setSoundTrackState(SoundTrackStateEnum.running);
    }

    private void stopSong() {
        playBtn.setImage(new Image(getClass().getResource(Pathes.PLAY_LOGO_PATH).toExternalForm()));
        BackgroundMusic.stopMusic();
        SharedModel.setSoundTrackState(SoundTrackStateEnum.stoped);
    }

    private void pauseSong() {
        playBtn.setImage(new Image(getClass().getResource(Pathes.PLAY_LOGO_PATH).toExternalForm()));
        BackgroundMusic.pauseMusic();
        SharedModel.setSoundTrackState(SoundTrackStateEnum.paused);
    }

    private void resumeSong() {
        playBtn.setImage(new Image(getClass().getResource(Pathes.PAUSE_LOGO_PATH).toExternalForm()));

        BackgroundMusic.resumeMusic();
        SharedModel.setSoundTrackState(SoundTrackStateEnum.running);
    }

    private void goToLogin() {
        LoginController loginPage = new LoginController(myStage);
        Main.resetScene(loginPage);
    }

    private void goToGame() {

        Parent game = new XOGameOfflineController(myStage);
        Main.resetScene(game);
    }

    private void goToReplay() {
        Parent replay = new ReplayController(myStage);
        Main.resetScene(replay);
    }

    private void openSettings() {
        SettingsForm settings = new SettingsForm();
        settings.display(myStage);
    }

    private void showLevels() {
        LevelForm.display(myStage);

    }

    private void showTwoNames() {
        TwoNamesForm.display(myStage);
    }

    private void showSimpleAlert(AvalabilePlayer player) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Send request to " + player.getPlayerName());
        alert.setContentText("Are you sure you want to send to user " + player.getPlayerName() + "\n" + " and its score is " + player.getScore()
                + "\n" + "  ركز يا حبيبي ");
        alert.showAndWait();
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        if (response.getType() == RequestTypesEnum.USERSTABLE) {
            ArrayList<UserModel> users = JsonUtils.jsonToUsersArray(response.getData());
            ArrayList<UserModel> newUsers = new ArrayList();
            //users.remove(SharedModel.getUser());
            for(UserModel user : users){
                if(!user.getUserName().equals(SharedModel.getUser().getUserName())){
                    newUsers.add(user);
                }
            }
            setPlayersData(newUsers);
        }
        else if(response.getType() == RequestTypesEnum.RECIEVE_INVITATION){
            System.out.println("8888888888");
            SharedModel.setChallenger(response.getData());
            InvitationFormHandler.display(myStage);
        }

    }
}
