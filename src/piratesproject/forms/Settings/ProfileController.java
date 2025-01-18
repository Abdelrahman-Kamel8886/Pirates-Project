package piratesproject.forms.Settings;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import piratesproject.Main;
import piratesproject.drawable.values.Strings;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.auth.login.LoginController;
import piratesproject.utils.BackgroundMusic;
import piratesproject.utils.SharedModel;

public class ProfileController extends ProfileBase {

    private NetworkAccessLayer networkAccessLayer;

    public ProfileController() {
        networkAccessLayer = NetworkAccessLayer.getInstance();
        initView();
    }

    private void initView() {
        String fname = SharedModel.getUser().getFirstName() + " " + SharedModel.getUser().getLastName();
        fullName.setText(fname);
        userName.setText("@" + SharedModel.getUser().getUserName());
        gamesPlayedText.setText("Games Played : " + SharedModel.getUser().getGamesPlayed());
        scoreText.setText("Score : " + SharedModel.getUser().getScore());
        onClicks();
    }

    private void onClicks() {
        confirmBtn.setOnAction(event -> {
            oldErrorLabel.setVisible(false);
            NewErrorLabel.setVisible(false);
            confirmErrorLabel.setVisible(false);
            doneLabel.setVisible(false);
            validation();
        });

        logout.setOnMouseClicked((MouseEvent event) -> {
            SettingsForm.closeForm();
            BackgroundMusic.stopMusic();
            SharedModel.setSoundTrackStarted(false);
            networkAccessLayer.exitApplication();
            goToLogin();
        });
    }

    private void validation() {
        if (oldPassword.getText().isEmpty()) {
            oldErrorLabel.setVisible(true);
        } else if (newPassword.getText().isEmpty()) {
            NewErrorLabel.setVisible(true);
        } else if (confirmPassword.getText().isEmpty()) {
            confirmErrorLabel.setVisible(true);
        } else {
            checkPasswordEquailty();
        }
    }

    private void checkPasswordEquailty() {
        if (newPassword.getText().equals(confirmPassword.getText())) {
            changePassword();
        } else {
            doneLabel.setText(Strings.PASSWORD_NOT_EQUAL_TEXT);
            doneLabel.setStyle("-fx-text-fill: red");
            doneLabel.setVisible(true);
        }
    }

    private void changePassword() {
        if (oldPassword.getText().equals(SharedModel.getUser().getPassword())) {
            networkAccessLayer.updatePassword(newPassword.getText());
            doneLabel.setText(Strings.PASSWORD_CHANGED_TEXT);
            doneLabel.setStyle("-fx-text-fill: green");
        } else {
            doneLabel.setText("!! Old password is wrong");
            doneLabel.setStyle("-fx-text-fill: red");
        }
        doneLabel.setVisible(true);

    }

    private void goToLogin() {
        LoginController loginPage = new LoginController(SettingsForm.owner);
        Main.resetScene(loginPage);
    }

}
