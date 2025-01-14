package piratesproject.cells;

import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import piratesproject.drawable.values.Pathes;
import piratesproject.models.AvalabilePlayer;
import piratesproject.models.UserModel;

public class ActivePlayerCell extends ListCell<UserModel> {
    
    private final HBox content;
    private final ImageView avatarView;
    private final VBox textContainer;
    private final Text userNameText;
    private final Text scoreText;

    public ActivePlayerCell() {
        avatarView = new ImageView();
        avatarView.setFitWidth(50);
        avatarView.setFitHeight(50);
        avatarView.setPreserveRatio(true);
        avatarView.setImage(new Image(getClass().getResource(Pathes.GAMER_LOGO_PATH).toExternalForm()));

        userNameText = new Text();
        userNameText.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        scoreText = new Text();
        scoreText.setStyle("-fx-font-size: 12px; -fx-text-fill: gray;");

        textContainer = new VBox(userNameText, scoreText);
        textContainer.setSpacing(5);

        content = new HBox(10, avatarView, textContainer);
        content.setPadding(new Insets(5));
    }

    @Override
    protected void updateItem(UserModel user, boolean empty) {
        super.updateItem(user, empty);
        if (empty || user == null) {
            setText(null);
            setGraphic(null);
        } else {
            userNameText.setText(user.getUserName());
            scoreText.setText("Score: " + user.getScore());
            setGraphic(content);
        }
    }
    
}
