package piratesproject.ui.home;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.ui.xogameboard.XOGameBoard;

public class FXMLController extends HomePage {

    private static final double BOX_TOP_MARGIN_RATIO = 0.05;
    private static final double BOX_RIGHT_MARGIN_RATIO = 0.02;
    private static final double BOX_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double BOX_LEFT_MARGIN_RATIO = 0.02;

    private static final double GRID_TOP_MARGIN_RATIO = 0.02;
    private static final double GRID_RIGHT_MARGIN_RATIO = 0.08;
    private static final double GRID_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double GRID_LEFT_MARGIN_RATIO = 0.08;
    Stage myStage ; 
    
    public FXMLController(Stage stage) {
        initializeImages();
        styleComponents();
        myStage = stage ; 
    }

 

    private void initializeImages() {
        logoImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/app_logo.png").toExternalForm()));
        multiPlayersImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/multi.png").toExternalForm()));
        computerImage.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/computer.png").toExternalForm()));
        avatar.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/avatar.png").toExternalForm()));
        multiPlayersImage.setOnMouseClicked((MouseEvent event) -> {
            Parent home =  new XOGameBoard(myStage);
            Main.resetScene(home);
        });
        computerImage.setOnMouseClicked((MouseEvent event) -> {
            Parent home =  new XOGameBoard(myStage);
            Main.resetScene(home);
        });

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
}
