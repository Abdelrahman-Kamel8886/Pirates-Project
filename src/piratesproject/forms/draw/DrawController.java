/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.draw;

import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.home.HomePageController;

/**
 *
 * @author Admin
 */
public class DrawController extends DrawBase{
    private final Stage mystage;

    public DrawController(Stage myStage) {
        this.mystage = myStage;
        listenToAllEvent();
    }
    public void listenToAllEvent(){
        exitB.setOnAction(event -> exitToHome());
    }

    private void exitToHome() {
        mediaPlayer.stop();
         Parent homePage = new HomePageController(mystage);
         Main.resetScene(homePage);
    }
}
