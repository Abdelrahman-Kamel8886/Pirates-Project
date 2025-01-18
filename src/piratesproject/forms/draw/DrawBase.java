package piratesproject.forms.draw;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public abstract class DrawBase extends AnchorPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final VBox vBox;
    protected final Button playAgainB;
    protected final Button exitB;
    protected final AnchorPane anchorPane;

    protected final MediaView mediaViewPlay;
    protected final MediaPlayer mediaPlayer;

    public DrawBase(String path) {
        String videoPath = getClass().getResource(path).toExternalForm();
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaViewPlay = new MediaView(mediaPlayer);

        mediaViewPlay.setFitWidth(1000);
        mediaViewPlay.setFitHeight(800);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        imageView = new ImageView();
        borderPane = new BorderPane();
        vBox = new VBox();
        VBox vBoxR = new VBox();
        playAgainB = new Button();
        exitB = new Button();
        anchorPane = new AnchorPane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1000.0);
        setPrefWidth(1300.0);

        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(1000.0);
        imageView.setFitWidth(1300.0);
        imageView.setLayoutX(444.0);
        imageView.setLayoutY(244.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/splash.png").toExternalForm()));

        AnchorPane.setBottomAnchor(borderPane, 100.0);
        AnchorPane.setLeftAnchor(borderPane, 100.0);
        AnchorPane.setRightAnchor(borderPane, 42.0);
        AnchorPane.setTopAnchor(borderPane, 100.0);
        borderPane.setLayoutX(400.0);
        borderPane.setLayoutY(334.0);
        borderPane.setPrefHeight(600.0);
        borderPane.setPrefWidth(858.0);
        borderPane.setStyle("-fx-background-color: transprent;");

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(600.0);
        vBox.setPrefWidth(150.0);
        BorderPane.setAlignment(vBoxR, javafx.geometry.Pos.CENTER);
        vBoxR.setPrefHeight(600.0);
        vBoxR.setPrefWidth(150.0);
        playAgainB.setMaxHeight(USE_PREF_SIZE);
        playAgainB.setMaxWidth(USE_PREF_SIZE);
        playAgainB.setMinHeight(USE_PREF_SIZE);
        playAgainB.setMinWidth(USE_PREF_SIZE);
        playAgainB.setMnemonicParsing(false);
        playAgainB.setPrefHeight(147.0);
        playAgainB.setPrefWidth(152.0);
        playAgainB.setStyle("-fx-background-radius: 100px; -fx-background-color: #436399;");
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
        borderPane.setRight(vBox);
        borderPane.setLeft(vBoxR);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);
        // anchorPane.setStyle("-fx-background-color: #436399;");
        anchorPane.getChildren().add(mediaViewPlay);

        borderPane.setCenter(anchorPane);

        getChildren().add(imageView);
        vBox.getChildren().add(playAgainB);
        vBox.getChildren().add(exitB);
        getChildren().add(borderPane);

    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer; // Expose the MediaPlayer
    }
}
