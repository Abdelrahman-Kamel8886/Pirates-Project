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
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;

/**
 *
 * @author Admin
 */
public class LevelForm {

    private static Stage window;

    public void display(Stage owner1) {

        window = new Stage();
        window.initOwner(Main.mainStage);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Levels");
        window.setResizable(false);
        window.getIcons().add(new Image(getClass().getResource(Pathes.APP_LOGO_PATH).toString()));

        Parent root = new LevelController(Main.mainStage);

        Scene scene = new Scene(root, 400, 400);
        window.setScene(scene);

        window.show();
    }

    public static void closeForm() {
        window.close();
    }

}
