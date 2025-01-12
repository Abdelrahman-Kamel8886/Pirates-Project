package piratesproject.ui.splash;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class SplashPage extends BorderPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final ProgressBar progressBar;
    protected final Label label;
    protected final Label label0;

    public SplashPage() {

        imageView = new ImageView();
        vBox = new VBox();
        progressBar = new ProgressBar();
        label = new Label();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(698.0);
        setPrefWidth(1029.0);

        BorderPane.setAlignment(imageView, javafx.geometry.Pos.CENTER);
        imageView.setFitHeight(800.0);
        imageView.setFitWidth(1000.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        setCenter(imageView);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        progressBar.setPrefHeight(50.0);
        progressBar.setPrefWidth(300.0);
        progressBar.setProgress(0.0);

        label.setText("Loading");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Old English Text MT", 36.0));

        label0.setLayoutX(464.0);
        label0.setLayoutY(125.0);
        label0.setText("@Pirates of Java Development Team Presents Your Next Adventure");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Old English Text MT", 36.0));
        label0.setPadding(new Insets(50));
        
        vBox.setPrefHeight(400);
        setBottom(vBox);

        vBox.getChildren().add(progressBar);
        vBox.getChildren().add(label);
        vBox.getChildren().add(label0);

    }
}
