/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.draw;

import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.ui.game.xogameboard.VSComp.VsComputerEasy;
import piratesproject.ui.game.xogameboard.VsCompHard.VsCompHard;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.SharedModel;

public class DrawController extends DrawBase {

    private final Stage mystage;
    LevelTypesEnum level ; 
    public DrawController(Stage myStage, String path) {
        super(path);
        this.level = SharedModel.getSelectedLevel();
        this.mystage = myStage;
        listenToAllEvent();

    }

    private void listenToAllEvent() {
        exitB.setOnAction(event -> exitToHome());
        if(SharedModel.getGameRoom()==null){
        playAgainB.setOnAction(event -> goToXOPageToPlayAgin());
        }else{
            playAgainB.setVisible(false);
        }
    }

    private void goToXOPageToPlayAgin() {
        getMediaPlayer().stop();
        mediaPlayer.stop();
         
        if(level == LevelTypesEnum.Easy){
            Parent XOgame = new VsComputerEasy(mystage);
            Main.resetScene(XOgame);
        }
        else if(level == LevelTypesEnum.Hard){
            Parent XOgame = new VsCompHard(mystage);
            Main.resetScene(XOgame);
        } else {
               Parent XOgame = new VsComputerEasy(mystage);
            Main.resetScene(XOgame);
        }
        DrawForm.closeForm();

    }

    private void exitToHome() {
        getMediaPlayer().stop();
        mediaPlayer.stop();
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
        DrawForm.closeForm();
    }
}
