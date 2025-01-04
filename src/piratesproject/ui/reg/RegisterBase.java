package piratesproject.ui.reg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RegisterBase extends AnchorPane {

    protected final VBox vBox;
    protected final TextField firstNameTF;
    protected final Label firstNameReq;
    protected final TextField lastNameTF;
    protected final Label lastNameReq;
    protected final TextField usernameTF;
    protected final Label usernameReq;
    protected final PasswordField passwordTF;
    protected final Label passwordReq;
    protected final PasswordField confirmPasswordTF;
    protected final Label confirmPasswordReq;
    protected final Button signUpButton;
    protected final HBox hBox;
    protected Stage stage;
    protected final Hyperlink loginText;
    Rectangle2D screenBounds ;
    double screenWidth;
    double screenHeight;
    

    public RegisterBase(Stage s) {
        screenBounds = Screen.getPrimary().getBounds();
        screenWidth= screenBounds.getWidth();
        screenHeight= screenBounds.getHeight();
        stage = s;
        stage.setMaximized(false);
        vBox = new VBox();
        firstNameTF = new TextField();
        firstNameReq = new Label();
        lastNameTF = new TextField();
        lastNameReq = new Label();
        usernameTF = new TextField();
        usernameReq = new Label();
        passwordTF = new PasswordField();
        passwordReq = new Label();
        confirmPasswordTF = new PasswordField();
        confirmPasswordReq = new Label();
        signUpButton = new Button();
        hBox = new HBox();
        loginText = new Hyperlink();


        draw();
        

    }

    private void draw() {
      stage.setMaximized(true);
      stage.setFullScreen(true);
        setId("AnchorPane");

        getStylesheets().add("piratesproject/drawable/styles/registerStyle.css");

        if(!stage.isMaximized()){
           vBox.setLayoutX(screenWidth * 0.06);
           vBox.setLayoutY(screenHeight * 0.1);
        }
         vBox.setLayoutX(screenWidth * 0.12);
         vBox.setLayoutY(screenHeight * 0.3);
        

        vBox.setAlignment(Pos.CENTER);
        

        firstNameTF.setMinHeight(USE_PREF_SIZE);
        firstNameTF.setPrefHeight(25.0);
        firstNameTF.setPromptText("First Name");

        VBox.setMargin(firstNameTF, new Insets(0.0, 0.0, 1.0, 0.0));
        firstNameTF.setFont(new Font(20.0));

        firstNameReq.setText("First name required");
        firstNameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        firstNameReq.setVisible(false);
        firstNameReq.setFont(new Font(20.0));
        VBox.setMargin(firstNameReq, new Insets(0.0, 0.0, 6.0, 0.0));

        lastNameTF.setLayoutX(10.0);
        lastNameTF.setLayoutY(10.0);
        lastNameTF.setMinHeight(USE_PREF_SIZE);
        lastNameTF.setPrefHeight(25.0);
        lastNameTF.setPromptText("Last Name");

        VBox.setMargin(lastNameTF, new Insets(0.0, 0.0, 6.0, 0.0));
        lastNameTF.setFont(new Font(20.0));

        lastNameReq.setLayoutX(10.0);
        lastNameReq.setLayoutY(41.0);
        lastNameReq.setText("Last name required");
        lastNameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        lastNameReq.setVisible(false);
        lastNameReq.setFont(new Font(20.0));

        usernameTF.setLayoutX(10.0);
        usernameTF.setLayoutY(33.0);
        usernameTF.setMinHeight(USE_PREF_SIZE);
        usernameTF.setPrefHeight(25.0);
        usernameTF.setPrefWidth(136.0);
        usernameTF.setPromptText("Username");

        VBox.setMargin(usernameTF, new Insets(0.0, 0.0, 6.0, 0.0));
        usernameTF.setFont(new Font(20.0));

        usernameReq.setLayoutX(10.0);
        usernameReq.setLayoutY(95.0);
        usernameReq.setText("Username required");
        usernameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        usernameReq.setVisible(false);
        usernameReq.setFont(new Font(20.0));

        passwordTF.setMinHeight(USE_PREF_SIZE);
        passwordTF.setPrefHeight(25.0);
        passwordTF.setPromptText("Password");

        VBox.setMargin(passwordTF, new Insets(0.0, 0.0, 6.0, 0.0));
        passwordTF.setFont(new Font(20.0));

        passwordReq.setLayoutX(10.0);
        passwordReq.setLayoutY(148.0);
        passwordReq.setText("Password required");
        passwordReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        passwordReq.setVisible(false);
        passwordReq.setFont(new Font(20.0));

        confirmPasswordTF.setLayoutX(10.0);
        confirmPasswordTF.setLayoutY(121.0);
        confirmPasswordTF.setMinHeight(USE_PREF_SIZE);
        confirmPasswordTF.setPrefHeight(25.0);
        confirmPasswordTF.setStyle("textfield");
        confirmPasswordTF.setPromptText("Confirm Password");
//        confirmPasswordTF.setStyle("-fx-background-radius: 100;");
        confirmPasswordTF.setFont(new Font(20.0));

        confirmPasswordReq.setLayoutX(10.0);
        confirmPasswordReq.setLayoutY(201.0);
        confirmPasswordReq.setText("Confirm Password required");
        confirmPasswordReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        confirmPasswordReq.setVisible(false);
        confirmPasswordReq.setFont(new Font(20.0));

        signUpButton.setMinHeight(USE_PREF_SIZE);
        signUpButton.setMnemonicParsing(false);
        signUpButton.setPrefHeight(48.0);
        signUpButton.setPrefWidth(screenWidth*0.12);
        signUpButton.setStyle("-fx-background-color: #e28409; -fx-background-radius: 50;");
        signUpButton.setText("SignUp");
        VBox.setMargin(signUpButton, new Insets(1.0, 0.0, 16.0, 20.0));
        signUpButton.setFont(new Font(20.0));
        signUpButton.setPadding(new Insets(10, 25.0, 10, 25.0));

        hBox.setPrefHeight(17.0);
        hBox.setPrefWidth(183.0);

//        hBox.translateXProperty().bind(stage.widthProperty().multiply(0.02));
//        hBox.translateYProperty().bind(stage.heightProperty().multiply(0.006));
//        vBox.translateXProperty().bind(stage.widthProperty().multiply(0.03));
//        vBox.translateYProperty().bind(stage.heightProperty().multiply(0.003));
        vBox.prefWidthProperty().bind(stage.widthProperty().multiply(0.34)); // 
        vBox.prefHeightProperty().bind(stage.heightProperty().multiply(0.48)); // }
        // 
         firstNameTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));
         lastNameTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));// }   
         usernameTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));
         passwordTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));
         confirmPasswordTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));
        HBox.setMargin(loginText, new Insets(0.0, 0.0, 0.0, 5.0));
//      firstNameTF.prefWidthProperty().bind(stage.widthProperty().multiply(0.1)); // 
//        firstNameTF.prefHeightProperty().bind(stage.heightProperty().multiply(0.055)); 
//       
        loginText.setText(" Login");
        loginText.setFont(new Font(20));
        HBox.setMargin(loginText, new Insets(0.0, 0, 0.0, screenWidth*0.16));
        hBox.getChildren().addAll(loginText);
        vBox.getChildren().addAll(firstNameTF, firstNameReq, lastNameTF, lastNameReq, usernameTF, usernameReq, passwordTF, passwordReq, confirmPasswordTF, confirmPasswordReq, signUpButton,
                hBox
        );
        getChildren().add(vBox);
    }



    
}