/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.levels;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.xogameboard.XOGameBoard;

/**
 *
 * @author Admin
 */
public class LevelController extends LevelsBase {

    private final Stage mystage;

    public LevelController(Stage stage) {
        mystage = stage;
        listenToAllEvents();
    }

    private void listenToAllEvents() {
        playb.setOnAction(event -> goToXOPage());
    }

    private void goToXOPage() {
        System.out.println("nnnn");
        Parent XOgame = new XOGameBoard(mystage);
        Main.resetScene(XOgame);
        LevelForm.closeForm();
    }
}
