package piratesproject.ui.login;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.models.LoginRequestModel;
import piratesproject.models.LoginResponseModel;
import piratesproject.models.ResponseModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.draw.DrawBase;
import piratesproject.ui.home.FXMLController;
import piratesproject.ui.reg.RegisterController;
import piratesproject.utils.Consts;

/**
 *
 * @author Admin
 */
public class LoginController extends LoginBase {

    public LoginController(Stage stage) {
        super(stage);
        listenToAllEvents();

    }

    private void listenToAllEvents() {
        Blogin.setOnAction(event -> login());
        sginuplink.setOnAction(event -> gotoSginup());
    }

    private boolean login() {
        boolean islogin = false;
        if (isFull()) {
            String name = TFname.getText();
            String pass = Tfpass.getText();
            //LoginRequestModel user = new 

            Thread th = new Thread(() -> {
                LoginResponseModel responseModel = NetworkAccessLayer.loginToServer(new LoginRequestModel(name, pass));
                checkLoginState(responseModel);

            });
            th.start();
        }
        return islogin;
    }

    public void showErrorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mystage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Error");
        alert.setHeaderText(msg);
        alert.setContentText(null);
        alert.showAndWait();
    }

    public void showConfirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mystage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Confirm");
        alert.setHeaderText(msg);
        alert.setContentText(null);
        alert.showAndWait();
        gotoHome();
    }

    private void checkLoginState(LoginResponseModel responseModel) {
        if (responseModel != null) {
            if (responseModel.getStatus() == Consts.CONNECTION_SUCCESS) {
                if (Platform.isFxApplicationThread()) {
                    showConfirmationAlert(responseModel.getMessage());
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gotoHome();
                            // showConfirmationAlert(responseModel.getMessage());
                        }
                    });
                }
            } else {
                if (Platform.isFxApplicationThread()) {
                    showErrorAlert(responseModel.getMessage());
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showErrorAlert(responseModel.getMessage());
                        }
                    });
                }
            }
        }
    }

    private boolean isFull() {
        boolean isfull = true;

        if (TFname.getText().isEmpty()) {
            nameError.setVisible(true);
            isfull = false;
        } else {
            nameError.setVisible(false);
        }

        if (Tfpass.getText().isEmpty()) {
            passerror.setVisible(true);
            isfull = false;
        } else {
            passerror.setVisible(false);
        }
        return isfull;
    }

    public void gotoSginup() {
        //Parent signupPage = new RegisterController(mystage);
        Parent signupPage = new DrawBase();
        
        Main.resetScene(signupPage);
    }

    public void gotoHome() {
       Parent homePage = new FXMLController(mystage);
        //Parent homePage = new DrawBase();

        Main.resetScene(homePage);
    }
}
