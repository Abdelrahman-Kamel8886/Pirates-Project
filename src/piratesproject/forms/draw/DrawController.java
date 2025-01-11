/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.draw;

import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.ui.home.HomePageController;


public class DrawController extends DrawBase {

    private final Stage mystage;

    public DrawController(Stage myStage) {
        this.mystage = myStage;
        listenToAllEvent();
    }

    private void listenToAllEvent() {
        exitB.setOnAction(event -> exitToHome());
        playAgainB.setOnAction(event -> goToXOPageToPlayAgin());
    }

    private void goToXOPageToPlayAgin() {
        mediaPlayer.stop();
        Parent XOgame = new XOGameOfflineController(mystage);
        Main.resetScene(XOgame);
    }

    private void exitToHome() {
        mediaPlayer.stop();
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }
}
