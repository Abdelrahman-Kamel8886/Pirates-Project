package piratesproject.ui.home;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    protected final ImageView logoImage;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ImageView avatar;
    protected final Text userNameText;
    protected final Text scoreText;
    protected final HBox hBox0;
    protected final VBox vBox0;
    protected final ImageView computerImage;
    protected final Text text;
    protected final VBox vBox1;
    protected final ImageView multiPlayersImage;
    protected final Text text0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints1;
    protected final VBox box0;
    protected final Text userNameText1;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final VBox box1;
    protected final Text userNameText11;
    protected final TableView tableView0;
    protected final TableColumn tableColumn1;
    protected final TableColumn tableColumn2;
    protected final TableColumn tableColumn3;
    protected final TableColumn tableColumn4;

    public HomePage() {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        box = new HBox();
        logoImage = new ImageView();
        vBox = new VBox();
        hBox = new HBox();
        avatar = new ImageView();
        userNameText = new Text();
        scoreText = new Text();
        hBox0 = new HBox();
        vBox0 = new VBox();
        computerImage = new ImageView();
        text = new Text();
        vBox1 = new VBox();
        multiPlayersImage = new ImageView();
        text0 = new Text();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints1 = new RowConstraints();
        box0 = new VBox();
        userNameText1 = new Text();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        box1 = new VBox();
        userNameText11 = new Text();
        tableView0 = new TableView();
        tableColumn1 = new TableColumn();
        tableColumn2 = new TableColumn();
        tableColumn3 = new TableColumn();
        tableColumn4 = new TableColumn();

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
        box.setSpacing(700.0);
        GridPane.setMargin(box, new Insets(40.0, 40.0, 100.0, 40.0));

        logoImage.setFitHeight(150.0);
        logoImage.setFitWidth(200.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);

        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        hBox.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        avatar.setFitHeight(100.0);
        avatar.setFitWidth(100.0);
        avatar.setPickOnBounds(true);
        avatar.setPreserveRatio(true);
        
        userNameText.setFill(javafx.scene.paint.Color.WHITE);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("UserName");
        userNameText.setWrappingWidth(151.92578125);
        userNameText.setFont(new Font("Old English Text MT", 24.0));
        HBox.setMargin(userNameText, new Insets(30.0, 0.0, 0.0, 20.0));
        
        scoreText.setFill(javafx.scene.paint.Color.WHITE);
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText("Score : 190");
        scoreText.setWrappingWidth(151.92578125);
        scoreText.setFont(new Font("Old English Text MT", 24.0));
        HBox.setMargin(scoreText, new Insets(30.0, 0.0, 0.0, 20.0));
        hBox.setPadding(new Insets(20.0));

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        computerImage.setFitHeight(150.0);
        computerImage.setFitWidth(200.0);
        computerImage.setPickOnBounds(true);
        computerImage.setPreserveRatio(true);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Computer");
        text.setUnderline(true);
        text.setWrappingWidth(154.48828125);
        text.setFont(new Font("Old English Text MT", 24.0));

        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(100.0);

        multiPlayersImage.setFitHeight(150.0);
        multiPlayersImage.setFitWidth(200.0);
        multiPlayersImage.setPickOnBounds(true);
        multiPlayersImage.setPreserveRatio(true);

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Multi Mood");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setUnderline(true);
        text0.setWrappingWidth(154.48828125);
        text0.setFont(new Font("Old English Text MT", 24.0));

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

        userNameText1.setFill(javafx.scene.paint.Color.WHITE);
        userNameText1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText1.setStrokeWidth(0.0);
        userNameText1.setText("Active Players");
        userNameText1.setWrappingWidth(151.92578125);
        userNameText1.setFont(new Font("Old English Text MT", 24.0));

        tableView.setPrefHeight(200.0);
        tableView.setPrefWidth(200.0);

        tableColumn.setPrefWidth(400.0);
        tableColumn.setText("PlayerName");

        tableColumn0.setMinWidth(0.0);
        tableColumn0.setPrefWidth(100.0);
        tableColumn0.setText("Score");
        VBox.setMargin(tableView, new Insets(20.0));

        GridPane.setColumnIndex(box1, 1);
        box1.setPrefHeight(210.0);
        box1.setPrefWidth(261.0);

        userNameText11.setFill(javafx.scene.paint.Color.WHITE);
        userNameText11.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText11.setStrokeWidth(0.0);
        userNameText11.setText("Games History");
        userNameText11.setWrappingWidth(151.92578125);
        userNameText11.setFont(new Font("Old English Text MT", 24.0));

        tableView0.setEditable(true);
        tableView0.setPrefHeight(200.0);
        tableView0.setPrefWidth(200.0);

        tableColumn1.setPrefWidth(200.0);
        tableColumn1.setText("Opponent Name");

        tableColumn2.setMinWidth(0.0);
        tableColumn2.setPrefWidth(100.0);
        tableColumn2.setText("Result");

        tableColumn3.setMinWidth(0.0);
        tableColumn3.setPrefWidth(100.0);
        tableColumn3.setText("Game Type");

        tableColumn4.setMinWidth(0.0);
        tableColumn4.setPrefWidth(100.0);
        tableColumn4.setText("Time");
        VBox.setMargin(tableView0, new Insets(20.0));
        GridPane.setMargin(gridPane, new Insets(20.0, 50.0, 20.0, 50.0));
        
        box.setSpacing(1200);

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        box.getChildren().add(logoImage);
        hBox.getChildren().add(avatar);
        hBox.getChildren().add(userNameText);
        hBox.getChildren().add(scoreText);
        vBox.getChildren().add(hBox);
        vBox0.getChildren().add(computerImage);
        vBox0.getChildren().add(text);
        hBox0.getChildren().add(vBox0);
        vBox1.getChildren().add(multiPlayersImage);
        vBox1.getChildren().add(text0);
        hBox0.getChildren().add(vBox1);
        vBox.getChildren().add(hBox0);
        box.getChildren().add(vBox);
        getChildren().add(box);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints1);
        box0.getChildren().add(userNameText1);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        box0.getChildren().add(tableView);
        gridPane.getChildren().add(box0);
        box1.getChildren().add(userNameText11);
        tableView0.getColumns().add(tableColumn1);
        tableView0.getColumns().add(tableColumn2);
        tableView0.getColumns().add(tableColumn3);
        tableView0.getColumns().add(tableColumn4);
        box1.getChildren().add(tableView0);
        gridPane.getChildren().add(box1);
        getChildren().add(gridPane);

    }
}
