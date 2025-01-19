/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.levels;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.ui.game.xogameboard.VSComp.VsComputerEasy;
import piratesproject.ui.game.xogameboard.VsCompHard.VsCompHard;
import piratesproject.ui.game.xogameboard.XOGameBoard1111;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.utils.SharedModel;

/**
 *
 * @author Admin
 */
public class LevelController extends LevelsBase {

    private final Stage mystage;
    private LevelTypesEnum level;

    public LevelController(Stage stage) {
        mystage = stage;
        listenToAllEvents();
    }

    private void listenToAllEvents() {
        playb.setOnAction(event -> {
            SharedModel.setSelectedLevel(level);
            if(level==LevelTypesEnum.Easy){
                goToXOPageEasy();
            }
            else if(level==LevelTypesEnum.Normal){
                goToXOPageEasy();
            }
            else{
                goToXOPageHard();
            }
             LevelForm.closeForm();
        });
        slider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            // Snap to the nearest integer
            double roundedValue = Math.round(newValue.doubleValue());
            slider.setValue(roundedValue);

            // Update the label based on slider value
            switch ((int) roundedValue) {
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
        });

        image1.setFitHeight(200.0);
        image1.setFitWidth(200.0);

    }

    private void goToXOPageEasy() {
        Parent XOgame = new VsComputerEasy(mystage);
        Main.resetScene(XOgame);
    }
    
        private void goToXOPageHard() {
        Parent XOgame = new VsCompHard(mystage);
        Main.resetScene(XOgame);
    }

    private void setEasy() {
        easy.setText(Strings.DIFFICULTY_EASY_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.EASY_LOGO_PATH).toExternalForm())); // Easy image
        level = LevelTypesEnum.Easy;
    }

    private void setNormal() {
        easy.setText(Strings.DIFFICULTY_NORMAL_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.NORMAL_LOGO_PATH).toExternalForm())); // Normal image
        level = LevelTypesEnum.Normal;
    }

    private void setHard() {
        easy.setText(Strings.DIFFICULTY_HARD_TEXT);
        image1.setImage(new Image(getClass().getResource(Pathes.HARD_LOGO_PATH).toExternalForm())); // Hard image
        level = LevelTypesEnum.Hard;
    }
}
