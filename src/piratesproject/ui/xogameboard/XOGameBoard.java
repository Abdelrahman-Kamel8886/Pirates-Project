package piratesproject.ui.xogameboard;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import piratesproject.utils.Consts;

public  class XOGameBoard extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnGrid_0_0;
    protected final Button btnGrid_0_1;
    protected final Button btnGrid_0_2;
    protected final Button btnGrid_1_0;
    protected final Button btnGrid_1_1;
    protected final Button btnGrid_1_2;
    protected final Button btnGrid_2_0;
    protected final Button btnGrid_2_1;
    protected final Button btnGrid_2_2;
    protected final Text playerOneScore;
    protected final Text playerTowScore;
    protected final Button btnGrid_1_21;
    protected final Button btnGrid_1_22;
    protected final Button btnGrid_1_23;
    protected final Button btnGrid_1_211;
    protected final Button btnGrid_1_221;
    protected final Button btnGrid_1_24;
    protected final Button btnGrid_1_212;
    protected final Button btnGrid_1_222;
    
    public XOGameBoard(Stage stage ){ 

        imageView = new ImageView();
        btnGrid_0_0 = new Button();
        btnGrid_0_1 = new Button();
        btnGrid_0_2 = new Button();
        btnGrid_1_0 = new Button();
        btnGrid_1_1 = new Button();
        btnGrid_1_2 = new Button();
        btnGrid_2_0 = new Button();
        btnGrid_2_1 = new Button();
        btnGrid_2_2 = new Button();
        playerOneScore = new Text();
        playerTowScore = new Text();
        btnGrid_1_21 = new Button();
        btnGrid_1_22 = new Button();
        btnGrid_1_23 = new Button();
        btnGrid_1_211 = new Button();
        btnGrid_1_221 = new Button();
        btnGrid_1_24 = new Button();
        btnGrid_1_212 = new Button();
        btnGrid_1_222 = new Button();

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

        btnGrid_0_0.setLayoutX(139.0);
        btnGrid_0_0.setLayoutY(92.0);
        btnGrid_0_0.setMnemonicParsing(false);
        btnGrid_0_0.setPrefHeight(65.0);
        btnGrid_0_0.setPrefWidth(92.0);
        btnGrid_0_0.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_0_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        btnGrid_0_1.setLayoutX(243.0);
        btnGrid_0_1.setLayoutY(92.0);
        btnGrid_0_1.setMnemonicParsing(false);
        btnGrid_0_1.setPrefHeight(65.0);
        btnGrid_0_1.setPrefWidth(100.0);
        btnGrid_0_1.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_0_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_1.setWrapText(true);

        btnGrid_0_2.setLayoutX(354.0);
        btnGrid_0_2.setLayoutY(92.0);
        btnGrid_0_2.setMnemonicParsing(false);
        btnGrid_0_2.setPrefHeight(65.0);
        btnGrid_0_2.setPrefWidth(100.0);
        btnGrid_0_2.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_0_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_0_2.setWrapText(true);

        btnGrid_1_0.setLayoutX(136.0);
        btnGrid_1_0.setLayoutY(169.0);
        btnGrid_1_0.setMnemonicParsing(false);
        btnGrid_1_0.setPrefHeight(65.0);
        btnGrid_1_0.setPrefWidth(92.0);
        btnGrid_1_0.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_1_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_0.setWrapText(true);

        btnGrid_1_1.setLayoutX(240.0);
        btnGrid_1_1.setLayoutY(169.0);
        btnGrid_1_1.setMnemonicParsing(false);
        btnGrid_1_1.setPrefHeight(65.0);
        btnGrid_1_1.setPrefWidth(100.0);
        btnGrid_1_1.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_1_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_1.setWrapText(true);

        AnchorPane.setBottomAnchor(btnGrid_1_2, 317.0);
        AnchorPane.setLeftAnchor(btnGrid_1_2, 1124.0);
        AnchorPane.setRightAnchor(btnGrid_1_2, 413.0);
        AnchorPane.setTopAnchor(btnGrid_1_2, 522.0);
        btnGrid_1_2.setLayoutX(1124.0);
        btnGrid_1_2.setLayoutY(522.0);
        btnGrid_1_2.setMnemonicParsing(false);
        btnGrid_1_2.setPrefHeight(241.0);
        btnGrid_1_2.setPrefWidth(383.0);
        btnGrid_1_2.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_2.setText("X");
        btnGrid_1_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_2.setWrapText(true);
        btnGrid_1_2.setFont(new Font(96.0));

        btnGrid_2_0.setLayoutX(136.0);
        btnGrid_2_0.setLayoutY(245.0);
        btnGrid_2_0.setMnemonicParsing(false);
        btnGrid_2_0.setPrefHeight(65.0);
        btnGrid_2_0.setPrefWidth(92.0);
        btnGrid_2_0.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_2_0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_0.setWrapText(true);

        btnGrid_2_1.setLayoutX(240.0);
        btnGrid_2_1.setLayoutY(245.0);
        btnGrid_2_1.setMnemonicParsing(false);
        btnGrid_2_1.setPrefHeight(65.0);
        btnGrid_2_1.setPrefWidth(100.0);
        btnGrid_2_1.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_2_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_1.setWrapText(true);

        btnGrid_2_2.setLayoutX(354.0);
        btnGrid_2_2.setLayoutY(245.0);
        btnGrid_2_2.setMnemonicParsing(false);
        btnGrid_2_2.setPrefHeight(65.0);
        btnGrid_2_2.setPrefWidth(100.0);
        btnGrid_2_2.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_2_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_2_2.setWrapText(true);

        playerOneScore.setLayoutX(271.0);
        playerOneScore.setLayoutY(62.0);
        playerOneScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOneScore.setStrokeWidth(0.0);
        playerOneScore.setText("1");
        playerOneScore.setWrappingWidth(18.6708984375);

        playerTowScore.setLayoutX(291.0);
        playerTowScore.setLayoutY(62.0);
        playerTowScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTowScore.setStrokeWidth(0.0);
        playerTowScore.setText("1");
        playerTowScore.setWrappingWidth(18.6708984375);

        btnGrid_1_21.setLayoutX(757.0);
        btnGrid_1_21.setLayoutY(531.0);
        btnGrid_1_21.setMnemonicParsing(false);
        btnGrid_1_21.setPrefHeight(223.0);
        btnGrid_1_21.setPrefWidth(353.0);
        btnGrid_1_21.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_21.setText("O");
        btnGrid_1_21.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_21.setWrapText(true);
        btnGrid_1_21.setFont(new Font(96.0));

        btnGrid_1_22.setLayoutX(404.0);
        btnGrid_1_22.setLayoutY(522.0);
        btnGrid_1_22.setMnemonicParsing(false);
        btnGrid_1_22.setPrefHeight(241.0);
        btnGrid_1_22.setPrefWidth(330.0);
        btnGrid_1_22.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_22.setText("O");
        btnGrid_1_22.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_22.setWrapText(true);
        btnGrid_1_22.setFont(new Font(96.0));

        btnGrid_1_23.setLayoutX(1124.0);
        btnGrid_1_23.setLayoutY(290.0);
        btnGrid_1_23.setMnemonicParsing(false);
        btnGrid_1_23.setPrefHeight(241.0);
        btnGrid_1_23.setPrefWidth(383.0);
        btnGrid_1_23.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_23.setText("O");
        btnGrid_1_23.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_23.setWrapText(true);
        btnGrid_1_23.setFont(new Font(96.0));

        btnGrid_1_211.setLayoutX(757.0);
        btnGrid_1_211.setLayoutY(299.0);
        btnGrid_1_211.setMnemonicParsing(false);
        btnGrid_1_211.setPrefHeight(223.0);
        btnGrid_1_211.setPrefWidth(353.0);
        btnGrid_1_211.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_211.setText("X");
        btnGrid_1_211.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_211.setWrapText(true);
        btnGrid_1_211.setFont(new Font(96.0));

        btnGrid_1_221.setLayoutX(404.0);
        btnGrid_1_221.setLayoutY(290.0);
        btnGrid_1_221.setMnemonicParsing(false);
        btnGrid_1_221.setPrefHeight(241.0);
        btnGrid_1_221.setPrefWidth(330.0);
        btnGrid_1_221.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_221.setText("X");
        btnGrid_1_221.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_221.setWrapText(true);
        btnGrid_1_221.setFont(new Font(96.0));

        btnGrid_1_24.setLayoutX(1129.0);
        btnGrid_1_24.setLayoutY(781.0);
        btnGrid_1_24.setMnemonicParsing(false);
        btnGrid_1_24.setPrefHeight(241.0);
        btnGrid_1_24.setPrefWidth(383.0);
        btnGrid_1_24.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_24.setText("X");
        btnGrid_1_24.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_24.setWrapText(true);
        btnGrid_1_24.setFont(new Font(96.0));

        btnGrid_1_212.setLayoutX(771.0);
        btnGrid_1_212.setLayoutY(790.0);
        btnGrid_1_212.setMnemonicParsing(false);
        btnGrid_1_212.setPrefHeight(223.0);
        btnGrid_1_212.setPrefWidth(353.0);
        btnGrid_1_212.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_212.setText("O");
        btnGrid_1_212.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_212.setWrapText(true);
        btnGrid_1_212.setFont(new Font(96.0));

        btnGrid_1_222.setLayoutX(409.0);
        btnGrid_1_222.setLayoutY(781.0);
        btnGrid_1_222.setMnemonicParsing(false);
        btnGrid_1_222.setPrefHeight(241.0);
        btnGrid_1_222.setPrefWidth(330.0);
        btnGrid_1_222.setStyle("-fx-background-color: private String userFirstName; private String userLastName: ; private String userName: ; private String userPassword: ; private Boolean userIsOnline: ; private Boolean userIsplayingnow: ; private int userTotalGamePlayed: ; private int userTotalScore: ;");
        btnGrid_1_222.setText("X");
        btnGrid_1_222.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_222.setWrapText(true);
        btnGrid_1_222.setFont(new Font(96.0));

        getChildren().add(imageView);
        getChildren().add(btnGrid_0_0);
        getChildren().add(btnGrid_0_1);
        getChildren().add(btnGrid_0_2);
        getChildren().add(btnGrid_1_0);
        getChildren().add(btnGrid_1_1);
        getChildren().add(btnGrid_1_2);
        getChildren().add(btnGrid_2_0);
        getChildren().add(btnGrid_2_1);
        getChildren().add(btnGrid_2_2);
        getChildren().add(playerOneScore);
        getChildren().add(playerTowScore);
        getChildren().add(btnGrid_1_21);
        getChildren().add(btnGrid_1_22);
        getChildren().add(btnGrid_1_23);
        getChildren().add(btnGrid_1_211);
        getChildren().add(btnGrid_1_221);
        getChildren().add(btnGrid_1_24);
        getChildren().add(btnGrid_1_212);
        getChildren().add(btnGrid_1_222);

            }
    }
