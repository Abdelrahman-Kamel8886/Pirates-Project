package piratesproject.utils;

import com.google.gson.Gson;
import piratesproject.models.LoginRequestModel;
import piratesproject.models.LoginResponseModel;
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
}
