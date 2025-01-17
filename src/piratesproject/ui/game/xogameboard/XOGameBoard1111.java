package piratesproject.ui.game.xogameboard;

import java.net.URL;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import piratesproject.drawable.values.Pathes;
import piratesproject.utils.Consts;
import static piratesproject.utils.Consts.GRID_BTN_HEIGTH;
import static piratesproject.utils.Consts.GRID_BTN_WIGTH;
import static piratesproject.utils.Consts.GRID_X_0_0;
import static piratesproject.utils.Consts.GRID_Y_0_0;

public class XOGameBoard1111 extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btnGrid_2_0;
    protected final Button btnGrid_0_0;
    protected final Button btnGrid_0_1;
    protected final Button btnGrid_0_2;
    protected final Blend blend;
    protected final Button btnGrid_1_2;
    protected final Blend blend0;
    protected final Button btnGrid_2_2;
    protected final Blend blend1;
    protected final Button btnGrid_1_1;
    protected final Button btnGrid_1_0;
    protected final Button btnGrid_2_1;
    protected final Text playerOneScore;
    protected final Text playerTowScore;
    protected final Text column;
    protected final Label playerTwoLabel;
    protected final Label playerOneLabel;
    protected final MediaView mediaView;
    protected final ImageView backIcon;
    protected final ImageView avatarIcon;
    protected final ImageView retryIcon;
    protected Line line1 ,line2,line3,line4,line5,line6,line7,line8;

    public XOGameBoard1111(Stage stage) {

        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btnGrid_2_0 = new Button();
        btnGrid_0_0 = new Button();
        btnGrid_0_1 = new Button();
        btnGrid_0_2 = new Button();
        blend = new Blend();
        btnGrid_1_2 = new Button();
        blend0 = new Blend();
        btnGrid_2_2 = new Button();
        blend1 = new Blend();
        btnGrid_1_1 = new Button();
        btnGrid_1_0 = new Button();
        btnGrid_2_1 = new Button();
        playerOneScore = new Text();
        playerTowScore = new Text();
        column = new Text();
        playerTwoLabel = new Label();
        playerOneLabel = new Label();
        mediaView = new MediaView();
        backIcon = new ImageView();
        avatarIcon = new ImageView();
        retryIcon = new ImageView();

        setId("AnchorPane");
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/ui/game/xogameboard//piratesproject/drawable/styles/xogameboard.css");

        AnchorPane.setLeftAnchor(imageView, 0.0);
        imageView.setFitHeight(1080.0);
        imageView.setFitWidth(1920.0);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        imageView.setImage(new Image(getClass().getResource(Consts.XO_GAME_Board).toExternalForm()));

        gridPane.setLayoutX(428.0);
        gridPane.setLayoutY(286.0);
        gridPane.setPrefHeight(716.0);
        gridPane.setPrefWidth(1057.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(488.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(324.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(623.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(362.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(383.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(371.0);

        rowConstraints.setMaxHeight(241.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(232.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(275.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(254.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(245.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(230.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(btnGrid_2_0, 2);
        btnGrid_2_0.setMnemonicParsing(false);
        btnGrid_2_0.setPrefHeight(200.0);
        btnGrid_2_0.setPrefWidth(320.0);
        btnGrid_2_0.setStyle("-fx-background-color: transparent; ");
        btnGrid_2_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_2_0.setFont(new Font(96.0));
        btnGrid_2_0.setWrapText(true);
        

        btnGrid_0_0.setMnemonicParsing(false);
        btnGrid_0_0.setPrefHeight(230.0);
        btnGrid_0_0.setPrefWidth(345.0);
        btnGrid_0_0.setStyle("-fx-background-color: transparent;");
        btnGrid_0_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_0.setWrapText(true);
        btnGrid_0_0.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_0_1, 1);
        GridPane.setHalignment(btnGrid_0_1, javafx.geometry.HPos.CENTER);
        btnGrid_0_1.setMnemonicParsing(false);
        btnGrid_0_1.setPrefHeight(213.0);
        btnGrid_0_1.setPrefWidth(345.0);
        btnGrid_0_1.setStyle("-fx-background-color: transparent;");
        btnGrid_0_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_1.setWrapText(true);
        btnGrid_0_1.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_0_2, 2);
        btnGrid_0_2.setMnemonicParsing(false);
        btnGrid_0_2.setPrefHeight(241.0);
        btnGrid_0_2.setPrefWidth(345.0);
        btnGrid_0_2.setStyle("-fx-background-color: transparent;");
        btnGrid_0_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_2.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_2.setWrapText(true);
        btnGrid_0_2.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_1_2, 2);
        GridPane.setRowIndex(btnGrid_1_2, 1);
        btnGrid_1_2.setMnemonicParsing(false);
        btnGrid_1_2.setPrefHeight(230.0);
        btnGrid_1_2.setPrefWidth(345.0);
        btnGrid_1_2.setStyle("-fx-background-color: transparent;");
        btnGrid_1_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_2.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_2.setWrapText(true);
        btnGrid_1_2.setFont(new Font(96.0));


        GridPane.setColumnIndex(btnGrid_2_2, 2);
        GridPane.setRowIndex(btnGrid_2_2, 2);
        btnGrid_2_2.setMnemonicParsing(false);
        btnGrid_2_2.setPrefHeight(230.0);
        btnGrid_2_2.setPrefWidth(345.0);
        btnGrid_2_2.setStyle("-fx-background-color: transparent;");
        
        btnGrid_2_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_2.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_2_2.setWrapText(true);
        btnGrid_2_2.setFont(new Font(96.0));
        btnGrid_2_2.setEffect(blend1);

        GridPane.setColumnIndex(btnGrid_1_1, 1);
        GridPane.setHalignment(btnGrid_1_1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnGrid_1_1, 1);
        btnGrid_1_1.setMnemonicParsing(false);
        btnGrid_1_1.setPrefHeight(230.0);
        btnGrid_1_1.setPrefWidth(345.0);
        btnGrid_1_1.setStyle("-fx-background-color: transparent;");
        
        btnGrid_1_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_1.setWrapText(true);
        btnGrid_1_1.setFont(new Font(96.0));

        GridPane.setRowIndex(btnGrid_1_0, 1);
        btnGrid_1_0.setMnemonicParsing(false);
        btnGrid_1_0.setPrefHeight(230.0);
        btnGrid_1_0.setPrefWidth(345.0);
        btnGrid_1_0.setStyle("-fx-background-color: transparent;");
        btnGrid_1_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_0.setWrapText(true);
        btnGrid_1_0.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_2_1, 1);
        GridPane.setHalignment(btnGrid_2_1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnGrid_2_1, 2);
        btnGrid_2_1.setMnemonicParsing(false);
        btnGrid_2_1.setPrefHeight(230.0);
        btnGrid_2_1.setPrefWidth(345.0);
        btnGrid_2_1.setStyle("-fx-background-color: transparent;-fx-padding: 10; -fx-cursor: default;  -fx-background-insets: 0;-fx-border-color: transparent; ");
        btnGrid_2_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_2_1.setWrapText(true);
        btnGrid_2_1.setFont(new Font(96.0));

        playerOneScore.setFill(javafx.scene.paint.Color.valueOf("#5ebc66"));
        playerOneScore.setLayoutX(828.0);
        playerOneScore.setLayoutY(196.0);
        playerOneScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOneScore.setStrokeWidth(0.0);
        playerOneScore.setText("99");
        playerOneScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerOneScore.setWrappingWidth(115.0);
        playerOneScore.setFont(new Font(64.0));

        playerTowScore.setFill(javafx.scene.paint.Color.valueOf("#d72626"));
        playerTowScore.setLayoutX(917.0);
        playerTowScore.setLayoutY(198.0);
        playerTowScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTowScore.setStrokeWidth(0.0);
        playerTowScore.setText("22");
        playerTowScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerTowScore.setWrappingWidth(115.0);
        playerTowScore.setFont(new Font(64.0));

        column.setLayoutX(870.0);
        column.setLayoutY(191.0);
        column.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        column.setStrokeWidth(0.0);
        column.setText(":");
        column.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        column.setWrappingWidth(115.0);
        column.setFont(new Font(64.0));

        playerTwoLabel.setLayoutX(1023.0);
        playerTwoLabel.setLayoutY(122.0);
        playerTwoLabel.setPrefHeight(125.0);
        playerTwoLabel.setPrefWidth(376.0);
        playerTwoLabel.setText("Player TWO");
        playerTwoLabel.setFont(new Font(36.0));

        playerOneLabel.setLayoutX(464.0);
        playerOneLabel.setLayoutY(122.0);
        playerOneLabel.setPrefHeight(125.0);
        playerOneLabel.setPrefWidth(376.0);
        playerOneLabel.setText("Player One");
        playerOneLabel.setFont(new Font(36.0));

        mediaView.setFitHeight(700.0);
        mediaView.setFitWidth(1000.0);
        mediaView.setLayoutX(397.0);
        mediaView.setLayoutY(229.0);

        backIcon.setFitHeight(134.0);
        backIcon.setFitWidth(173.0);
        backIcon.setLayoutX(34.0);
        backIcon.setLayoutY(22.0);
        backIcon.setPickOnBounds(true);
        backIcon.setPreserveRatio(true);
        backIcon.setImage(new Image(getClass().getResource(Consts.BACK_ICON).toExternalForm()));

        avatarIcon.setFitHeight(150.0);
        avatarIcon.setFitWidth(200.0);
        avatarIcon.setLayoutX(1748.0);
        avatarIcon.setLayoutY(19.0);
        avatarIcon.setPickOnBounds(true);
        avatarIcon.setPreserveRatio(true);
        avatarIcon.setImage(new Image(getClass().getResource(Pathes.AVATAR_LOGO_PATH).toExternalForm()));

        retryIcon.setFitHeight(138.0);
        retryIcon.setFitWidth(136.0);
        retryIcon.setLayoutX(1762.0);
        retryIcon.setLayoutY(190.0);
        retryIcon.setPickOnBounds(true);
        retryIcon.setPreserveRatio(true);
        retryIcon.setImage(new Image(getClass().getResource(Consts.RETRY_ICON).toExternalForm()));

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btnGrid_2_0);
        gridPane.getChildren().add(btnGrid_0_0);
        gridPane.getChildren().add(btnGrid_0_1);
        gridPane.getChildren().add(btnGrid_0_2);
        gridPane.getChildren().add(btnGrid_1_2);
        gridPane.getChildren().add(btnGrid_2_2);
        gridPane.getChildren().add(btnGrid_1_1);
        gridPane.getChildren().add(btnGrid_1_0);
        gridPane.getChildren().add(btnGrid_2_1);
        getChildren().add(gridPane);
        getChildren().add(playerOneScore);
        getChildren().add(playerTowScore);
        getChildren().add(column);
        getChildren().add(playerTwoLabel);
        getChildren().add(playerOneLabel);
        //getChildren().add(mediaView);
        getChildren().add(backIcon);
        getChildren().add(avatarIcon);
        getChildren().add(retryIcon);

    }
    
    public void drawSuccesslines() {

        line1 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2, GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2);
        line1.setStrokeWidth(20);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);

        line2 = new Line(GRID_X_0_0, GRID_Y_0_0, GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line2.setStrokeWidth(20);
        line2.setStroke(Color.GREEN);
        getChildren().add(line2);

        line3 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6));
        line3.setStrokeWidth(20);
        line3.setStroke(Color.GREEN);
        getChildren().add(line3);

        line4 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6));
        line4.setStrokeWidth(20);
        line4.setStroke(Color.GREEN);
        getChildren().add(line4);

        line5 = new Line(GRID_X_0_0 + (.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line5.setStrokeWidth(20);
        line5.setStroke(Color.GREEN);
        getChildren().add(line5);

        line6 = new Line(GRID_X_0_0 + (1.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (1.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line6.setStrokeWidth(20);
        line6.setStroke(Color.GREEN);
        getChildren().add(line6);

        line7 = new Line(GRID_X_0_0 + (2.5 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0 + (2.5 * GRID_BTN_WIGTH), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line7.setStrokeWidth(20);
        line7.setStroke(Color.GREEN);
        getChildren().add(line7);

        line8 = new Line(GRID_X_0_0 + (3 * GRID_BTN_WIGTH), GRID_Y_0_0, GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
        line8.setStrokeWidth(20);
        line8.setStroke(Color.GREEN);
        getChildren().add(line8);
        
        line1.setVisible(false);
        line2.setVisible(false);
        line3.setVisible(false);
        line4.setVisible(false);
        line5.setVisible(false);
        line6.setVisible(false);
        line7.setVisible(false);
        line8.setVisible(false);
    }
}
