package piratesproject.ui.game.replay;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReplayBase extends AnchorPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final Button Grid_2;
    protected final Button Grid_1;
    protected final Button Grid_4;
    protected final Button Grid_5;
    protected final Button Grid_3;
    protected final Button Grid_7;
    protected final Button Grid_8;
    protected final Button Grid_9;
    protected final Button Grid_6;
    protected final Button playButton;
    protected final Button pauseButton;
    protected final Button backButton;
    protected final Label Player1Label;
    protected final Label Player2Label;
    protected final HBox hBox;
    protected final Label label;
    protected final Label label0;
    protected final Stage mystage;

    public ReplayBase(Stage stage) {
        mystage = stage;
        imageView = new ImageView();
        vBox = new VBox();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        Grid_2 = new Button();
        Grid_1 = new Button();
        Grid_4 = new Button();
        Grid_5 = new Button();
        Grid_3 = new Button();
        Grid_7 = new Button();
        Grid_8 = new Button();
        Grid_9 = new Button();
        Grid_6 = new Button();
        playButton = new Button();
        pauseButton = new Button();
        backButton = new Button();
        Player1Label = new Label();
        Player2Label = new Label();
        hBox = new HBox();
        label = new Label();
        label0 = new Label();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);

        imageView.setFitHeight(1080.0);
        imageView.setFitWidth(1920.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/xo_game_board.jpg").toExternalForm()));

        vBox.setPrefHeight(800.0);
        vBox.setPrefWidth(1280.0);

        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(1080.0);
        gridPane.setPrefWidth(1920.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(495.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(456.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(483.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(275.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(483.0);
        columnConstraints1.setMinWidth(1.0);
        columnConstraints1.setPrefWidth(33.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(483.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(332.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(483.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(31.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(511.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(349.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(483.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(442.0);

        rowConstraints.setMaxHeight(294.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(290.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(279.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(207.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(279.0);
        rowConstraints1.setMinHeight(6.0);
        rowConstraints1.setPrefHeight(36.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(285.0);
        rowConstraints2.setMinHeight(0.0);
        rowConstraints2.setPrefHeight(219.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(293.0);
        rowConstraints3.setMinHeight(0.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(293.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(196.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(293.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(98.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(Grid_2, 3);
        GridPane.setRowIndex(Grid_2, 1);
        Grid_2.setMnemonicParsing(false);
        Grid_2.setPrefHeight(208.0);
        Grid_2.setPrefWidth(332.0);
        Grid_2.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_1, 1);
        GridPane.setRowIndex(Grid_1, 1);
        Grid_1.setMnemonicParsing(false);
        Grid_1.setPrefHeight(200.0);
        Grid_1.setPrefWidth(276.0);
        Grid_1.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_4, 1);
        GridPane.setRowIndex(Grid_4, 3);
        Grid_4.setMnemonicParsing(false);
        Grid_4.setPrefHeight(211.0);
        Grid_4.setPrefWidth(282.0);
        Grid_4.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_5, 3);
        GridPane.setRowIndex(Grid_5, 3);
        Grid_5.setMnemonicParsing(false);
        Grid_5.setPrefHeight(159.0);
        Grid_5.setPrefWidth(233.0);
        Grid_5.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_3, 5);
        GridPane.setRowIndex(Grid_3, 1);
        Grid_3.setMnemonicParsing(false);
        Grid_3.setPrefHeight(190.0);
        Grid_3.setPrefWidth(342.0);
        Grid_3.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_7, 1);
        GridPane.setRowIndex(Grid_7, 5);
        Grid_7.setMnemonicParsing(false);
        Grid_7.setPrefHeight(181.0);
        Grid_7.setPrefWidth(276.0);
        Grid_7.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_8, 3);
        GridPane.setRowIndex(Grid_8, 5);
        Grid_8.setMnemonicParsing(false);
        Grid_8.setPrefHeight(184.0);
        Grid_8.setPrefWidth(338.0);
        Grid_8.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_9, 5);
        GridPane.setRowIndex(Grid_9, 5);
        Grid_9.setMnemonicParsing(false);
        Grid_9.setPrefHeight(197.0);
        Grid_9.setPrefWidth(302.0);
        Grid_9.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(Grid_6, 5);
        GridPane.setRowIndex(Grid_6, 3);
        Grid_6.setMnemonicParsing(false);
        Grid_6.setPrefHeight(208.0);
        Grid_6.setPrefWidth(334.0);
        Grid_6.setStyle("-fx-background-color: #436399;");

        GridPane.setColumnIndex(playButton, 6);
        GridPane.setRowIndex(playButton, 1);
        playButton.setMnemonicParsing(false);
        playButton.setPrefHeight(147.0);
        playButton.setPrefWidth(152.0);
        playButton.setStyle("-fx-background-color: #436399; -fx-background-radius: 100px;");
        playButton.setText("Next");
        playButton.setTextFill(javafx.scene.paint.Color.WHITE);
        GridPane.setMargin(playButton, new Insets(0.0, 0.0, 0.0, 150.0));
        playButton.setFont(new Font("Old English Text MT", 40.0));

        GridPane.setColumnIndex(pauseButton, 6);
        GridPane.setRowIndex(pauseButton, 3);
        pauseButton.setMnemonicParsing(false);
        pauseButton.setPrefHeight(147.0);
        pauseButton.setPrefWidth(152.0);
        pauseButton.setStyle("-fx-background-color: #436399; -fx-background-radius: 100px;");
        pauseButton.setText("Previes");
        pauseButton.setTextFill(javafx.scene.paint.Color.WHITE);
        GridPane.setMargin(pauseButton, new Insets(0.0, 0.0, 0.0, 150.0));
        pauseButton.setFont(new Font("Old English Text MT", 30.0));

        GridPane.setColumnIndex(backButton, 6);
        GridPane.setRowIndex(backButton, 5);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(147.0);
        backButton.setPrefWidth(152.0);
        backButton.setStyle("-fx-background-color: #1bd41b; -fx-background-radius: 100px;");
        backButton.setText("Back");
        backButton.setTextFill(javafx.scene.paint.Color.WHITE);
        backButton.setFont(new Font("Old English Text MT", 40.0));
        GridPane.setMargin(backButton, new Insets(0.0, 0.0, 0.0, 150.0));

        GridPane.setColumnIndex(Player1Label, 1);
        Player1Label.setPrefHeight(139.0);
        Player1Label.setPrefWidth(239.0);
        Player1Label.setText("Player1");
        GridPane.setMargin(Player1Label, new Insets(30.0, 0.0, 0.0, 30.0));
        Player1Label.setFont(new Font("Old English Text MT", 60.0));

        GridPane.setColumnIndex(Player2Label, 5);
        Player2Label.setPrefHeight(148.0);
        Player2Label.setPrefWidth(291.0);
        Player2Label.setText("Player2");
        GridPane.setMargin(Player2Label, new Insets(30.0, 0.0, 0.0, 40.0));
        Player2Label.setFont(new Font("Old English Text MT", 60.0));

        GridPane.setColumnIndex(hBox, 3);
        hBox.setPrefHeight(217.0);
        hBox.setPrefWidth(279.0);

        label.setPrefHeight(92.0);
        label.setPrefWidth(85.0);
        label.setText("W");
        HBox.setMargin(label, new Insets(130.0, 0.0, 80.0, 0.0));
        label.setFont(new Font("Old English Text MT", 50.0));

        label0.setPrefHeight(93.0);
        label0.setPrefWidth(84.0);
        label0.setText("L");
        HBox.setMargin(label0, new Insets(130.0, 0.0, 80.0, 220.0));
        label0.setFont(new Font("Old English Text MT", 80.0));

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getChildren().add(Grid_2);
        gridPane.getChildren().add(Grid_1);
        gridPane.getChildren().add(Grid_4);
        gridPane.getChildren().add(Grid_5);
        gridPane.getChildren().add(Grid_3);
        gridPane.getChildren().add(Grid_7);
        gridPane.getChildren().add(Grid_8);
        gridPane.getChildren().add(Grid_9);
        gridPane.getChildren().add(Grid_6);
        gridPane.getChildren().add(playButton);
        gridPane.getChildren().add(pauseButton);
        gridPane.getChildren().add(backButton);
        gridPane.getChildren().add(Player1Label);
        gridPane.getChildren().add(Player2Label);
        hBox.getChildren().add(label);
        hBox.getChildren().add(label0);
        gridPane.getChildren().add(hBox);
        vBox.getChildren().add(gridPane);
        getChildren().add(vBox);

    }
}
