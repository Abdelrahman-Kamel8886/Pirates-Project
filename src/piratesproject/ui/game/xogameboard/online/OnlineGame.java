package piratesproject.ui.game.xogameboard.online;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.GameModel;
import piratesproject.models.MoveModel;
import piratesproject.models.Player;
import piratesproject.models.RecordModel;
import piratesproject.models.ResponseModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.replay.ReplayController;
import piratesproject.ui.game.xogameboard.XOGameBoard1111;
import piratesproject.utils.FileHandler;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class OnlineGame extends XOGameBoard1111 implements NetworkResponseHandler {

    private Player player1, player2, currentPlayer, me;
    private String name1, name2, opponent, secondPlayer;
    private String movesSequnce, line;
    private RecordModel gameRecord;
    private ArrayList<MoveModel> moves;
    private String oponnetUserName;
    private String[][] board;
    private Button[][] buttons;
    private NetworkAccessLayer networkAccessLayer;
    private boolean gameOver;

    private final int SIZE = 3;

    private Stage stage;
    Thread minMaxthread;

    public OnlineGame(Stage stage) {
        super(stage);
        this.stage = stage;
        buttons = new Button[SIZE][SIZE];
        board = new String[SIZE][SIZE];
        moves = new ArrayList();
        gameOver = false;
        networkAccessLayer = NetworkAccessLayer.getInstance();
        networkAccessLayer.setResponseHandler(this);

        initView();
    }

    private void initView() {
        name1 = SharedModel.getPlayerName1();
        name2 = SharedModel.getPlayerName2();
        line = "none";
        drawSuccesslines();
        initButtons();
        initGame();

    }

    private void initGame() {
        player1 = SharedModel.getGameRoom().getPlayer1();
        player2 = SharedModel.getGameRoom().getPlayer2();
        System.out.println(player1.getName() + " : " + player2.getName());
        currentPlayer = player1;
        playerOneLabel.setText(player1.getName() + " : ( X )");
        playerTwoLabel.setText(player2.getName() + " ( O )");
        if (player1.getName().equals(SharedModel.getUser().getUserName())) {
            me = player1;
            oponnetUserName = player2.getName();
            enableAllButtons();
        } else {
            me = player2;
            oponnetUserName = player1.getName();
            disableAllButtons();
        }

        gameRecord = new RecordModel(player1, player2);
        resetBoard();
        onClicks();
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
                    makeMove(row, col);

                });
            }
        }
    }

    public void makeMove(int row, int col) {
        if (board[row][col].isEmpty()) {
            board[row][col] = currentPlayer.getSymbol();
            buttons[row][col].setText(currentPlayer.getSymbol());

            MoveModel move = new MoveModel(row, col, currentPlayer.getSymbol());
            moves.add(move);
            
            if(currentPlayer.equals(me)){
                GameModel gameModel = new GameModel(oponnetUserName, move);
                networkAccessLayer.sendMove(gameModel);
            }
           
            String winCondition = checkWin(row, col);
            line = winCondition != null ? winCondition : "none";
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
                return;
            }
            switchPlayer();
        }
    }

//    public void getMove() {
//
//        MoveModel move = NetworkAccessLayer.getMove();
//        if (move != null) {
//            makeMove(move.getRow(), move.getCol());
//        }
//       
//
//    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        if (currentPlayer == me) {
            enableAllButtons();
        } else {
            disableAllButtons();
        }
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
        gameOver = true;
        return true;
    }

    private void resetBoard() {
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
        gameOver = true;
        disableAllButtons();

    }

    private void disableAllButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setDisable(true);
            }
        }
    }

    private void enableAllButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setDisable(false);
            }
        }
    }

    private void saveRecord() {
        movesSequnce = JsonUtils.movesArrayToJson(moves);
        gameRecord.setWinner(currentPlayer);
        gameRecord.setGameSequance(movesSequnce);
        gameRecord.setLine(line);
        SharedModel.setSelectedRecord(gameRecord);
        System.out.println(gameRecord.toString());
    }

    private void saveRecordToFile() {
        String record = JsonUtils.recordModelToJson(gameRecord);
        FileHandler.appendToFile(record);

    }

    private void goToReplay() {
        Parent replay = new ReplayController(stage);
        Main.resetScene(replay);
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        if (response.getType() == RequestTypesEnum.GAMEMOVE) {
            System.out.println("44444444444");
            String gameMovejson = response.getData();
            MoveModel move = JsonUtils.jsonToGameMove(gameMovejson);
            System.out.println(gameMovejson);
            if (move != null) {
                makeMove(move.getRow(), move.getCol());
                if(!gameOver){
                    enableAllButtons();
                }
                
            }

        }

    }

}