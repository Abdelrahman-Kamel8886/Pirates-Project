package piratesproject.forms.lodinanimation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Taj
 */
public class LodingAnimationController extends LodingAnimationForm implements Initializable {

    public LodingAnimationController() {
        setRotate(c2, true, 360, 10);
        setRotate(c1, true, 360, 15);
        setRotate(c3, true, 180, 20);
    }

    @FXML
    private Label label;

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    static void setRotate(Circle c1, boolean reverse, int angle, int duration) {
        RotateTransition rt;
        rt = new RotateTransition(Duration.seconds(duration), c1);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(18);
        rt.play();
    }

}
