/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.game.xogameboard.VSComp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import piratesproject.enums.GameMovesEnum;
import piratesproject.models.Player;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.game.xogameboard.offline.XOGameOfflineController;

/**
 *
 * @author Admin
 */
public class VsComputer extends XOGameBoard {

    private String[][] board;
    private Button[][] buttons;
    private Player player1, player2, currentPlayer;
    private String name1 = "nour", name2 = "computer";    //private String playerSymbol = "x", computerSymbol = "o";

    private final int SIZE = 3;

    public VsComputer(Stage stage) {
        super(stage);
        initGame();
    }

    private void initGame() {
        player1 = new Player(name1, GameMovesEnum.X.name());
        player2 = new Player(name2, GameMovesEnum.O.name());
        currentPlayer = player1;
        buttons = new Button[SIZE][SIZE];
        board = new String[SIZE][SIZE];
        //initButtons();
       // resetBoard();
       // onClicks();
    }



}
