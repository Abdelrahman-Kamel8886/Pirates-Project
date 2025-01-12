package piratesproject.forms.lodinanimation;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public abstract class LodingAnimationForm extends AnchorPane {

    protected final Circle c1;
    protected final Circle c2;
    protected final Circle c3;
    protected final Label label;

    public LodingAnimationForm() {

        c1 = new Circle();
        c2 = new Circle();
        c3 = new Circle();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/piratesproject/drawable/styles/sendInvitation.css");

        c1.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c1.setLayoutX(300.0);
        c1.setLayoutY(229.0);
        c1.setRadius(129.0);
        c1.setStroke(javafx.scene.paint.Color.valueOf("#0020d7"));
        c1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c1.setStrokeWidth(15.0);
        c1.setStyle("-fx-stroke-dash-array: 50;");

        c2.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c2.setLayoutX(300.0);
        c2.setLayoutY(230.0);
        c2.setRadius(91.0);
        c2.setStroke(javafx.scene.paint.Color.valueOf("#9bf000"));
        c2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c2.setStrokeWidth(13.0);
        c2.setStyle("-fx-stroke-dash-array: 50;");

        c3.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c3.setLayoutX(301.0);
        c3.setLayoutY(229.0);
        c3.setRadius(54.0);
        c3.setStroke(javafx.scene.paint.Color.valueOf("#00f0c8"));
        c3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c3.setStrokeWidth(10.0);
        c3.setStyle("-fx-stroke-dash-array: 50;");

        label.setLayoutX(82.0);
        label.setLayoutY(34.0);
        label.setStyle("-fx-background-color: #436399;;");
        label.setText("Waiting for a response. . .");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(39.0));

        getChildren().add(c1);
        getChildren().add(c2);
        getChildren().add(c3);
        getChildren().add(label);

    }
}
