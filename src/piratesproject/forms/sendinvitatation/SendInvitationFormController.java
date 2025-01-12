/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.sendinvitatation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piratesproject.forms.lodinanimation.LodingAnimationController;
import piratesproject.forms.lodinanimation.LodingAnimationHandler;

/**
 * FXML Controller class
 *
 * @author jaila
 */
public class SendInvitationFormController extends SendInvitationForm {

    public SendInvitationFormController(Stage stage) {
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
               Parent root = new LodingAnimationController();
                SendInvitationFormHandler.resetScene(root);       
            }
        });
    }    
}
