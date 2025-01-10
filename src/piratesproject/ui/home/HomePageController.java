package piratesproject.ui.home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.forms.Settings.SettingsForm;
import piratesproject.forms.sendinvitatation.SendInvitationFormController;
import piratesproject.forms.sendinvitatation.SendInvitationFormHandler;
import piratesproject.ui.login.LoginController;
import piratesproject.ui.xogameboard.XOGameBoard;
import piratesproject.utils.SharedModel;

public class HomePageController extends HomePage {

    Stage myStage;

    public HomePageController(Stage stage) {
        myStage = stage;
        initView();
        addOnliePlayer();
    }

    private void initView() {
        
        logoImage.setImage(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toExternalForm()));
        multiPlayersImage.setImage(new Image(getClass().getResource(Pathes.MULTIPLAYER_LOGO_PATH).toExternalForm()));
        computerImage.setImage(new Image(getClass().getResource(Pathes.COMPUTER_LOGO_PATH).toExternalForm()));
        box.setId("box");
        box0.setId("box");
        box1.setId("box");
        getStylesheets().add(Pathes.HOMEPAGE_STYLE_PATH);
        
        if (SharedModel.getUser() == null) {
            initGuestView();
        } else {
            initUserView();
        }
        onClicks();
          tableView.setRowFactory(tv -> {
            TableRow<FXMLController.Player> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                System.out.println("Clicked row: ");
                //showSimpleAlert(new Player("here is user name ", 1800));
                  SendInvitationFormHandler.display(myStage);
                //Parent root = new SendInvitationFormController();
                //Main.resetScene(root);
            });
            return row;
        });
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
            Parent home = new XOGameBoard(myStage);
            goToGame();
        });
    }

    void goToLogin() {
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
            private void addOnliePlayer() {
        ObservableList<Player> data = FXCollections.observableArrayList(
                new Player("test1", 90),
                new Player("test2", 85),
                new Player("test3", 95)
        );

        tableView.setItems(data);

    }
        private void showSimpleAlert(Player player) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Send request to "+ player.getPlayerName());
        alert.setContentText("Are you sure you want to send to user "+player.getPlayerName() +"\n"+" and its score is "+player.getScore()
                    +"\n"+"  ركز يا حبيبي " );
        alert.showAndWait();
    }

    class Player {

        public String playerName;
        public int score;

        public Player(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }
}
