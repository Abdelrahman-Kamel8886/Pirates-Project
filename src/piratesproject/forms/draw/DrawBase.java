package piratesproject.forms.draw;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public abstract class DrawBase extends BorderPane {

    protected final VBox vBox;
    protected final Button playAgainB;
    protected final Button exitB;
    protected final MediaView mediaViewPlay;
    protected final MediaPlayer mediaPlayer;

    public DrawBase(String path) {

        vBox = new VBox();
        playAgainB = new Button();
        exitB = new Button();
        
        String videoPath = getClass().getResource(path).toExternalForm();
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaViewPlay = new MediaView(mediaPlayer);

        mediaViewPlay.setFitWidth(600);
        mediaViewPlay.setFitHeight(800);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(683.0);
        setPrefWidth(1033.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        setStyle("-fx-background-color: #436399;");

        playAgainB.setMaxHeight(USE_PREF_SIZE);
        playAgainB.setMaxWidth(USE_PREF_SIZE);
        playAgainB.setMinHeight(USE_PREF_SIZE);
        playAgainB.setMinWidth(USE_PREF_SIZE);
        playAgainB.setMnemonicParsing(false);
        playAgainB.setPrefHeight(147.0);
        playAgainB.setPrefWidth(152.0);
        playAgainB.setStyle("-fx-background-radius: 100px; -fx-background-color: #1bd41b;");
        playAgainB.setText("PlayAgain");
        playAgainB.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        VBox.setMargin(playAgainB, new Insets(200.0, 0.0, 0.0, 40.0));
        playAgainB.setFont(new Font(26.0));

        exitB.setMaxHeight(USE_PREF_SIZE);
        exitB.setMaxWidth(USE_PREF_SIZE);
        exitB.setMinHeight(USE_PREF_SIZE);
        exitB.setMinWidth(USE_PREF_SIZE);
        exitB.setMnemonicParsing(false);
        exitB.setPrefHeight(147.0);
        exitB.setPrefWidth(152.0);
        exitB.setStyle("-fx-background-color: #1bd41b; -fx-background-radius: 100;");
        exitB.setText("ExitGme");
        exitB.setTextFill(javafx.scene.paint.Color.WHITE);
        VBox.setMargin(exitB, new Insets(100.0, 0.0, 0.0, 40.0));
        exitB.setFont(new Font(26.0));
        vBox.setPadding(new Insets(0.0, 20.0, 0.0, 10.0));
        setRight(vBox);
        setCenter(mediaViewPlay);

        vBox.getChildren().add(playAgainB);
        vBox.getChildren().add(exitB);

    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer; // Expose the MediaPlayer
    }
}
