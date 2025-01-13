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

    }

    private void EraseMove() {
        MoveModel currentMove = moves.get(currentIndex);
        int row = currentMove.getRow();
        int col = currentMove.getCol();
        buttons[row][col].setText("");
        currentIndex--;

    }

    public void gotoHome() {
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }

}
