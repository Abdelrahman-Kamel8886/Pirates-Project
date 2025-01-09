package piratesproject.forms.Settings;

import piratesproject.drawable.values.Strings;
import piratesproject.utils.SharedModel;

public class ProfileController extends ProfileBase {

    public ProfileController() {
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

        if (oldPassword.getText().equals("123456")) {
            doneLabel.setText(Strings.PASSWORD_CHANGED_TEXT);
            doneLabel.setStyle("-fx-text-fill: green");
        } else {
            doneLabel.setText("!! Old password is wrong");
            doneLabel.setStyle("-fx-text-fill: red");
        }
        doneLabel.setVisible(true);

    }

}
