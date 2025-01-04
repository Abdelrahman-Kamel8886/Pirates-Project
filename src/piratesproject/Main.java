package piratesproject;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import piratesproject.ui.home.FXMLController;
import piratesproject.utils.Consts;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new FXMLController(stage);
        
        Scene scene = new Scene(root);
        stage.setTitle(Consts.APP_NAME);
        
        stage.getIcons().add(new Image(getClass().getResource(Consts.APP_LOGO_PATH).toString()));
        
        stage.setScene(scene);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
