/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.lodinanimation;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.forms.sendinvitatation.SendInvitationFormController;

/**
 *
 * @author Taj
 */
public class LodingAnimationHandler {
private static Stage window;
    
    public static void displayLoding(Stage owner){
        
        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.WINDOW_MODAL);
        window.setTitle("Send Invitation ? ");
        window.setResizable(false);
        //window.getIcons().add(new Image(getClass().getResource(Pathes.SETTINGS_LOGO_PATH).toString()));
        Parent root = new LodingAnimationController();
        
        Scene scene = new Scene(root);
        window.setScene(scene);
        
        window.show();     
    }
    
}
