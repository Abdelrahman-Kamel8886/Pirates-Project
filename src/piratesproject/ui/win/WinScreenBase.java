package piratesproject.ui.win;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import piratesproject.utils.Consts;

public  class WinScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final MediaView mediaView;

    public WinScreenBase() {

        imageView = new ImageView();
        mediaView = new MediaView();

        setId("AnchorPane");
        setMaxHeight(668.0);
        setMaxWidth(1080.0);
        setPrefHeight(1920.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/ui/win/winscreen.css");

        imageView.setFitHeight(1080.0);
        imageView.setFitWidth(1920.0);
        imageView.setLayoutX(-21.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource(Consts.HOME_BACKGROUND).toExternalForm()));

        AnchorPane.setTopAnchor(mediaView, 151.0);
        mediaView.setFitHeight(700.0);
        mediaView.setFitWidth(1200.0);
        mediaView.setLayoutX(395.0);
        mediaView.setLayoutY(151.0);

        getChildren().add(imageView);
        getChildren().add(mediaView);

    }
}
