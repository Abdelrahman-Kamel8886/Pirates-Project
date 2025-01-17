package piratesproject.forms.Settings;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import piratesproject.drawable.values.Pathes;
import piratesproject.drawable.values.Strings;

public abstract class ProfileBase extends VBox {

    protected final VBox personalDetailsLayout;
    protected final ImageView avatar;
    protected final Text fullName;
    protected final Text userName;
    protected final HBox gamesDetailsLayout;
    protected final Label scoreText;
    protected final Label gamesPlayedText;
    protected final Label logout;
    protected final VBox editPasswordLayout;
    protected final VBox titleLayout;
    protected final Line line;
    protected final Label label;
    protected final HBox hBox;
    protected final Label label0;
    protected final PasswordField oldPassword;
    protected final HBox hBox0;
    protected final Label label1;
    protected final PasswordField newPassword;
    protected final HBox hBox1;
    protected final Label label2;
    protected final PasswordField confirmPassword;
    protected final HBox hBox2;
    protected final Button confirmBtn;
    
    protected final Label oldErrorLabel;
    protected final Label NewErrorLabel;
    protected final Label confirmErrorLabel;
    
    protected final Label doneLabel;

    public ProfileBase() {
        
        oldErrorLabel = new Label(Strings.REQUIERD_FIELD_TEXT);
        NewErrorLabel = new Label(Strings.REQUIERD_FIELD_TEXT);
        confirmErrorLabel = new Label(Strings.REQUIERD_FIELD_TEXT);
        doneLabel = new Label();
        
        personalDetailsLayout = new VBox();
        avatar = new ImageView();
        fullName = new Text();
        userName = new Text();
        gamesDetailsLayout = new HBox();
        scoreText = new Label();
        gamesPlayedText = new Label();
        logout = new Label("Logout");
        editPasswordLayout = new VBox();
        titleLayout = new VBox();
        line = new Line();
        label = new Label();
        hBox = new HBox();
        label0 = new Label();
        oldPassword = new PasswordField();
        hBox0 = new HBox();
        label1 = new Label();
        newPassword = new PasswordField();
        hBox1 = new HBox();
        label2 = new Label();
        confirmPassword = new PasswordField();
        
        hBox2 = new HBox();
        confirmBtn = new Button("Change Password");

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(624.0);
        setPrefWidth(642.0);
        getStylesheets().add(Pathes.SETTINGS_STYLE_PATH);

        personalDetailsLayout.setPrefHeight(200.0);
        personalDetailsLayout.setPrefWidth(100.0);
        
        
        avatar.setFitHeight(100.0);
        avatar.setFitWidth(100.0);
        avatar.setPickOnBounds(true);
        avatar.setPreserveRatio(true);
        avatar.setImage(new Image(getClass().getResource(Pathes.AVATAR_LOGO_PATH).toExternalForm()));

        fullName.setFill(javafx.scene.paint.Color.WHITE);
        fullName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        fullName.setStrokeWidth(0.0);
        fullName.setText("UserFullName");

        userName.setFill(javafx.scene.paint.Color.WHITE);
        userName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userName.setStrokeWidth(0.0);
        userName.setText("@username");

        gamesDetailsLayout.setPrefHeight(100.0);
        gamesDetailsLayout.setPrefWidth(200.0);

        scoreText.setText("Score  : 24");

        gamesPlayedText.setText("GamesPlayed : 24");

        editPasswordLayout.setPrefHeight(200.0);
        editPasswordLayout.setPrefWidth(100.0);

        titleLayout.setPrefHeight(200.0);
        titleLayout.setPrefWidth(100.0);

        line.setEndX(497.5);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.WHITE);
        line.setStrokeWidth(3.0);

        label.setText("Update Your Password Security");

        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.getStyleClass().add("entry");

        label0.setText("Old Password");

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);
        hBox0.getStyleClass().add("entry");

        label1.setText("New Password");

        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);
        hBox1.getStyleClass().add("entry");
        
        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(200.0);
        hBox2.getStyleClass().add("entry");

        label2.setText("Confirm Password");
        
        personalDetailsLayout.setId("personalDetailsLayout");
        gamesDetailsLayout.setId("gamesDetailsLayout");
        fullName.setId("fullName");
        userName.setId("userName");
        scoreText.setId("cardText");
        gamesPlayedText.setId("cardText");
        logout.setId("logout");
        titleLayout.setId("titleLayout");
        editPasswordLayout.setId("editPasswordLayout");
        hBox.setId("entry");
        hBox0.setId("entry");
        hBox1.setId("entry");
        hBox2.setId("entry");
        confirmBtn.setId("confirmBtn");
        
        oldErrorLabel.setStyle("-fx-text-fill: red");
        NewErrorLabel.setStyle("-fx-text-fill: red");
        confirmErrorLabel.setStyle("-fx-text-fill: red");
        
        
        oldErrorLabel.setVisible(false);
        NewErrorLabel.setVisible(false);
        confirmErrorLabel.setVisible(false);
        doneLabel.setVisible(false);
        
        
        personalDetailsLayout.getChildren().add(avatar);
        personalDetailsLayout.getChildren().add(fullName);
        personalDetailsLayout.getChildren().add(userName);
        gamesDetailsLayout.getChildren().add(scoreText);
        gamesDetailsLayout.getChildren().add(gamesPlayedText);
        gamesDetailsLayout.getChildren().add(logout);
        personalDetailsLayout.getChildren().add(gamesDetailsLayout);
        titleLayout.getChildren().add(line);
        titleLayout.getChildren().add(label);
        editPasswordLayout.getChildren().add(titleLayout);
        hBox.getChildren().addAll(label0,oldPassword,oldErrorLabel);        
        hBox0.getChildren().addAll(label1,newPassword,NewErrorLabel);
        hBox1.getChildren().addAll(label2,confirmPassword,confirmErrorLabel);
        hBox2.getChildren().addAll(confirmBtn,doneLabel);
        editPasswordLayout.getChildren().addAll(hBox,hBox0,hBox1,hBox2);
        getChildren().addAll(personalDetailsLayout,editPasswordLayout);
    }
}
