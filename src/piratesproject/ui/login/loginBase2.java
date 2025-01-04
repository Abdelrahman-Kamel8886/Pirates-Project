package piratesproject.ui.login;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import piratesproject.ui.reg.LoginBase;

public class loginBase2 extends AnchorPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final TextField TFname;
    protected final Label nameError;
    protected final TextField Tfpass;
    protected final Label passerror;
    protected final Button Blogin;
    protected final Hyperlink sginuplink;
    private Stage mystage;

    public loginBase2(Stage stage) {
        mystage = stage;
        imageView = new ImageView();
        vBox = new VBox();
        TFname = new TextField();
        nameError = new Label();
        Tfpass = new TextField();
        passerror = new Label();
        Blogin = new Button();
        sginuplink = new Hyperlink();

        drawAllViews();
        listenToAllEvents();
    }
    
    private void drawAllViews(){
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
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

        VBox formContainer = new VBox(6);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setId("formContainer");

        formContainer.translateXProperty().bind(mystage.widthProperty().multiply(0.15));
        formContainer.translateYProperty().bind(mystage.heightProperty().multiply(0.45));

        TFname.setPromptText("userName");
        TFname.getStyleClass().add("textField");
        TFname.prefWidthProperty().bind(mystage.widthProperty().multiply(0.24)); // 50% of stage width

        Tfpass.setPromptText("password");
        Tfpass.getStyleClass().add("textField");
        Tfpass.prefWidthProperty().bind(mystage.widthProperty().multiply(0.24)); // 50% of stage width

        Blogin.setText("login");
        Blogin.getStyleClass().add("loginButton");
        
        Blogin.prefWidthProperty().bind(mystage.widthProperty().multiply(0.12)); // 50% of stage width

        formContainer.getChildren().addAll(TFname, nameError, Tfpass, passerror, Blogin, sginuplink);

        sginuplink.setText("Register");
        sginuplink.getStyleClass().add("registerLink");
        
        //sginuplink.prefWidthProperty().bind(mystage.widthProperty().multiply(0.09)); // 50% of stage width

        nameError.setText("enter your name");
        nameError.setVisible(false);
        nameError.getStyleClass().add("errorLabel");

        passerror.setText("enter your password");
        passerror.setVisible(false);
        passerror.getStyleClass().add("errorLabel");

        getChildren().add(imageView);
        getChildren().add(formContainer);
    }
    
    private void listenToAllEvents(){
        Blogin.setOnAction(event -> login());
        sginuplink.setOnAction(event -> gotosginup());
    }

    private boolean login() {
        boolean islogin = false;
        if (isFull()) {
            String name = TFname.getText();
            String pass = Tfpass.getText();
            System.out.println("Done");
        }
        return islogin;
    }

    private boolean isFull() {
        boolean isfull = true;

        if (TFname.getText().isEmpty()) {
            nameError.setVisible(true);
            isfull = false;
        } else {
            nameError.setVisible(false);
        }

        if (Tfpass.getText().isEmpty()) {
            passerror.setVisible(true);
            isfull = false;
        } else {
            passerror.setVisible(false);
        }
        return isfull;
    }

   private void gotosginup() {
    LoginBase signupPage = new LoginBase(); // Replace with the new page's class
    Scene signupScene = new Scene(signupPage);
    mystage.setScene(signupScene);
}
}
