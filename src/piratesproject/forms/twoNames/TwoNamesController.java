/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.twoNames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;
import piratesproject.utils.SharedModel;

/**
 * FXML Controller class
 *
 * @author Abram
 */
public class TwoNamesController extends TwoNamesBase {

    private final Stage myStage;

    public TwoNamesController(Stage stage) {
        this.myStage = stage;
        initView();

    }

    private void initView() {
        String name = "Guest";
        if (SharedModel.getUser() != null) {
            name = SharedModel.getUser().getUserName();
        }
        playerOneTextField.setText(name);
        SharedModel.setPlayerName1(name);
        playerOneTextField.setDisable(true);
        listen();
    }

    private void listen() {
        button.setOnAction((ActionEvent event) -> {
            validation();
        });
    }
    
    private void validation(){
        if(!playerTwoTextField.getText().isEmpty()){
            SharedModel.setPlayerName2(playerTwoTextField.getText());
            goToGame();
        }
    }

    private void goToGame() {

        Parent game = new XOGameOfflineController(myStage);
        Main.resetScene(game);
        TwoNamesForm.closeForm();
    }

}
