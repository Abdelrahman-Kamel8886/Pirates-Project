package piratesproject.forms.draw;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DrawForm {
    private static Stage window;

    // Updated display method to accept a video path
    public static void display(Stage owner, String path) {
         if (window != null && window.isShowing()) {
        window.toFront(); // Bring the existing window to the front
        return; // Exit if the window is already open
    }
        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.WINDOW_MODAL);
        window.setTitle("Video");
        window.setResizable(false);

        // Pass the video path to the DrawController
        Parent root = new DrawController(owner, path);

        Scene scene = new Scene(root, 1920, 1080);
        window.setScene(scene);

        window.show();
    }
    
    public static void closeForm() {
        window.close();
    }   
}