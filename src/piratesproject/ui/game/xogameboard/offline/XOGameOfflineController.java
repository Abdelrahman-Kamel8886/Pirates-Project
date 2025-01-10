package piratesproject.ui.game.xogameboard.offline;

import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import piratesproject.ui.game.xogameboard.XOGameBoard;
public class XOGameOfflineController extends XOGameBoard {

    public void showWinState() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:///C:/Users/Taj/Desktop/youWin.mp4"));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

    }
    public XOGameOfflineController(Stage stage) {
        super(stage);

        btnGrid_0_0.setOnAction((ActionEvent event) -> {
            drawSuccesslines();
            getChildren().add(mediaView);
            showWinState();
        });
    }

}
