package piratesproject.forms.receivingInvitation;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.InvitationModel;
import piratesproject.models.ResponseModel;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.xogameboard.online.OnlineGame;
import piratesproject.ui.game.xogameboard.online.OnlineGameController;
import piratesproject.utils.JsonUtils;
import piratesproject.utils.SharedModel;

public class ReceivingInvitationFormController extends ReceivingInvitationFormBase implements NetworkResponseHandler {
private NetworkAccessLayer networkAccessLayer;
    private Stage myStage;
    public ReceivingInvitationFormController(Stage stage) {
        myStage = stage;
        networkAccessLayer = NetworkAccessLayer.getInstance(this);
        networkAccessLayer.setResponseHandler(this);
        initView();
    }

    private void initView(){
        nameText.setText(SharedModel.getChallenger());
        onClicks();
    }
    private void onClicks(){
        acceptButton.setOnAction((ActionEvent event) -> {
            InvitationModel invitationModel = new InvitationModel(
                    SharedModel.getChallenger(),
                    SharedModel.getUser().getUserName());
            networkAccessLayer.confirmInvitation(invitationModel);

        });

        declineButton.setOnAction((ActionEvent event) -> {
            InvitationFormHandler.closeForm();
        });
    }

    @Override
    public void onResponseReceived(ResponseModel response) {
        if(response.getType() == RequestTypesEnum.CREATE_ROOM){
            SharedModel.setGameRoom(JsonUtils.jsonToGameRoomModel(response.getData()));
             InvitationFormHandler.closeForm();
             goToGame();
             
        }
    }
    private void goToGame() {
        Parent game = new OnlineGame(myStage);
        Main.resetScene(game);
    }
}
