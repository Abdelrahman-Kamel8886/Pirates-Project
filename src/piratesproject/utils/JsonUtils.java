package piratesproject.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import piratesproject.models.GameModel;
import piratesproject.models.GameRoomModel;
import piratesproject.models.InvitationModel;
import piratesproject.models.LoginRequestModel;
import piratesproject.models.LoginResponseModel;
import piratesproject.models.MoveModel;
import piratesproject.models.RecordModel;
import piratesproject.models.RequestModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.SwitchButton;
import piratesproject.models.UserModel;
import piratesproject.ui.game.xogameboard.VsCompHard.HardRecord;

public class JsonUtils {
    
    private static final Gson gson = new Gson();

    // Convert UserModel to JSON string
    public static String userModelToJson(UserModel userModel) {
        return gson.toJson(userModel);
    }

    // Convert JSON string to UserModel
    public static UserModel jsonToUserModel(String json) {
        return gson.fromJson(json, UserModel.class);
    }

    // Convert ResponseModel to JSON string
    public static String responseModelToJson(ResponseModel responseModel) {
        return gson.toJson(responseModel);
    }

    // Convert JSON string to ResponseModel
    public static ResponseModel jsonToResponseModel(String json) {
        return gson.fromJson(json, ResponseModel.class);
    }
    public static String requestModelToJson(RequestModel requestModel) {
        return gson.toJson(requestModel);
    }

    // Convert JSON string to ResponseModel
    public static ResponseModel jsonToRequestModel(String requestModel) {
        return gson.fromJson(requestModel, ResponseModel.class);
    }
    
      public static String LoginRequstModelToJson(LoginRequestModel loginRequestModel) {
        return gson.toJson(loginRequestModel);
    }

    // Convert JSON string to ResponseModel
    public static LoginRequestModel jsonToLoginRequestModel(String loginRequestModel) {
        return gson.fromJson(loginRequestModel, LoginRequestModel.class);
    }
              // Convert ResponseModel to JSON string
    public static String loginResponseModelToJson(LoginResponseModel responseModel) {
        return gson.toJson(responseModel);
    }

    // Convert JSON string to ResponseModel
    public static LoginResponseModel jsonToLoginResponseModel(String json) {
        return gson.fromJson(json, LoginResponseModel.class);
    }
    public static String movesArrayToJson(ArrayList<MoveModel> moves ) {
        return gson.toJson(moves);
    }
    public static ArrayList<MoveModel> jsonToMovesArray(String json) {
        ArrayList<MoveModel> moveModels = gson.fromJson(json, new TypeToken<ArrayList<MoveModel>>(){}.getType());
        return moveModels;
    }
     public static String usersArrayToJson(ArrayList<UserModel> users ) {
        return gson.toJson(users);
    }
    public static ArrayList<UserModel> jsonToUsersArray(String json) {
        ArrayList<UserModel> users = gson.fromJson(json, new TypeToken<ArrayList<UserModel>>(){}.getType());
        return users;
    }
    
    
    public static String recordModelToJson(RecordModel recordModel) {
        return gson.toJson(recordModel);
    }

    public static RecordModel jsonToRecordModel(String json) {
        return gson.fromJson(json, RecordModel.class);
    }
    public static String gameModelToJson(GameModel gameModel) {
        return gson.toJson(gameModel);
    }

    // Convert JSON string to UserModel
    public static GameModel jsonToGameModel(String json) {
        return gson.fromJson(json, GameModel.class);
    }
    public static String gameMoveToJson(MoveModel gameMove) {
        return gson.toJson(gameMove);
    }

    public static MoveModel jsonToGameMove(String json) {
        return gson.fromJson(json, MoveModel.class);
    }
    public static String invitationModelToJson(InvitationModel invitationModel){
        return gson.toJson(invitationModel); 
    }
    
    public static InvitationModel jsonToInvitationModel (String invitationJson){
        return gson.fromJson(invitationJson, InvitationModel.class);
    }
    public static String gameRoomModelToJson(GameRoomModel model){
        return gson.toJson(model); 
    }
    
    public static GameRoomModel jsonToGameRoomModel(String game){
        return gson.fromJson(game, GameRoomModel.class);
    }

    public static String hardRecordTojson(HardRecord hardRecord) {
       return gson.toJson(hardRecord);
    }

}
