package piratesproject.ui.game.replay;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.models.MoveModel;
import piratesproject.models.RecordModel;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class ReplayController extends ReplayBase {

    private Button[][] buttons;
    private ArrayList<MoveModel> moves;
    private final int SIZE = 3;

    private int currentIndex;

    public ReplayController(Stage stage) {
        super(stage);
        intitView();
    }

    private void intitView() {
        RecordModel record = SharedModel.getSelectedRecord();
        moves = JsonUtils.jsonToMovesArray(record.getGameSequance());
        buttons = new Button[SIZE][SIZE];
        currentIndex = -1;
        String name1 = SharedModel.getSelectedRecord().getPlayer1().getName();
        String name2 = SharedModel.getSelectedRecord().getPlayer2().getName();

        Player1Label.setText(name1 + " ( X )");
        Player2Label.setText(name2 + " ( O )");

        if (SharedModel.getSelectedRecord().getWinner() != null) {
            if (SharedModel.getSelectedRecord().getWinner().getName().equals(SharedModel.getSelectedRecord().getPlayer1().getName())) {
                label.setText("W");
                label0.setText("L");
                label.setStyle("-fx-text-fill: green;");
                label0.setStyle("-fx-text-fill: red;");
            } else {
                label0.setText("W");
                label.setText("L");
                label0.setStyle("-fx-text-fill: green;");
                label.setStyle("-fx-text-fill: red;");
            }
        }
        drawSuccesslines();

        initButtons();
        onClicks();
    }

    private void initButtons() {
        buttons[0][0] = Grid_1;
        buttons[0][1] = Grid_2;
        buttons[0][2] = Grid_3;
        buttons[1][0] = Grid_4;
        buttons[1][1] = Grid_5;
        buttons[1][2] = Grid_6;
        buttons[2][0] = Grid_7;
        buttons[2][1] = Grid_8;
        buttons[2][2] = Grid_9;
    }

    private void onClicks() {
        playButton.setOnAction((ActionEvent event) -> {
            next();
        });
        pauseButton.setOnAction((ActionEvent event) -> {
            previous();
        });
        backButton.setOnAction((ActionEvent event) -> {
            gotoHome();
        });
    }

    private void next() {
        if (currentIndex < moves.size() - 1) {
            currentIndex++;
            drawMove();
        }
    }

    private void previous() {
        if (currentIndex > -1) {
            EraseMove();
        }
    }

    private void drawMove() {
        MoveModel currentMove = moves.get(currentIndex);
        int row = currentMove.getRow();
        int col = currentMove.getCol();
        String symbol = currentMove.getSymbol();
        buttons[row][col].setText(symbol);
        if (currentIndex == moves.size() - 1) {
            System.out.println("line " + SharedModel.getSelectedRecord().getLine());
            drawWinLine(SharedModel.getSelectedRecord().getLine());
            disableAllButtons();
        }

    }

    private void EraseMove() {
        MoveModel currentMove = moves.get(currentIndex);
        int row = currentMove.getRow();
        int col = currentMove.getCol();
        buttons[row][col].setText("");
        currentIndex--;

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

    }

    private void disableAllButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int row = i, col = j;
                buttons[i][j].setDisable(true);
            }
        }
        pauseButton.setDisable(true);
        playButton.setDisable(true);
    }

    public void gotoHome() {
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }

}
