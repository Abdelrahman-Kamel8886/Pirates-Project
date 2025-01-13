package piratesproject.ui.splash;

import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.ui.home.HomePageController;

public class SplashController extends SplashPage {

    private Stage mystage;
    private Task<Void> task;

    public SplashController(Stage stage) {
        mystage = stage;
        initView();
    }

    private void initView() {
        getStylesheets().add(Pathes.SPLASH_STYLE_PATH);
        imageView.setImage(new Image(getClass().getResource(Pathes.SPLASH_LOGO_PATH).toExternalForm()));
        task = taskWorker(3);
        progressBar.progressProperty().bind(task.progressProperty());

        new Thread(task).start();

        task.setOnSucceeded(event -> gotoHome());
    }

    private Task<Void> taskWorker(int seconds) {
        return new Task() {
            @Override
            protected Void call() throws Exception {
                int totalMillis = seconds * 1000;
                int updateInterval = 50;
                int steps = totalMillis / updateInterval;

                for (int i = 0; i <= steps; i++) {
                    if (isCancelled()) {
                        return null;
                    }
                    updateProgress((double) i / steps, 1.0);
                    Thread.sleep(updateInterval);
                }
                return null;
            }
        };
    }

    public void gotoHome() {
        task.cancel();
        Parent homePage = new HomePageController(mystage);
        Main.resetScene(homePage);
    }
}
