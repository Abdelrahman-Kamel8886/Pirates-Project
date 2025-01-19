package piratesproject.ui.auth.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.models.LoginResponseModel;
import piratesproject.ui.auth.reg.RegisterController;

public class LoginBase extends AnchorPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final TextField TFname;
    protected final Label nameError;
    protected final PasswordField Tfpass;
    protected final Label passerror;
    protected final Button Blogin;
    protected final Hyperlink sginuplink;
    protected final Stage mystage;
    protected Socket mySocket;
    protected ObjectInputStream ois;
    protected DataOutputStream dos;
    protected final Hyperlink Guest;

    public LoginBase(Stage stage) {
        mystage = stage;
        imageView = new ImageView();
        vBox = new VBox();
        TFname = new TextField();
        nameError = new Label();
        Tfpass = new PasswordField();
        passerror = new Label();
        Blogin = new Button();
        sginuplink = new Hyperlink();
        Guest = new Hyperlink();

        drawAllViews();
    }

    private void drawAllViews() {
        setId("AnchorPane");
        //setPrefHeight(400.0);
        //setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/piratesproject/drawable/styles/login.css");

        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);

        imageView.setImage(new Image(getClass().getResource("/piratesproject/drawable/images/loginbg.jpg").toExternalForm()));
        imageView.setId("backgroundImage");
        imageView.fitWidthProperty().bind(mystage.widthProperty());
        imageView.fitHeightProperty().bind(mystage.heightProperty());

        VBox formContainer = new VBox(7);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setId("formContainer");
        formContainer.translateXProperty().bind(mystage.widthProperty().multiply(0.15));
        formContainer.translateYProperty().bind(mystage.heightProperty().multiply(0.45));

        TFname.setPromptText("userName");
        TFname.getStyleClass().add("textField");
        TFname.prefWidthProperty().bind(mystage.widthProperty().multiply(0.24));
        TFname.prefHeightProperty().bind(mystage.widthProperty().multiply(0.03));

        Tfpass.setPromptText("password");
        Tfpass.getStyleClass().add("textField");
        Tfpass.prefWidthProperty().bind(mystage.widthProperty().multiply(0.24));
        Tfpass.prefHeightProperty().bind(mystage.widthProperty().multiply(0.03));

        Blogin.setText("login");
        Blogin.getStyleClass().add("loginButton");

        Blogin.prefWidthProperty().bind(mystage.widthProperty().multiply(0.12));
        Blogin.prefHeightProperty().bind(mystage.widthProperty().multiply(0.03));

        formContainer.getChildren().addAll(TFname, nameError, Tfpass, passerror, Blogin, sginuplink,Guest);

        sginuplink.setText("Don't have an accout? Register");
        sginuplink.getStyleClass().add("registerLink");

        Guest.setText("Guest");
        Guest.getStyleClass().add("registerLink");
        
        nameError.setText("enter your name");
        nameError.setVisible(false);
        nameError.getStyleClass().add("errorLabel");

        passerror.setText("enter your password");
        passerror.setVisible(false);
        passerror.getStyleClass().add("errorLabel");
        
        

        getChildren().add(imageView);
        getChildren().add(formContainer);
    }

}
