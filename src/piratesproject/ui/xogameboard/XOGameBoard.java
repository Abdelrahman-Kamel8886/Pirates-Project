package piratesproject.ui.xogameboard;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.utils.Consts;

public class XOGameBoard extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
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
    protected final Button btnGrid_2_0;
    protected final Button btnGrid_2_1;
    protected final Text playerOneScore;
    protected final Text playerTowScore;

    protected final Text column;

    public static final double GRID_X_0_0 = 428.0;
    public static final double GRID_Y_0_0 = 286.0;
    public static final double GRID_BTN_HEIGTH = 230.0;
    public static final double GRID_BTN_WIGTH = 345.0;

    public XOGameBoard(Stage stage) {

        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
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
        btnGrid_2_0 = new Button();
        btnGrid_2_1 = new Button();
        playerOneScore = new Text();
        playerTowScore = new Text();
        column = new Text();

        setId("AnchorPane");
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/ui/xogameboard//piratesproject/drawable/styles/xogameboard.css");

        imageView.setFitHeight(1080.0);
        imageView.setFitWidth(1920.0);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
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

        btnGrid_0_0.setMnemonicParsing(false);
        btnGrid_0_0.setPrefHeight(230.0);
        btnGrid_0_0.setPrefWidth(345.0);
        btnGrid_0_0.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_0_0.setText("O");
        btnGrid_0_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_0.setWrapText(true);
        btnGrid_0_0.setFont(new Font(96.0));

        btnGrid_0_0.setOnAction((ActionEvent event) -> {
            btnGrid_0_0.setText("X");
            
            btnGrid_0_0.setStyle("-fx-border-color: green; -fx-border-width: 6px; -fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");

            Line line1 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2, GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH) / 2);
            line1.setStrokeWidth(20);
            line1.setStroke(Color.GREEN);
            getChildren().add(line1);

            Line line2 = new Line(GRID_X_0_0, GRID_Y_0_0 , GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH*3));
            line2.setStrokeWidth(20);
            line2.setStroke(Color.GREEN);
            getChildren().add(line2);

            Line line3 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 1.6));
            line3.setStrokeWidth(20);
            line3.setStroke(Color.GREEN);
            getChildren().add(line3);

            Line line4 = new Line(GRID_X_0_0, GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6), GRID_X_0_0 + (GRID_BTN_WIGTH * 3), GRID_Y_0_0 + (GRID_BTN_HEIGTH * 2.6));
            line4.setStrokeWidth(20);
            line4.setStroke(Color.GREEN);
            getChildren().add(line4);

            Line line5 = new Line(GRID_X_0_0+(.5*GRID_BTN_WIGTH), GRID_Y_0_0 , GRID_X_0_0+(.5*GRID_BTN_WIGTH) ,  GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
            line5.setStrokeWidth(20);
            line5.setStroke(Color.GREEN);
            getChildren().add(line5);
            
            Line line6 = new Line(GRID_X_0_0+(1.5*GRID_BTN_WIGTH), GRID_Y_0_0 , GRID_X_0_0+(1.5*GRID_BTN_WIGTH) ,  GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
            line6.setStrokeWidth(20);
            line6.setStroke(Color.GREEN);
            getChildren().add(line6);
            
            Line line7 = new Line(GRID_X_0_0+(2.5*GRID_BTN_WIGTH), GRID_Y_0_0 , GRID_X_0_0+(2.5*GRID_BTN_WIGTH) ,  GRID_Y_0_0 + (GRID_BTN_HEIGTH * 3));
            line7.setStrokeWidth(20);
            line7.setStroke(Color.GREEN);
            getChildren().add(line7);
            
            Line line8 = new Line(GRID_X_0_0+(3*GRID_BTN_WIGTH), GRID_Y_0_0 , GRID_X_0_0 ,  GRID_Y_0_0+(GRID_BTN_HEIGTH*3) );
            line8.setStrokeWidth(20);
            line8.setStroke(Color.GREEN);
            getChildren().add(line8);
            
            Main.resetScene(this);
        });

        GridPane.setColumnIndex(btnGrid_0_1, 1);
        GridPane.setHalignment(btnGrid_0_1, javafx.geometry.HPos.CENTER);
        btnGrid_0_1.setMnemonicParsing(false);
        btnGrid_0_1.setPrefHeight(213.0);
        btnGrid_0_1.setPrefWidth(345.0);
        btnGrid_0_1.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_0_1.setText("X");
        btnGrid_0_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_1.setWrapText(true);
        btnGrid_0_1.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_0_2, 2);
        btnGrid_0_2.setMnemonicParsing(false);
        btnGrid_0_2.setPrefHeight(241.0);
        btnGrid_0_2.setPrefWidth(345.0);
        btnGrid_0_2.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_0_2.setText("O");
        btnGrid_0_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_2.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_0_2.setWrapText(true);
        btnGrid_0_2.setFont(new Font(96.0));

        btnGrid_0_2.setEffect(blend);

        GridPane.setColumnIndex(btnGrid_1_2, 2);
        GridPane.setRowIndex(btnGrid_1_2, 1);
        btnGrid_1_2.setMnemonicParsing(false);
        btnGrid_1_2.setPrefHeight(230.0);
        btnGrid_1_2.setPrefWidth(345.0);
        btnGrid_1_2.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_2.setText("X");
        btnGrid_1_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_2.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_2.setWrapText(true);
        btnGrid_1_2.setFont(new Font(96.0));

        btnGrid_1_2.setEffect(blend0);
        btnGrid_1_2.setCursor(Cursor.NONE);

        GridPane.setColumnIndex(btnGrid_2_2, 2);
        GridPane.setRowIndex(btnGrid_2_2, 2);
        btnGrid_2_2.setMnemonicParsing(false);
        btnGrid_2_2.setPrefHeight(230.0);
        btnGrid_2_2.setPrefWidth(345.0);
        btnGrid_2_2.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_2_2.setText("X");
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
        btnGrid_1_1.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_1.setText("O");
        btnGrid_1_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_1.setWrapText(true);
        btnGrid_1_1.setFont(new Font(96.0));

        GridPane.setRowIndex(btnGrid_1_0, 1);
        btnGrid_1_0.setMnemonicParsing(false);
        btnGrid_1_0.setPrefHeight(230.0);
        btnGrid_1_0.setPrefWidth(345.0);
        btnGrid_1_0.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_0.setText("O");
        btnGrid_1_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_1_0.setWrapText(true);
        btnGrid_1_0.setFont(new Font(96.0));

        GridPane.setRowIndex(btnGrid_2_0, 2);
        btnGrid_2_0.setMnemonicParsing(false);
        btnGrid_2_0.setPrefHeight(230.0);
        btnGrid_2_0.setPrefWidth(345.0);
        btnGrid_2_0.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_2_0.setText("X");
        btnGrid_2_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_0.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_2_0.setWrapText(true);
        btnGrid_2_0.setFont(new Font(96.0));

        GridPane.setColumnIndex(btnGrid_2_1, 1);
        GridPane.setHalignment(btnGrid_2_1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnGrid_2_1, 2);
        btnGrid_2_1.setMnemonicParsing(false);
        btnGrid_2_1.setPrefHeight(230.0);
        btnGrid_2_1.setPrefWidth(345.0);
        btnGrid_2_1.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_2_1.setText("O");
        btnGrid_2_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_1.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGrid_2_1.setWrapText(true);
        btnGrid_2_1.setFont(new Font(96.0));

        playerOneScore.setLayoutX(828.0);
        playerOneScore.setLayoutY(196.0);
        playerOneScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOneScore.setStrokeWidth(0.0);
        playerOneScore.setText("00");
        playerOneScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerOneScore.setWrappingWidth(115.0);
        playerOneScore.setFont(new Font(64.0));

        playerTowScore.setLayoutX(917.0);
        playerTowScore.setLayoutY(198.0);
        playerTowScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTowScore.setStrokeWidth(0.0);
        playerTowScore.setText("00");
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

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btnGrid_0_0);
        gridPane.getChildren().add(btnGrid_0_1);
        gridPane.getChildren().add(btnGrid_0_2);
        gridPane.getChildren().add(btnGrid_1_2);
        gridPane.getChildren().add(btnGrid_2_2);
        gridPane.getChildren().add(btnGrid_1_1);
        gridPane.getChildren().add(btnGrid_1_0);
        gridPane.getChildren().add(btnGrid_2_0);
        gridPane.getChildren().add(btnGrid_2_1);
        getChildren().add(gridPane);
        getChildren().add(playerOneScore);
        getChildren().add(playerTowScore);
        getChildren().add(column);

            }
    }
