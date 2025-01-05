package piratesproject;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import piratesproject.ui.home.FXMLController;
import piratesproject.ui.login.LoginController;
import piratesproject.ui.reg.RegisterController;
import piratesproject.utils.Consts;


public class Main extends Application {

    private static Scene scene ;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setFullScreen(true);
        Parent root = new LoginController(stage);
        scene = new Scene(root);
        stage.setTitle(Consts.APP_NAME);
        stage.getIcons().add(new Image(getClass().getResource(Consts.APP_LOGO_PATH).toString()));
        stage.setScene(scene);

        stage.show();

    }
    
    public static void resetScene(Parent p){
        scene.setRoot(p);
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }

}
