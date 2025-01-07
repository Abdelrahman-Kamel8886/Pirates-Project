package piratesproject.forms.Settings;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.drawable.values.Pathes;


public class SettingsForm {
    
    private static Stage window;
    
    public void display(Stage owner){
        
        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.WINDOW_MODAL);
        window.setTitle("Settings");
        window.setResizable(false);
        window.getIcons().add(new Image(getClass().getResource(Pathes.SETTINGS_LOGO_PATH).toString()));

        Parent root = new ProfileController();
        
        Scene scene = new Scene(root,800,600);
        window.setScene(scene);
        
        window.show();     
    }
         
}
