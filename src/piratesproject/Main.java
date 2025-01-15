package piratesproject;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.auth.login.LoginController;
import piratesproject.ui.auth.reg.RegisterController;

import piratesproject.ui.game.xogameboard.VSComp.VsComputerEasy;

import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;

import piratesproject.ui.home.HomePageController;
import piratesproject.ui.splash.SplashController;
import piratesproject.utils.BackgroundMusic;

import piratesproject.utils.SharedModel;

public class Main extends Application implements NetworkResponseHandler {

    private static Scene scene;
    private NetworkAccessLayer networkAccessLayer;

    @Override
    public void start(Stage stage) throws Exception {
        networkAccessLayer = NetworkAccessLayer.getInstance(this);

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");

        Parent root = new LoginController(stage);
        scene = new Scene(root);
        stage.setTitle(Strings.APP_NAME);
        stage.getIcons().add(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toString()));
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        BackgroundMusic.stopMusic();
    }

    public static void resetScene(Parent p) {
        scene.setRoot(p);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
