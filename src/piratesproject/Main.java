package piratesproject;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import piratesproject.utils.Consts;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new BorderPane();
        Scene scene = new Scene(root);
        stage.setTitle(Consts.APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
