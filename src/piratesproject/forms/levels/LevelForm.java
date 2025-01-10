/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.levels;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class LevelForm {
     private static Stage window;

    public static void display(Stage owner){

        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.WINDOW_MODAL);
        window.setTitle("Levels");
        window.setResizable(false);
        

        Parent root = new LevelController(owner);

        Scene scene = new Scene(root,400,400);
        window.setScene(scene);

        window.show();
    }
    
    public static void closeForm(){
        window.close();
    }

}
