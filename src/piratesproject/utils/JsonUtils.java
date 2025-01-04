package piratesproject.utils;

import com.google.gson.Gson;
import piratesproject.models.RequestModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;

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
}
