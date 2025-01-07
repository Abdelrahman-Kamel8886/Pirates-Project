package piratesproject.ui.home;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Strings;
import piratesproject.ui.login.LoginController;
import piratesproject.ui.xogameboard.XOGameBoard;
import piratesproject.utils.SharedModel;

public class HomePageController extends HomePage {

    private static final double BOX_TOP_MARGIN_RATIO = 0.05;
    private static final double BOX_RIGHT_MARGIN_RATIO = 0.02;
    private static final double BOX_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double BOX_LEFT_MARGIN_RATIO = 0.02;

    private static final double GRID_TOP_MARGIN_RATIO = 0.02;
    private static final double GRID_RIGHT_MARGIN_RATIO = 0.08;
    private static final double GRID_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double GRID_LEFT_MARGIN_RATIO = 0.08;
    Stage myStage;

    public HomePageController(Stage stage) {
        myStage = stage;
        initView();
        styleComponents();

    }

    private void initView() {
        logoImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/app_logo.png").toExternalForm()));
        multiPlayersImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/multi.png").toExternalForm()));
        computerImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/computer.png").toExternalForm()));

        if (SharedModel.getUser() == null) {
            initGuestView();
        } else {
            initUserView();
        }
        onClicks();
    }

    private void initGuestView() {
        avatar.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/guest.png").toExternalForm()));
        userNameText.setText(Strings.SIGNIN_TEXT);
        userNameText.setUnderline(true);
        scoreText.setVisible(false);
        gridPane.setVisible(false);

    }

    private void initUserView() {
        userNameText.setText(SharedModel.getUser().getUserName());
        scoreText.setText("Score : "+SharedModel.getUser().getScore());
        avatar.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/avatar.png").toExternalForm()));
    }

    private void onClicks() {

        if (SharedModel.getUser() == null) {
            userNameText.setOnMouseClicked((MouseEvent event) -> {
                goToLogin();
            });
        }

        multiPlayersImage.setOnMouseClicked((MouseEvent event) -> {
            goToGame();
        });
        computerImage.setOnMouseClicked((MouseEvent event) -> {
            Parent home = new XOGameBoard(myStage);
            goToGame();
        });
    }

    void goToLogin() {
        LoginController loginPage = new LoginController(myStage);
        Main.resetScene(loginPage);
    }

    private void styleComponents() {
        box.setId("box");
        box0.setId("box");
        box1.setId("box");
        getStylesheets().add("/piratesproject/drawable/styles/home_page.css");
    }

    private void addResponsiveBehavior(Stage stage) {

        stage.widthProperty().addListener((observable, oldValue, newValue) -> updateMargins(stage));
        stage.heightProperty().addListener((observable, oldValue, newValue) -> updateMargins(stage));
    }

    private void updateMargins(Stage stage) {
        double width = stage.getWidth();
        double height = stage.getHeight();

        if (width > 0 && height > 0) {
            GridPane.setMargin(box, calculateInsets(height, width, BOX_TOP_MARGIN_RATIO, BOX_RIGHT_MARGIN_RATIO, BOX_BOTTOM_MARGIN_RATIO, BOX_LEFT_MARGIN_RATIO));
            GridPane.setMargin(gridPane, calculateInsets(height, width, GRID_TOP_MARGIN_RATIO, GRID_RIGHT_MARGIN_RATIO, GRID_BOTTOM_MARGIN_RATIO, GRID_LEFT_MARGIN_RATIO));
        }
    }

    private Insets calculateInsets(double height, double width, double topRatio, double rightRatio, double bottomRatio, double leftRatio) {
        double top = height * topRatio;
        double right = width * rightRatio;
        double bottom = height * bottomRatio;
        double left = width * leftRatio;
        return new Insets(top, right, bottom, left);
    }

    private void goToGame() {
        Parent game = new XOGameBoard(myStage);
        Main.resetScene(game);
    }
}
