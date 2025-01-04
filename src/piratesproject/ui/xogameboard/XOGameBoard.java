package piratesproject.ui.xogameboard;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import piratesproject.utils.Consts;

public class XOGameBoard extends AnchorPane {

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

    public XOGameBoard(Stage stage ) {

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

        setId("AnchorPane");
        setPrefHeight(304.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/ui/xogameboard//piratesproject/drawable/styles/xogameboard.css");

        imageView.setFitHeight(343.0);
        imageView.setFitWidth(600.0);
        //imageView.setPickOnBounds(true);
        //imageView.setPreserveRatio(true);
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

        btnGrid_1_2.setLayoutX(354.0);
        btnGrid_1_2.setLayoutY(169.0);
        btnGrid_1_2.setMnemonicParsing(false);
        btnGrid_1_2.setPrefHeight(65.0);
        btnGrid_1_2.setPrefWidth(100.0);
        btnGrid_1_2.setStyle("-fx-background-color: private String userFirstName;     private String userLastName;    private String userName;     private String userPassword;     private Boolean userIsOnline;     private Boolean userIsplayingnow;     private int userTotalGamePlayed;     private int userTotalScore;;");
        btnGrid_1_2.setText("x");
        btnGrid_1_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnGrid_1_2.setWrapText(true);

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

    }
}
