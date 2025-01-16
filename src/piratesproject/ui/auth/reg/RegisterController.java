/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.auth.reg;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.network.NetworkAccessLayer;

import piratesproject.ui.home.HomePageController;
import piratesproject.ui.auth.login.LoginBase;
import piratesproject.ui.auth.login.LoginController;
import piratesproject.utils.Consts;
import piratesproject.utils.SharedModel;


public class RegisterController extends RegisterBase implements NetworkResponseHandler {

    private NetworkAccessLayer networkAccessLayer;

    public RegisterController(Stage s) {
        super(s);
        
        listenToAllEvents();
        networkAccessLayer = NetworkAccessLayer.getInstance(this);
        networkAccessLayer.setResponseHandler(this);
    }

    void listenToAllEvents() {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean b = register();
            }

        });
        loginText.setOnAction(event -> {
            goToLogin();
        });
        AsAGuestText.setOnAction(event -> {
            gotoHome();
        });
    }

    boolean register() {
        setAllLabelsToDefault();
        boolean isAnyFieldEmpty = checkAllTextFields();
        boolean logged = true;
        if (isAnyFieldEmpty) {
            logged = false;
        } else {
            if (passwordTF.getText().length() < 6) {
                passwordReq.setText("Passwords should at least contain 6 characters");
                passwordReq.setVisible(true);
                logged = false;
            } else {
                if (!passwordTF.getText().equals(confirmPasswordTF.getText())) {
                    confirmPasswordReq.setText("Passwords do not match");
                    confirmPasswordReq.setVisible(true);
                    logged = false;

                } else //everything is alright only username will be checked from the db
                {
                    UserModel user = new UserModel(firstNameTF.getText(),
                            lastNameTF.getText(),
                            usernameTF.getText(),
                            passwordTF.getText());

                    
//                    Thread th = new Thread(() -> {
//                        ResponseModel responseModel = NetworkAccessLayer .registerToServer(user);
//                        checkRegisterState(responseModel);
//
//
////                    Thread th = new Thread(() -> {
////                        ResponseModel responseModel = NetworkAccessLayer.registerToServer(user);
////                        checkRegisterState(responseModel);
////
////                    });
////                    th.start();
//                    SharedModel.setUser(user);
//                    networkAccessLayer.sendRegisteration(user);
//
//                }
                            }

            }

        }

        return logged;
    }

    public void showErrorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Error");
        alert.setHeaderText(msg);
        alert.setContentText(null);
        alert.showAndWait();
    }

    public void showConfirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Confirm");
        alert.setHeaderText(msg);
        alert.setContentText(null);
        alert.showAndWait();
        gotoHome();
    }

    private void checkRegisterState(ResponseModel responseModel) {
        if (responseModel != null) {
            if (responseModel.getStatus() == Consts.CONNECTION_SUCCESS) {
                if (Platform.isFxApplicationThread()) {
                    gotoHome();
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gotoHome();
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

    boolean checkAllTextFields() {  //return false if at least 1 textfield is empty
        boolean isEmpty = false;
        if (firstNameTF.getText().isEmpty()) {
            isEmpty = true;
            firstNameReq.setVisible(true);
        }
        if (lastNameTF.getText().isEmpty()) {
            isEmpty = true;
            lastNameReq.setVisible(true);
        }
        if (usernameTF.getText().isEmpty()) {
            isEmpty = true;
            usernameReq.setVisible(true);
        }
        if (passwordTF.getText().isEmpty()) {
            isEmpty = true;
            passwordReq.setVisible(true);
        }
        if (confirmPasswordTF.getText().isEmpty()) {
            isEmpty = true;
            confirmPasswordReq.setVisible(true);
        }
        return isEmpty;
    }

    void setAllLabelsToDefault() {
        confirmPasswordReq.setText("Confirm password required");
        passwordReq.setText("Passwords required");
        firstNameReq.setVisible(false);
        lastNameReq.setVisible(false);
        usernameReq.setVisible(false);
        passwordReq.setVisible(false);
        confirmPasswordReq.setVisible(false);

    }

    void goToLogin() {
        LoginController loginPage = new LoginController(stage);
        Main.resetScene(loginPage);
    }

    public void gotoHome() {
        Parent homePage = new HomePageController(stage);
        Main.resetScene(homePage);
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        checkRegisterState(response);
    }

}
