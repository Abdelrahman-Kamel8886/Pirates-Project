package piratesproject.forms.sendinvitatation;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.forms.lodinanimation.LodingAnimationController;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.InvitationModel;
import piratesproject.models.ResponseModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.xogameboard.online.OnlineGame;
import piratesproject.ui.game.xogameboard.online.OnlineGameController;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class SendInvitationFormController extends SendInvitationForm implements NetworkResponseHandler {

    private NetworkAccessLayer networkAccessLayer;
    private Stage myStage;
    
    public SendInvitationFormController(Stage stage) {
        myStage = stage;
        networkAccessLayer = NetworkAccessLayer.getInstance();
        networkAccessLayer.setResponseHandler(this);

        initView();
    }

    private void initView() {
        nameText.setText(SharedModel.getSelectedUser().getUserName());
        scoreText.setText("" + SharedModel.getSelectedUser().getScore());
        onClicks();
    }

    private void onClicks() {
        acceptButton.setOnAction((ActionEvent event) -> {
            InvitationModel invitationModel = new InvitationModel(
                    SharedModel.getUser().getUserName(),
                    SharedModel.getSelectedUser().getUserName());
            networkAccessLayer.sentInvitation(invitationModel);

        });

        declineButton.setOnAction((ActionEvent event) -> {
            SendInvitationFormHandler.closeForm();
        });
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        if (response.getType() == RequestTypesEnum.START_SENDING) {
            Parent root = new LodingAnimationController();
            SendInvitationFormHandler.resetScene(root);
        }
        else if(response.getType() == RequestTypesEnum.CREATE_ROOM){
            SharedModel.setGameRoom(JsonUtils.jsonToGameRoomModel(response.getData()));
             SendInvitationFormHandler.closeForm();
             goToGame();
             
        }
    }
    private void goToGame() {
        Parent game = new OnlineGame(myStage);
        Main.resetScene(game);
    }
}
