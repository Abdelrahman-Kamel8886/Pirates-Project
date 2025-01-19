package piratesproject.forms.twoNames;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;


public class TwoNamesForm {
     private static Stage window;

    public void display(Stage owner1){

        window = new Stage();
        window.initOwner(Main.mainStage);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Enter Players Names");
        window.setResizable(false);
        window.getIcons().add(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toString()));

        Parent root = new TwoNamesController(Main.mainStage);

        Scene scene = new Scene(root,600,400);
        window.setScene(scene);

        window.show();
    }
    
    public static void closeForm(){
        window.close();
    }

}
