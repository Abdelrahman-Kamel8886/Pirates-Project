package piratesproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.auth.login.LoginController;
import piratesproject.ui.game.replay.ReplayController;
import piratesproject.ui.game.xogameboard.VSComp.VsComputerEasy;
import piratesproject.ui.home.HomePageController;
import piratesproject.ui.splash.SplashController;
import piratesproject.utils.BackgroundMusic;

public class Main extends Application{

    private static Scene scene;
    private NetworkAccessLayer networkAccessLayer;

    @Override
    public void start(Stage stage) throws Exception {
        networkAccessLayer = NetworkAccessLayer.getInstance();

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");


        Parent root = new HomePageController(stage);
        scene = new Scene(root);
        stage.setTitle(Strings.APP_NAME);
        stage.getIcons().add(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toString()));
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest((WindowEvent event) -> {
            networkAccessLayer.exitApplication();
            stage.close();
            Platform.exit();
        });
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
    
}
