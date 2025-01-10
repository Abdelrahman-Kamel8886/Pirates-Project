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
import piratesproject.ui.xogameboard.XOGameBoard;

/**
 * FXML Controller class
 *
 * @author Abram
 */
public class TwoNamesController extends TwoNamesBase {
private final Stage myStage;
    public TwoNamesController(Stage stage) {
        this.myStage = stage;
        listen();
        
    }
    
    /**
     * Initializes the controller class.
     */
    private void listen()
    {
                button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            goToGame();
            }
        });
    }
     private void goToGame() {
        
        Parent game = new XOGameBoard(myStage);
        Main.resetScene(game);
        TwoNamesForm.closeForm();
    }
    
}
