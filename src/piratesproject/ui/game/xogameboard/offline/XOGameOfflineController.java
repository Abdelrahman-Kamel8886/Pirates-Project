package piratesproject.ui.game.xogameboard.offline;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import piratesproject.ui.game.minmaxalgorithim.AdversarialSearchTicTacToe;
import piratesproject.ui.game.minmaxalgorithim.State;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.enums.GameMovesEnum;
import piratesproject.models.MoveModel;
import piratesproject.models.Player;
import piratesproject.models.RecordModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.replay.ReplayController;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.game.xogameboard.XOGameBoard1111;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.FileHandler;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class XOGameOfflineController extends XOGameBoard {

    private Player player1, player2, currentPlayer, winner;
    private String name1, name2, firstPlayer, secondPlayer;
    private String movesSequnce, line;
    private RecordModel gameRecord;
    private ArrayList<MoveModel> moves;

    private String[][] board;
    private Button[][] buttons;

    private final int SIZE = 3;

    private Stage stage;
    Thread minMaxthread;
    private NetworkAccessLayer networkAccessLayer;

    public XOGameOfflineController(Stage stage) {
        super(stage);
        this.stage = stage;
        networkAccessLayer = NetworkAccessLayer.getInstance();
        if (SharedModel.getUser() != null) {
            networkAccessLayer.sentAvilableState(1);
        }
        initView();
    }

    private void initView() {
        name1 = SharedModel.getPlayerName1();
        name2 = SharedModel.getPlayerName2();
        line = "none";
        setPlayersRandomly();
        drawSuccesslines();
        initGame();

    }

    private void setPlayersRandomly() {
        if (Math.random() < 0.5) {
            firstPlayer = name1;
            secondPlayer = name2;
        } else {
            firstPlayer = name2;
            secondPlayer = name1;
        }
        playerOneLabel.setText(firstPlayer + " : ( X )");
        playerTwoLabel.setText(secondPlayer + " ( O )");
    }

    private void initGame() {
        player1 = new Player(firstPlayer, GameMovesEnum.X.name());
        player2 = new Player(secondPlayer, GameMovesEnum.O.name());
        currentPlayer = player1;
        buttons = new Button[SIZE][SIZE];
        board = new String[SIZE][SIZE];
        moves = new ArrayList();
        gameRecord = new RecordModel(player1, player2);
        initButtons();
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
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                gotoHome();
            }
        });
        backIcon.setOnMouseClicked((Event event) -> {
            gotoHome();
        });
        record.setOnAction((ActionEvent event) -> {
            saveRecordToFile();
        });
    }

    public void makeMove(int row, int col) {
        if (board[row][col].isEmpty()) {
            board[row][col] = currentPlayer.getSymbol();
            buttons[row][col].setText(currentPlayer.getSymbol());
            moves.add(new MoveModel(row, col, currentPlayer.getSymbol()));
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

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private String checkWin(int row, int col) {
        String symbol = currentPlayer.getSymbol();
        String result = null;
        

        if (board[row][0].equals(symbol) && board[row][1].equals(symbol) && board[row][2].equals(symbol)) {
            result= "ROW-" + row;
        }
        if (board[0][col].equals(symbol) && board[1][col].equals(symbol) && board[2][col].equals(symbol)) {
            result= "COL-" + col;
        }
        if (row == col && board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            result= "DIAG-PRIMARY";
        }
        if (row + col == SIZE - 1 && board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            result= "DIAG-SECONDARY";
        }
        winner = result != null ? currentPlayer : null;
        return result;
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
        disableAllButtons();

    }

    private void disableAllButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setDisable(true);
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Game Over");
        if (winner != null) {
            alert.setHeaderText("Wineeeeer is : " + winner.getName());

        } else {
            alert.setHeaderText("Game Over in Draw");
        }
        alert.setContentText(null);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            gotoHome();
        }

    }

    private void saveRecord() {
        movesSequnce = JsonUtils.movesArrayToJson(moves);
        gameRecord.setWinner(winner);
        gameRecord.setGameSequance(movesSequnce);
        gameRecord.setLine(line);
        SharedModel.setSelectedRecord(gameRecord);
    }

    private void saveRecordToFile() {
        String record = JsonUtils.recordModelToJson(gameRecord);
        FileHandler.appendToFile(record);

    }

    public void gotoHome() {
        Parent homePage = new HomePageController(stage);
        Main.resetScene(homePage);
    }

}
