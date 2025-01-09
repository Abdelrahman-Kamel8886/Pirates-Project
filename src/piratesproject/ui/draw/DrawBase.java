package piratesproject.ui.draw;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public class DrawBase extends StackPane {

    protected final VBox vBox;
    protected final Button playAgainB;
    protected final Button exitB;
    private final MediaView mediaView;

    public DrawBase() {
        // Create a Media object for the video
        String videoPath = getClass().getResource("/piratesproject/drawable/video/damy.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);

        // Set the media view to fill the entire background
        mediaView.setFitWidth(1920);
        mediaView.setFitHeight(1080);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the video
        mediaPlayer.play(); // Start playing the video

        vBox = new VBox();
        playAgainB = new Button();
        exitB = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        // Configure Play Again Button
        playAgainB.setMnemonicParsing(false);
        playAgainB.setText("Play again");
        playAgainB.setFont(new Font("Gigi", 24.0));
        playAgainB.getStyleClass().add("play-again-button"); // Add CSS class
        VBox.setMargin(playAgainB, new Insets(500.0, 0.0, 0.0, 850.0));

        // Configure Exit Button
        exitB.setMnemonicParsing(false);
        exitB.setText("Exit");
        exitB.setFont(new Font("Gigi", 24.0));
        exitB.getStyleClass().add("exit-button"); // Add CSS class
        VBox.setMargin(exitB, new Insets(50.0, 0.0, 0.0, 880.0));

        vBox.getChildren().add(playAgainB);
        vBox.getChildren().add(exitB);

        // Add the media view and VBox to the StackPane
        getChildren().addAll(mediaView, vBox);

        // Load the CSS file
        getStylesheets().add(getClass().getResource("draw.css").toExternalForm());
    }
}