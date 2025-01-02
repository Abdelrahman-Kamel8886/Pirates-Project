package piratesproject.ui.reg;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import piratesproject.models.UserModel;

public class LoginBase extends AnchorPane {

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
    protected final Text text;
    protected final Text loginText;

    public LoginBase() {
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
        text = new Text();
        loginText = new Text();

        draw();

        listenToAllEvents();
    }

    private void draw() {
        
      
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("piratesproject/drawable/styles/registerStyle.css");

        vBox.setLayoutX(79.0);
        vBox.setLayoutY(105.0);
        vBox.setPrefHeight(268.0);
        vBox.setPrefWidth(184.0);

        firstNameTF.setMinHeight(USE_PREF_SIZE);
        firstNameTF.setPrefHeight(25.0);
        firstNameTF.setPromptText("First Name");
        firstNameTF.setStyle("-fx-background-radius: 10;");
        VBox.setMargin(firstNameTF, new Insets(0.0, 0.0, 1.0, 0.0));
        firstNameTF.setFont(new Font(13.0));

        firstNameReq.setText("First name required");
        firstNameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        firstNameReq.setVisible(false);
        firstNameReq.setFont(new Font(11.0));
        VBox.setMargin(firstNameReq, new Insets(0.0, 0.0, 1.0, 0.0));

        lastNameTF.setLayoutX(10.0);
        lastNameTF.setLayoutY(10.0);
        lastNameTF.setMinHeight(USE_PREF_SIZE);
        lastNameTF.setPrefHeight(25.0);
        lastNameTF.setPromptText("Last Name");
        lastNameTF.setStyle("-fx-background-radius: 10;");
        VBox.setMargin(lastNameTF, new Insets(0.0, 0.0, 1.0, 0.0));
        lastNameTF.setFont(new Font(13.0));

        lastNameReq.setLayoutX(10.0);
        lastNameReq.setLayoutY(41.0);
        lastNameReq.setText("Last name required");
        lastNameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        lastNameReq.setVisible(false);
        lastNameReq.setFont(new Font(11.0));

        usernameTF.setLayoutX(10.0);
        usernameTF.setLayoutY(33.0);
        usernameTF.setMinHeight(USE_PREF_SIZE);
        usernameTF.setPrefHeight(25.0);
        usernameTF.setPrefWidth(136.0);
        usernameTF.setPromptText("Username");
        usernameTF.setStyle("-fx-background-radius: 10;");
        VBox.setMargin(usernameTF, new Insets(0.0, 0.0, 1.0, 0.0));
        usernameTF.setFont(new Font(13.0));

        usernameReq.setLayoutX(10.0);
        usernameReq.setLayoutY(95.0);
        usernameReq.setText("Username required");
        usernameReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        usernameReq.setVisible(false);
        usernameReq.setFont(new Font(11.0));

        passwordTF.setMinHeight(USE_PREF_SIZE);
        passwordTF.setPrefHeight(25.0);
        passwordTF.setPromptText("Password");
        passwordTF.setStyle("-fx-background-radius: 10;");
        VBox.setMargin(passwordTF, new Insets(0.0, 0.0, 1.0, 0.0));
        passwordTF.setFont(new Font(13.0));

        passwordReq.setLayoutX(10.0);
        passwordReq.setLayoutY(148.0);
        passwordReq.setText("Password required");
        passwordReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        passwordReq.setVisible(false);
        passwordReq.setFont(new Font(11.0));

        confirmPasswordTF.setLayoutX(10.0);
        confirmPasswordTF.setLayoutY(121.0);
        confirmPasswordTF.setMinHeight(USE_PREF_SIZE);
        confirmPasswordTF.setPrefHeight(25.0);
        confirmPasswordTF.setPromptText("Confirm Password");
        confirmPasswordTF.setStyle("-fx-background-radius: 10;");
        confirmPasswordTF.setFont(new Font(13.0));
        VBox.setMargin(confirmPasswordTF, new Insets(0.0, 0.0, 1.0, 0.0));

        confirmPasswordReq.setLayoutX(10.0);
        confirmPasswordReq.setLayoutY(201.0);
        confirmPasswordReq.setText("Confirm Password required");
        confirmPasswordReq.setTextFill(javafx.scene.paint.Color.valueOf("#ed0303"));
        confirmPasswordReq.setVisible(false);
        confirmPasswordReq.setFont(new Font(11.0));

        signUpButton.setMinHeight(USE_PREF_SIZE);
        signUpButton.setMnemonicParsing(false);
        signUpButton.setPrefHeight(20.0);
        signUpButton.setPrefWidth(52.0);
        signUpButton.setStyle("-fx-background-color: #e28409; -fx-background-radius: 10;");
        signUpButton.setText("SignUp");
        VBox.setMargin(signUpButton, new Insets(1.0, 0.0, 1.0, 55.0));
        signUpButton.setFont(new Font(13.0));
        signUpButton.setPadding(new Insets(1.0, 5.0, 0.0, 5.0));

        hBox.setPrefHeight(17.0);
        hBox.setPrefWidth(183.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Already have an account?");
        text.setFont(new Font(11.0));
        HBox.setMargin(text, new Insets(0.0, 0.0, 0.0, 5.0));

        loginText.setFill(javafx.scene.paint.Color.valueOf("#e28409"));
        loginText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        loginText.setStrokeWidth(0.0);
        loginText.setText("Login");
        loginText.setFont(new Font(11.0));
        HBox.setMargin(loginText, new Insets(0.0, 0.0, 0.0, 5.0));
        hBox.getChildren().addAll(text,loginText);
        vBox.getChildren().addAll(firstNameTF,firstNameReq,lastNameTF,lastNameReq,usernameTF,usernameReq,passwordTF,passwordReq,confirmPasswordTF,confirmPasswordReq,signUpButton,
           hBox
        );
        getChildren().add(vBox);
    }

    private void listenToAllEvents() {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean b = login();
            }

        });
    }

    boolean login() {
        setAllLabelsToDefault();
        boolean isAnyFieldEmpty = checkAllTextFields();
        boolean logged = true;
        if (isAnyFieldEmpty) {
            logged = false;
        } else {
            if (passwordTF.getText().length() < 6) {
                passwordReq.setText("Passwords should at least contain 6 characters");
                passwordReq.setVisible(true);
                logged = false;
            } else {
                if (!passwordTF.getText().equals(confirmPasswordTF.getText())) {
                    confirmPasswordReq.setText("Passwords do not match");
                    confirmPasswordReq.setVisible(true);
                    logged = false;

                } else //everything is alright only username will be checked from the db
                {
                    UserModel user = new UserModel(firstNameTF.getText(),
                            lastNameTF.getText(),
                            usernameTF.getText(),
                            passwordTF.getText());

                }

            }

        }

        return logged;
    }

    boolean checkAllTextFields() {  //return false if at least 1 textfield is empty
        boolean isEmpty = false;
        if (firstNameTF.getText().isEmpty()) {
            isEmpty = true;
            firstNameReq.setVisible(true);
        }
        if (lastNameTF.getText().isEmpty()) {
            isEmpty = true;
            lastNameReq.setVisible(true);
        }
        if (usernameTF.getText().isEmpty()) {
            isEmpty = true;
            usernameReq.setVisible(true);
        }
        if (passwordTF.getText().isEmpty()) {
            isEmpty = true;
            passwordReq.setVisible(true);
        }
        if (confirmPasswordTF.getText().isEmpty()) {
            isEmpty = true;
            confirmPasswordReq.setVisible(true);
        }
        return isEmpty;
    }

    void setAllLabelsToDefault() {
        confirmPasswordReq.setText("Confirm password required");
        passwordReq.setText("Passwords required");
        firstNameReq.setVisible(false);
        lastNameReq.setVisible(false);
        usernameReq.setVisible(false);
        passwordReq.setVisible(false);
        confirmPasswordReq.setVisible(false);

    }

}
