/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.game.replay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.home.HomePageController;

/**
 * FXML Controller class
 *
 * @author Abram
 */
public class ReplayController extends ReplayBase  {

    public ReplayController(Stage stage) {
        super(stage);
        initView();
    }
    public void initView()
    {
        onClick();
    }
    public void onClick()
    {
        
       backButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              gotoHome();
           }
       });
    }
        public void gotoHome() {
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }
}
