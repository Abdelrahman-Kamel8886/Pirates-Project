/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.login;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piratesproject.models.LoginRequestModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.reg.RegisterController;

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
        sginuplink.setOnAction(event -> gotosginup());
    }

    private boolean login() {
        boolean islogin = false;
        if (isFull()) {
            String name = TFname.getText();
            String pass = Tfpass.getText();
            //LoginRequestModel user = new 
            new Thread(() -> NetworkAccessLayer.loginToServer(new LoginRequestModel(name, pass),mystage)).start();
        }
        return islogin;
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

    public void gotosginup() {
        Parent signupPage = new RegisterController(mystage);
        Scene signupScene = new Scene(signupPage , 1920,1080);
        mystage.setScene(signupScene);

    }
}
