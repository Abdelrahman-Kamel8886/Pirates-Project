package piratesproject.ui.home;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.forms.Settings.SettingsForm;
import piratesproject.ui.login.LoginController;
import piratesproject.ui.xogameboard.XOGameBoard;
import piratesproject.ui.xogameboard.XOGameController;
import piratesproject.utils.SharedModel;

public class HomePageController extends HomePage {

    Stage myStage;

    public HomePageController(Stage stage) {
        myStage = stage;
        initView();
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
            Parent home = new XOGameController(myStage);
            goToGame();
        });
    }

    void goToLogin() {
        LoginController loginPage = new LoginController(myStage);
        Main.resetScene(loginPage);
    }

    private void goToGame() {
        Parent game = new XOGameController(myStage);
        Main.resetScene(game);
    }

    private void openSettings() {
        SettingsForm settings = new SettingsForm();
        settings.display(myStage);
    }
}
