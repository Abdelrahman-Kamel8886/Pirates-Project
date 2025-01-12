package piratesproject;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.models.UserModel;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.BackgroundMusic;

import piratesproject.utils.SharedModel;
public class Main extends Application {

    private static Scene scene ;
    
    @Override
    public void start(Stage stage) throws Exception {
        UserModel user = new UserModel();
        user.setFirstName("Abdelrahman");
        user.setLastName("Kamel");
        user.setGamesPlayed(16);
        user.setScore(10);
        user.setUserName("abdokamel8886");
        SharedModel.setUser(user);
        
        stage.setFullScreen(true);


        Parent root = new HomePageController(stage);
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
    
    
    
    public static void resetScene(Parent p){
        scene.setRoot(p);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
