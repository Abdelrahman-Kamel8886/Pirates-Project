package piratesproject.ui.xogameboard;

import piratesproject.ui.xogameboard.XOGameBoard;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.win.WinScreenController;
import static piratesproject.utils.Consts.GRID_BTN_HEIGTH;
import static piratesproject.utils.Consts.GRID_BTN_WIGTH;
import static piratesproject.utils.Consts.GRID_X_0_0;
import static piratesproject.utils.Consts.GRID_Y_0_0;

/**
 *
 * @author Taj
 */
public class XOGameController extends XOGameBoard {

    public void showWinState() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:///C:/Users/Taj/Desktop/youWin.mp4"));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

    }

    public void drawSuccesslines() {
        btnGrid_0_0.setText("X");

        btnGrid_0_0.setStyle("-fx-border-color: green; -fx-border-width: 6px; -fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");

        Line line1 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2, GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2);
        line1.setStrokeWidth(20);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);

        Line line2 = new Line(GRID_X_0_0, GRID_Y_0_0, GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line2.setStrokeWidth(20);
        line2.setStroke(Color.GREEN);
        getChildren().add(line2);

        Line line3 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6));
        line3.setStrokeWidth(20);
        line3.setStroke(Color.GREEN);
        getChildren().add(line3);

        Line line4 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6));
        line4.setStrokeWidth(20);
        line4.setStroke(Color.GREEN);
        getChildren().add(line4);

        Line line5 = new Line(GRID_X_0_0 + (.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line5.setStrokeWidth(20);
        line5.setStroke(Color.GREEN);
        getChildren().add(line5);

        Line line6 = new Line(GRID_X_0_0 + (1.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (1.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line6.setStrokeWidth(20);
        line6.setStroke(Color.GREEN);
        getChildren().add(line6);

        Line line7 = new Line(GRID_X_0_0 + (2.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (2.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line7.setStrokeWidth(20);
        line7.setStroke(Color.GREEN);
        getChildren().add(line7);

        Line line8 = new Line(GRID_X_0_0 + (3 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line8.setStrokeWidth(20);
        line8.setStroke(Color.GREEN);
        getChildren().add(line8);
    }

    public XOGameController(Stage stage) {
        super(stage);

        btnGrid_0_0.setOnAction((ActionEvent event) -> {
            drawSuccesslines();
            getChildren().add(mediaView);
            showWinState();
        });
    }

}
