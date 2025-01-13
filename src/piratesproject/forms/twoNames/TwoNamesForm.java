package piratesproject.forms.twoNames;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class TwoNamesForm {
     private static Stage window;

    public static void display(Stage owner){

        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.WINDOW_MODAL);
        window.setTitle("Enter Players Names");
        window.setResizable(false);
       // window.getIcons().add(new Image(getClass().getResource(Pathes.SETTINGS_LOGO_PATH).toString()));

        Parent root = new TwoNamesController(owner);

        Scene scene = new Scene(root,600,400);
        window.setScene(scene);

        window.show();
    }
    
    public static void closeForm(){
        window.close();
    }

}
