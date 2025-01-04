/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.reg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.login.LoginBase;

public class RegisterController extends RegisterBase {

   

    public RegisterController(Stage s) {
        super(s);
        listenToAllEvents();
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
//                    try {
//                        mySocket = new Socket("127.0.0.1", 1422);
//
//                        talker = new ObjectOutputStream(mySocket.getOutputStream());
//                        talker.writeObject(user);
//
//                    } catch (IOException ex) {
//                        Logger.getLogger(RegisterBase.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                      new Thread(() -> NetworkAccessLayer.registerToServer(user)).start();

                }

            }

        }

        return logged;
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
        LoginBase loginPage = new LoginBase(stage);
        Scene loginScene = new Scene(loginPage);
        stage.setScene(loginScene);
    }
    
}

/**
 *
 * @author jaila
 */
