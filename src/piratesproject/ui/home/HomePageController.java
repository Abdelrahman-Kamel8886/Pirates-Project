package piratesproject.ui.home;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.enums.SoundTrackStateEnum;
import piratesproject.forms.Settings.SettingsForm;
import piratesproject.forms.levels.LevelController;
import piratesproject.forms.levels.LevelForm;
import piratesproject.ui.login.LoginController;
import piratesproject.ui.xogameboard.XOGameBoard;
import piratesproject.utils.BackgroundMusic;
import piratesproject.utils.SharedModel;

public class HomePageController extends HomePage {

    private Stage myStage;
    private ArrayList<String> songs;
    private int currentSong = 0;

    public HomePageController(Stage stage) {
        myStage = stage;
        songs = new ArrayList<>();
        songs.add(Pathes.SOUNDTRACK1_PATH);
        songs.add(Pathes.SOUNDTRACK2_PATH);
        songs.add(Pathes.SOUNDTRACK3_PATH);
        songs.add(Pathes.SOUNDTRACK4_PATH);

        initView();
        playCurrentSong();
    }

    private void initView() {

        logoImage.setImage(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toExternalForm()));
        multiPlayersImage.setImage(new Image(getClass().getResource(Pathes.MULTIPLAYER_LOGO_PATH).toExternalForm()));
        computerImage.setImage(new Image(getClass().getResource(Pathes.COMPUTER_LOGO_PATH).toExternalForm()));
        playBtn.setImage(new Image(getClass().getResource(Pathes.PAUSE_LOGO_PATH).toExternalForm()));
        prevBtn.setImage(new Image(getClass().getResource(Pathes.PREV_LOGO_PATH).toExternalForm()));
        stopBtn.setImage(new Image(getClass().getResource(Pathes.STOP_LOGO_PATH).toExternalForm()));
        nextBtn.setImage(new Image(getClass().getResource(Pathes.NEXT_LOGO_PATH).toExternalForm()));

        box.setId("box");
        box0.setId("box");
        box1.setId("box");

        box.setSpacing(1100.0);
        hBox.setSpacing(5.0);
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
        gridPane.setVisible(false);

    }

    private void initUserView() {
        userNameText.setText(SharedModel.getUser().getUserName());
        scoreText.setText("Score : " + SharedModel.getUser().getScore());
        avatar.setImage(new Image(getClass().getResource(Pathes.AVATAR_LOGO_PATH).toExternalForm()));
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
            goToGame();
        });
        computerImage.setOnMouseClicked((MouseEvent event) -> {
            showLevels();
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
    
    private void playNextSong(){
        if(currentSong<songs.size()-1){
            currentSong++;
        }
        else{
            currentSong = 0;
        }
        stopSong();
        playCurrentSong();
    }
    
    private void playPrevSong(){
        if(currentSong !=0){
            currentSong--;
        }
        else{
            currentSong = songs.size()-1;
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
        Parent game = new XOGameBoard(myStage);
        Main.resetScene(game);
    }

    private void openSettings() {
        SettingsForm settings = new SettingsForm();
        settings.display(myStage);
    }
    private void showLevels()
    {
        LevelForm.display(myStage);
        
    }
}