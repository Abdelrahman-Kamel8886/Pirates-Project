package piratesproject.forms.draw;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piratesproject.enums.LevelTypesEnum;

public class DrawForm {
    private static Stage window;
    static LevelTypesEnum level ; 

    public DrawForm(LevelTypesEnum level) {
        this.level = level ;
    }
    
    public static void display(Stage owner, String path) {
        if (window != null && window.isShowing()) {
            window.toFront(); // Bring the existing window to the front
            return; 
        }

        window = new Stage();
        window.initOwner(owner);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Video");
        window.setResizable(false);

        // Pass the video path to the DrawController
        DrawController drawController = new DrawController(window, path);
        Parent root = drawController;

        Scene scene = new Scene(root);
        window.setScene(scene);

        // Add a listener to stop the video when the window is closed
        window.setOnCloseRequest(event -> {
            drawController.getMediaPlayer().stop(); // Stop the video
        });

        window.show();
    }

    public static void closeForm() {
        window.close();
    }
}