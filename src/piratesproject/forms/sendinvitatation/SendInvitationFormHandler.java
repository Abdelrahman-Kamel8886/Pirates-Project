package piratesproject.forms.sendinvitatation;

import piratesproject.forms.Settings.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;



public class SendInvitationFormHandler {

    private static Stage window;
    private static Scene scene ; 
    
    public static void display(Stage owner1){
        
        window = new Stage();
        window.initOwner(Main.mainStage);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Send Invitation ? ");
        window.setResizable(false);
        //window.getIcons().add(new Image(getClass().getResource(Pathes.SETTINGS_LOGO_PATH).toString()));
        Parent root = new SendInvitationFormController(Main.mainStage);
        
         scene = new Scene(root);
        window.setScene(scene);
        
        window.show();     
    }
    public static void closeForm(){
        window.close();
    }
    public static void  resetScene(Parent p ){
        scene.setRoot(p);
    }
         
}
