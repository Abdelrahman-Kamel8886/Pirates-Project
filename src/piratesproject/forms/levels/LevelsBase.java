package piratesproject.forms.levels;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.drawable.values.Pathes;

public class LevelsBase extends VBox {

    protected final ImageView image1;
    protected final Label easy;
    protected final Slider slider;
    protected final Button playb;

    public LevelsBase() {
        image1 = new ImageView();
        easy = new Label();
        slider = new Slider(0, 2, 1);
        playb = new Button();
        drawAll();
    }

    private void drawAll() {
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(400.0);

        getStylesheets().add(getClass().getResource("/piratesproject/drawable/styles/style.css").toExternalForm());

        this.getStyleClass().add("vbox");
        image1.getStyleClass().add("image-view");
        slider.getStyleClass().add("slider");
        easy.getStyleClass().add("label");
        playb.getStyleClass().add("button");
        image1.setFitHeight(200.0);
        image1.setFitWidth(200.0);
        image1.setPickOnBounds(true);
        image1.setPreserveRatio(true);
        image1.setImage(new Image(getClass().getResource(Pathes.NORMAL_LOGO_PATH).toExternalForm()));

        VBox.setMargin(image1, new Insets(50.0, 0.0, 0.0, 80.0));

        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setMaxHeight(USE_PREF_SIZE);
        slider.setMaxWidth(USE_PREF_SIZE);
        slider.setMinHeight(USE_PREF_SIZE);
        slider.setMinWidth(USE_PREF_SIZE);
        slider.setPrefHeight(40.0);
        slider.setPrefWidth(220.0);
        VBox.setMargin(slider, new Insets(10.0, 0.0, 0.0, 80.0));

        easy.setText("Difficulty: Normal");
        VBox.setMargin(easy, new Insets(10.0, 0.0, 0.0, 130.0));

        playb.setMnemonicParsing(false);
        playb.setPrefHeight(32.0);
        playb.setPrefWidth(140.0);
        playb.setStyle("-fx-background-radius: 20;");
        playb.setText("Play");
        VBox.setMargin(playb, new Insets(10.0, 0.0, 0.0, 120.0));



        getChildren().add(image1);
        getChildren().add(easy);
        getChildren().add(slider);
        getChildren().add(playb);
    }
}
