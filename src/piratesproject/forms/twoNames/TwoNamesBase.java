package piratesproject.forms.twoNames;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class TwoNamesBase extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final TextField playerOneTextField;
    protected final TextField playerTwoTextField;
    protected final Button button;

    public TwoNamesBase() {

        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        playerOneTextField = new TextField();
        playerTwoTextField = new TextField();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/ui/twoNames/twonames.css");

        imageView.setFitHeight(400.0);
        imageView.setFitWidth(600.0);
        imageView.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/BackGround.jpg").toExternalForm()));

        gridPane.setPrefHeight(284.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(298.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(31.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(348.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(247.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(195.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(49.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(371.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(257.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(292.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(28.0);

        rowConstraints.setMaxHeight(167.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(167.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(266.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(117.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(134.0);
        rowConstraints1.setMinHeight(0.0);
        rowConstraints1.setPrefHeight(0.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(playerOneTextField, 1);
        GridPane.setRowIndex(playerOneTextField, 1);
        playerOneTextField.setPrefHeight(100.0);
        playerOneTextField.setPrefWidth(200.0);
        playerOneTextField.setStyle("-fx-background-radius: 20px;");
        playerOneTextField.setFont(new Font(46.0));

        GridPane.setColumnIndex(playerTwoTextField, 3);
        GridPane.setRowIndex(playerTwoTextField, 1);
        playerTwoTextField.setPrefHeight(100.0);
        playerTwoTextField.setPrefWidth(255.0);
        playerTwoTextField.setStyle("-fx-background-radius: 20px;");
        playerTwoTextField.setFont(new Font(46.0));

        button.setLayoutX(231.0);
        button.setLayoutY(307.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(62.0);
        button.setPrefWidth(134.0);
        button.setStyle("-fx-background-radius: 30px; -fx-background-color: #436399;");
        button.setText("Play");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Old English Text MT", 32.0));


        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(playerOneTextField);
        gridPane.getChildren().add(playerTwoTextField);
        getChildren().add(gridPane);
        getChildren().add(button);

        
    }

    public String getPlayerOneTextField() {
        return playerOneTextField.getText();
    }

    public String getPlayerTwoTextField() {
        return playerTwoTextField.getText();
    }
}
