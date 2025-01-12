/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.levels;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.utils.SharedModel;

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
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int value = newValue.intValue();
            switch (value) {
                case 0:
                    setEasy();
                    break;
                case 1:
                    setNormal();
                    break;
                case 2:
                    setHard();
                    break;
            }
            image1.setFitHeight(160.0);
            image1.setFitWidth(160.0);
        });
    }

    private void goToXOPage() {
        Parent XOgame = new XOGameOfflineController(mystage);
        Main.resetScene(XOgame);

        LevelForm.closeForm();
    }

    private void setEasy() {
        easy.setText(Strings.DIFFICULTY_EASY_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.EASY_LOGO_PATH).toExternalForm())); // Easy image
        SharedModel.setSelectedLevel(LevelTypesEnum.Easy);
    }

    private void setNormal() {
        easy.setText(Strings.DIFFICULTY_NORMAL_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.NORMAL_LOGO_PATH).toExternalForm())); // Normal image
        SharedModel.setSelectedLevel(LevelTypesEnum.Normal);
    }

    private void setHard() {
        easy.setText(Strings.DIFFICULTY_HARD_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.HARD_LOGO_PATH).toExternalForm())); // Hard image
        SharedModel.setSelectedLevel(LevelTypesEnum.Hard);
    }
}
