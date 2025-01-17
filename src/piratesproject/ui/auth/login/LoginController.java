package piratesproject.ui.auth.login;

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
import piratesproject.forms.draw.DrawBase;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.UserModel;
import piratesproject.ui.home.HomePageController;
import piratesproject.ui.auth.reg.RegisterController;
import piratesproject.ui.game.xogameboard.online.OnlineGame;
import piratesproject.utils.Consts;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

/**
 *
 * @author Admin
 */
public class LoginController extends LoginBase implements NetworkResponseHandler{
    
    private NetworkAccessLayer networkAccessLayer;

    public LoginController(Stage stage) {
        super(stage);
        listenToAllEvents();
        networkAccessLayer = NetworkAccessLayer.getInstance();
        networkAccessLayer.setResponseHandler(this);

    }

    private void listenToAllEvents() {
        Blogin.setOnAction(event -> login());
        sginuplink.setOnAction(event -> gotoSginup());
        Guest.setOnAction(event -> gotoHome());
    }

    private boolean login() {
        boolean islogin = false;
        if (isFull()) {
            String name = TFname.getText();
            String pass = Tfpass.getText();
            //LoginRequestModel user = new 
            
            networkAccessLayer.sendLogin(new LoginRequestModel(name, pass));
//            Thread th = new Thread(() -> {
//                LoginResponseModel responseModel = NetworkAccessLayer.loginToServer(new LoginRequestModel(name, pass));
//                
//
//            });
//            th.start();
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
        Parent signupPage = new RegisterController(mystage);
        Main.resetScene(signupPage);
    }

    public void gotoHome() {

        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        if(response.getStatus()==Consts.CONNECTION_SUCCESS){
            UserModel user = JsonUtils.jsonToUserModel(response.getData());
            SharedModel.setUser(user);
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
        }
        else {
                if (Platform.isFxApplicationThread()) {
                    showErrorAlert(response.getMessage());
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showErrorAlert(response.getMessage());
                        }
                    });
                }
            }
    }
}
