package piratesproject.cells;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import piratesproject.drawable.values.Pathes;
import piratesproject.enums.GameResultEnum;
import piratesproject.models.HistoryModel;
import piratesproject.models.RecordModel;

public class GameRecordCell extends ListCell<RecordModel> {

    private final HBox content;
    private final ImageView player1AvatarView;
    private final Text player1NameText;
    private final Text player1WinStateText;
    private final ImageView vsLogoImage;
    private final Text player2WinStateText;
    private final Text player2NameText;
    private final ImageView player2AvatarView;

    public GameRecordCell() {
        player1AvatarView = new ImageView();
        player1AvatarView.setFitWidth(40);
        player1AvatarView.setFitHeight(40);
        player1AvatarView.setPreserveRatio(true);

        player1NameText = new Text();
        player1WinStateText = new Text();

        vsLogoImage = new ImageView(new Image(getClass().getResource(Pathes.VS_LOGO_PATH).toExternalForm()));
        vsLogoImage.setFitWidth(20);
        vsLogoImage.setFitHeight(20);
        vsLogoImage.setPreserveRatio(true);

        player2WinStateText = new Text();
        player2WinStateText.setStyle("-fx-font-size: 12px; -fx-fill: #FF5722;");

        player2NameText = new Text();
        player2NameText.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

        player2AvatarView = new ImageView();
        player2AvatarView.setFitWidth(40);
        player2AvatarView.setFitHeight(40);
        player2AvatarView.setPreserveRatio(true);

        player1AvatarView.setImage(new Image(getClass().getResource(Pathes.GAMER_LOGO_PATH).toExternalForm()));
        player2AvatarView.setImage(new Image(getClass().getResource(Pathes.GAMER_LOGO_PATH).toExternalForm()));

        Region spacer1 = new Region();
        spacer1.setMinWidth(20);

        Region spacer2 = new Region();
        spacer2.setMinWidth(20);

        content = new HBox(10, player1AvatarView, player1NameText, player1WinStateText, spacer1, vsLogoImage, spacer2, player2WinStateText, player2NameText, player2AvatarView);
        content.setPadding(new Insets(10,5,40,5));
        Scale scale = new Scale(1.5, 1.5);
        content.setAlignment(Pos.TOP_LEFT);
        content.getTransforms().add(scale);
    }

    @Override
    protected void updateItem(RecordModel match, boolean empty) {
        super.updateItem(match, empty);
        if (empty || match == null) {
            setText(null);
            setGraphic(null);
        } else {
            String player1 = match.getPlayer1().getName() + " (" + match.getPlayer1().getSymbol() + ")";
            String player2 = match.getPlayer2().getName() + " (" + match.getPlayer2().getSymbol() + ")";
            String state1, state2;
            if (match.getWinner() == null) {
                state1 = GameResultEnum.D.name();
                state2 = GameResultEnum.D.name();
                player1WinStateText.setStyle("-fx-fill: gray; -fx-font-size: 12px; -fx-font-weight: bold;");
                player2WinStateText.setStyle("-fx-fill: gray; -fx-font-size: 12px; -fx-font-weight: bold;");
            } else if (match.getWinner().getName().equals(match.getPlayer1().getName())) {
                System.out.println("1111111111");
                state1 = GameResultEnum.W.name();
                state2 = GameResultEnum.L.name();
                player1WinStateText.setStyle("-fx-fill: green; -fx-font-size: 12px; -fx-font-weight: bold;");
                player2WinStateText.setStyle("-fx-fill: red; -fx-font-size: 12px; -fx-font-weight: bold;");
            } else {
                System.out.println("22222222222");
                state1 = GameResultEnum.L.name();
                state2 = GameResultEnum.W.name();
                player1WinStateText.setStyle("-fx-fill: red; -fx-font-size: 12px; -fx-font-weight: bold;");
                player2WinStateText.setStyle("-fx-fill: green; -fx-font-size: 12px; -fx-font-weight: bold;");
            }

            player1NameText.setText(player1);
            player1WinStateText.setText(state1);

            player2WinStateText.setText(state2);
            player2NameText.setText(player2);
            setGraphic(content);
        }
    }
}
