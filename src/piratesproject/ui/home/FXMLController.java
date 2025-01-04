package piratesproject.ui.home;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FXMLController extends HomePage {

    private static final double BOX_TOP_MARGIN_RATIO = 0.05;
    private static final double BOX_RIGHT_MARGIN_RATIO = 0.02;
    private static final double BOX_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double BOX_LEFT_MARGIN_RATIO = 0.02;

    private static final double GRID_TOP_MARGIN_RATIO = 0.02;
    private static final double GRID_RIGHT_MARGIN_RATIO = 0.08;
    private static final double GRID_BOTTOM_MARGIN_RATIO = 0.08;
    private static final double GRID_LEFT_MARGIN_RATIO = 0.08;

    public FXMLController(Stage stage) {
        initializeImages();
        styleComponents();
        addResponsiveBehavior(stage);
    }

    private void initializeImages() {
        imageView.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/app_logo.png").toExternalForm()));
        imageView1.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/multi.png").toExternalForm()));
        imageView0.setImage(new Image(getClass().getResource("/piratesproject/drawable/icons/multi.png").toExternalForm()));
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
            box.setSpacing(width/2);
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
