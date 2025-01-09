/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Abram
 */
public class StormAlert {

    
    private void alert(AlertType type,String title,String content){
        Alert alert =new Alert(type);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.show();
    }
    private void showAlertConfirmation()
            { 
                alert(AlertType.CONFIRMATION,"confirm","confirmation");
            }
    private void showAlertError()
    {
    alert(AlertType.ERROR,"Error","Error");
    }
    private void showAlertInformation()
    {
    alert(AlertType.INFORMATION,"INFORMATION","INFORMATION");
    }
    private void showAlertWarning()
    {
    alert(AlertType.WARNING,"WARNING","WARNING");
    }
        private void showAlertNone()
    {
    alert(AlertType.NONE,"NONE","NONE");
    }
}
