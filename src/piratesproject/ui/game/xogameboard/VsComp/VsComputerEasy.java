/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.game.xogameboard.VSComp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import piratesproject.ui.game.minmaxalgorithim.State;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.enums.GameMovesEnum;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.enums.VideoTypeEnum;
import piratesproject.forms.draw.DrawForm;
import piratesproject.models.MoveModel;
import piratesproject.models.Player;
import piratesproject.models.RecordModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.FileHandler;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class VsComputerEasy extends XOGameBoard {

    private RecordModel gameRecord;
    private ArrayList<MoveModel> moves;
    private String[][] board;
    private Button[][] buttons;
    private Player player1, player2, currentPlayer, winner;
    private String name1, name2 = "computer(EASY)";
    private String firstPlayer, secondPlayer;
    Thread minMaxthread;
    Stage stage;
    private final int SIZE = 3;
    private String movesSequnce, line;
    private NetworkAccessLayer networkAccessLayer;
    boolean recordFlag = false;

    public VsComputerEasy(Stage stage) {
        super(stage);
        networkAccessLayer = NetworkAccessLayer.getInstance();
        if(SharedModel.getUser()!=null){
            networkAccessLayer.sentAvilableState(1);
        }
        if(SharedModel.getUser()==null){
            name1 = "Guest";
        }
        else{
           name1 = SharedModel.getUser().getUserName(); 
        }
        initGame();
    }
    


    private void initGame() {
        playerOneLabel.setText(name1 + " : ( X )");
        playerTwoLabel.setText(name2 + " ( O )");
        player1 = new Player(name1, GameMovesEnum.X.name());
        player2 = new Player(name2, GameMovesEnum.O.name());
        currentPlayer = player1;
        buttons = new Button[SIZE][SIZE];
        board = new String[SIZE][SIZE];
        moves = new ArrayList();
        gameRecord = new RecordModel(player1, player2);
        backIcon.setVisible(true);
        initButtons();
        resetBoard();
        onClicks();
        drawSuccesslines();

    }
    
    

    private void initButtons() {
        buttons[0][0] = btnGrid_0_0;
        buttons[0][1] = btnGrid_0_1;
        buttons[0][2] = btnGrid_0_2;
        buttons[1][0] = btnGrid_1_0;
        buttons[1][1] = btnGrid_1_1;
        buttons[1][2] = btnGrid_1_2;
        buttons[2][0] = btnGrid_2_0;
        buttons[2][1] = btnGrid_2_1;
        buttons[2][2] = btnGrid_2_2;
    }

    private void onClicks() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setOnAction((ActionEvent event) -> {
                    playerMove(row, col);
                    String winCondition = checkWin(row, col);
                    if (winCondition == null) {
                        computerMove();
                        return;
                    } else {
                        drawWinLine(winCondition);
                    }

                });
            }
        }
        backIcon.setOnMouseClicked((Event event) -> {
            gotoHome();
        });
//        record.setOnAction((ActionEvent event) -> {
//            //saveRecordToFile();
//            if(recordFlag){
//                recordFlag=false;
//            }
//            else{
//                recordFlag=true;
//            }
//        });
    }

    private void playerMove(int row, int col) {
        if (board[row][col].isEmpty()) {
            board[row][col] = currentPlayer.getSymbol();
            buttons[row][col].setText(currentPlayer.getSymbol());
            moves.add(new MoveModel(row, col, currentPlayer.getSymbol()));
            String winCondition = checkWin(row, col);
            line = winCondition != null ? winCondition : "none";
            winner = winCondition != null ? currentPlayer : null;
            saveRecord();
            if (winCondition != null) {
                drawWinLine(winCondition);
                saveRecordToFile();
                return;
            }
            if (isDraw()) {
                currentPlayer = null;
                disableAllButtons();
                saveRecordToFile();
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> showVideo(VideoTypeEnum.DRAW)); // Show the video after the pause
                pause.play(); // Start the pause
                return;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private List<int[]> getEmptyButtons() {
        List<int[]> emptyButtons = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].isEmpty()) {
                    emptyButtons.add(new int[]{i, j});
                }
            }
        }
        return emptyButtons;
    }

    private void computerMove() {
        List<int[]> emptyButtons = getEmptyButtons();
        Random move = new Random();
        move.nextInt(emptyButtons.size());
        int[] selectedMove = emptyButtons.get(move.nextInt(emptyButtons.size())); // Select a random empty cell.
        int row = selectedMove[0];
        int col = selectedMove[1];

            playerMove(row, col);
            return;
        
    }

    private String checkWin(int row, int col) {
        String symbol = currentPlayer.getSymbol();

        if (board[row][0].equals(symbol) && board[row][1].equals(symbol) && board[row][2].equals(symbol)) {
            return "ROW-" + row;
        }
        if (board[0][col].equals(symbol) && board[1][col].equals(symbol) && board[2][col].equals(symbol)) {
            return "COL-" + col;
        }
        if (row == col && board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return "DIAG-PRIMARY";
        }
        if (row + col == SIZE - 1 && board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            return "DIAG-SECONDARY";
        }
        return null;
    }

    private boolean isDraw() {
        for (String[] row : board) {
            for (String cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "";
                buttons[i][j].setText("");
            }
        }
    }

    private void drawWinLine(String winCondition) {
        switch (winCondition) {
            case "ROW-0":
                line1.setVisible(true);
                break;
            case "ROW-1":
                line3.setVisible(true);
                break;
            case "ROW-2":
                line4.setVisible(true);
                break;
            case "COL-0":
                line5.setVisible(true);
                break;
            case "COL-1":
                line6.setVisible(true);
                break;
            case "COL-2":
                line7.setVisible(true);
                break;
            case "DIAG-PRIMARY":
                line2.setVisible(true);
                break;
            case "DIAG-SECONDARY":
                line8.setVisible(true);
                break;
        }
        disableAllButtons();
        if (currentPlayer==player2) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> showVideo(VideoTypeEnum.LOSS)); // Show the video after the pause
            pause.play(); // Start the pause
        } else {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> showVideo(VideoTypeEnum.WIN)); // Show the video after the pause
            pause.play(); // Start the pause
        }

    }

    private void showVideo(VideoTypeEnum videoType) {
        
        DrawForm drawBase = new DrawForm(LevelTypesEnum.Easy);
        switch (videoType) {
            case WIN:
                drawBase.display(stage, Pathes.WIN_VEDIO_PATH); // Use the correct path for the win video
                break;
            case LOSS:
                drawBase.display(stage, Pathes.LOSS_VEDIO_PATH); // Use the correct path for the loss video
                break;
            case DRAW:
                drawBase.display(stage, Pathes.DRAW_VEDIO_PATH); // Use the correct path for the draw video
                break;
        }
    }

    private void disableAllButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setDisable(true);
            }
        }
    }

    private void saveRecord() {
        movesSequnce = JsonUtils.movesArrayToJson(moves);
        gameRecord.setWinner(winner);
        gameRecord.setGameSequance(movesSequnce);
        gameRecord.setLine(line);
        SharedModel.setSelectedRecord(gameRecord);
    }

    public void gotoHome() {
        Parent homePage = new HomePageController(stage);
        Main.resetScene(homePage);
    }

    private void saveRecordToFile() {
        if(recordButton.getState()){
           String record = JsonUtils.recordModelToJson(gameRecord);
           FileHandler.appendToFile(record); 
        }

    }
}
