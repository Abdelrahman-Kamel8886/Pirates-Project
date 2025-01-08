package piratesproject.forms.receivingInvition;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class ReceivingInvitationFormBase extends VBox {

    protected final Label label;
    protected final VBox vBox;
    protected final ImageView imageView;
    protected final HBox hBox;
    protected final Text text;
    protected final Text nameText;
    protected final HBox hBox0;
    protected final Text text0;
    protected final Text scoreText;
    protected final HBox hBox1;
    protected final Button acceptButton;
    protected final Button declineButton;

    public ReceivingInvitationFormBase() {

        label = new Label();
        vBox = new VBox();
        imageView = new ImageView();
        hBox = new HBox();
        text = new Text();
        nameText = new Text();
        hBox0 = new HBox();
        text0 = new Text();
        scoreText = new Text();
        hBox1 = new HBox();
        acceptButton = new Button();
        declineButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStylesheets().add("/piratesproject/forms/receivingInvition/../../drawable/styles/receivinginvitationform.css");

        label.setStyle("-fx-background-color: #a01108; -fx-background-radius: 10;");
        label.setText("You have received a new game invitation");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        label.setFont(new Font("Berlin Sans FB Demi Bold", 30.0));
        VBox.setMargin(label, new Insets(30.0, 0.0, 0.0, 90.0));
        label.setPadding(new Insets(10.0, 20.0, 10.0, 20.0));

        vBox.setMaxWidth(USE_PREF_SIZE);
        vBox.setMinWidth(USE_PREF_SIZE);
        vBox.setPrefHeight(350.0);
        vBox.setPrefWidth(500.0);
        vBox.setStyle("-fx-background-color: #436399; -fx-background-radius: 30;");

        imageView.setFitHeight(120.0);
        imageView.setFitWidth(120.0);
        imageView.setImage(new Image(getClass().getResource("../../drawable/icons/avatar.png").toExternalForm()));
        VBox.setMargin(imageView, new Insets(20.0, 0.0, 0.0, 190.0));

        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#f5efef"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Name:");
        text.setFont(new Font("Segoe Script", 24.0));
        HBox.setMargin(text, new Insets(20.0, 0.0, 0.0, 20.0));

        nameText.setFill(javafx.scene.paint.Color.valueOf("#f5efef"));
        nameText.setLayoutX(30.0);
        nameText.setLayoutY(56.0);
        nameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        nameText.setStrokeWidth(0.0);
        nameText.setText("Jailan Medhat");
        nameText.setFont(new Font("Old English Text MT", 24.0));
        HBox.setMargin(nameText, new Insets(15.0, 0.0, 0.0, 35.0));

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        text0.setFill(javafx.scene.paint.Color.valueOf("#f5efef"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Score:");
        text0.setFont(new Font("Segoe Script", 24.0));
        HBox.setMargin(text0, new Insets(20.0, 0.0, 0.0, 20.0));

        scoreText.setFill(javafx.scene.paint.Color.valueOf("#f5efef"));
        scoreText.setLayoutX(30.0);
        scoreText.setLayoutY(56.0);
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText("500");
        scoreText.setFont(new Font("Segoe Script", 24.0));
        HBox.setMargin(scoreText, new Insets(25.0, 0.0, 0.0, 35.0));
        VBox.setMargin(vBox, new Insets(30.0, 0.0, 0.0, 140.0));

        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        acceptButton.setMaxHeight(USE_PREF_SIZE);
        acceptButton.setMaxWidth(USE_PREF_SIZE);
        acceptButton.setMinHeight(USE_PREF_SIZE);
        acceptButton.setMinWidth(USE_PREF_SIZE);
        acceptButton.setMnemonicParsing(false);
        acceptButton.setPrefHeight(50.0);
        acceptButton.setPrefWidth(170.0);
        acceptButton.setStyle("-fx-background-radius: 30; -fx-background-color: #32bd00;");
        acceptButton.setText("Accept");
        acceptButton.setTextFill(javafx.scene.paint.Color.valueOf("#fffbfb"));
        acceptButton.setFont(new Font("Segoe UI Semibold", 17.0));
        HBox.setMargin(acceptButton, new Insets(0.0, 0.0, 0.0, 45.0));

        declineButton.setLayoutX(40.0);
        declineButton.setLayoutY(10.0);
        declineButton.setMaxHeight(USE_PREF_SIZE);
        declineButton.setMaxWidth(USE_PREF_SIZE);
        declineButton.setMinHeight(USE_PREF_SIZE);
        declineButton.setMinWidth(USE_PREF_SIZE);
        declineButton.setMnemonicParsing(false);
        declineButton.setPrefHeight(50.0);
        declineButton.setPrefWidth(170.0);
        declineButton.setStyle("-fx-background-radius: 30; -fx-background-color: #a01108;");
        declineButton.setText("Decline");
        declineButton.setTextFill(javafx.scene.paint.Color.valueOf("#fffbfb"));
        declineButton.setFont(new Font("Segoe UI Semibold", 17.0));
        HBox.setMargin(declineButton, new Insets(0.0, 0.0, 0.0, 40.0));
        VBox.setMargin(hBox1, new Insets(40.0, 0.0, 0.0, 150.0));

        getChildren().add(label);
        vBox.getChildren().add(imageView);
        hBox.getChildren().add(text);
        hBox.getChildren().add(nameText);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(text0);
        hBox0.getChildren().add(scoreText);
        vBox.getChildren().add(hBox0);
        getChildren().add(vBox);
        hBox1.getChildren().add(acceptButton);
        hBox1.getChildren().add(declineButton);
        getChildren().add(hBox1);

    }
}
