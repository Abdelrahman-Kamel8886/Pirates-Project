package piratesproject.ui.home;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class HomePage extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final HBox box;
    protected final ImageView imageView;
    protected final HBox hBox;
    protected final VBox vBox;
    protected final ImageView imageView0;
    protected final Text text;
    protected final VBox vBox0;
    protected final ImageView imageView1;
    protected final Text text0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints1;
    protected final VBox box0;
    protected final VBox box1;
    protected final BorderPane borderPane;
    protected final VBox vBox1;

    public HomePage() {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        box = new HBox();
        imageView = new ImageView();
        hBox = new HBox();
        vBox = new VBox();
        imageView0 = new ImageView();
        text = new Text();
        vBox0 = new VBox();
        imageView1 = new ImageView();
        text0 = new Text();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints1 = new RowConstraints();
        box0 = new VBox();
        box1 = new VBox();
        borderPane = new BorderPane();
        vBox1 = new VBox();

        setHgap(50.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(719.0);
        setPrefWidth(1243.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(10.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(Double.MAX_VALUE);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        box.setFillHeight(false);
        box.setPrefHeight(143.0);
        box.setPrefWidth(600.0);
        GridPane.setMargin(box, new Insets(40.0, 40.0, 100.0, 40.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(50.0);

        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(200.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Multi Mood ");
        text.setWrappingWidth(151.92578125);
        text.setFont(new Font("Malgun Gothic Bold", 24.0));

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Multi Mood");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(154.48828125);
        text0.setFont(new Font("Malgun Gothic Bold", 24.0));

        GridPane.setRowIndex(gridPane, 1);
        gridPane.setHgap(20.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints1.setMinHeight(50.0);
        rowConstraints1.setPrefHeight(50.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        box0.setPrefHeight(200.0);
        box0.setPrefWidth(100.0);

        GridPane.setColumnIndex(box1, 1);
        box1.setPrefHeight(210.0);
        box1.setPrefWidth(261.0);
        box1.setSpacing(50.0);

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(100.0);
        borderPane.setLeft(vBox1);
        GridPane.setMargin(gridPane, new Insets(20.0, 50.0, 20.0, 50.0));

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        box.getChildren().add(imageView);
        vBox.getChildren().add(imageView0);
        vBox.getChildren().add(text);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(imageView1);
        vBox0.getChildren().add(text0);
        hBox.getChildren().add(vBox0);
        box.getChildren().add(hBox);
        getChildren().add(box);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(box0);
        gridPane.getChildren().add(box1);
        gridPane.getChildren().add(borderPane);
        getChildren().add(gridPane);

    }
}
