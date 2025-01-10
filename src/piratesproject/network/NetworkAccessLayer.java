package piratesproject.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.models.LoginRequestModel;
import piratesproject.models.LoginResponseModel;
import piratesproject.models.RequestModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.utils.Consts;
import piratesproject.utils.JsonUtils;

public class NetworkAccessLayer {

    private static final String SERVER_HOST = "172.16.222.147"; // Change to your server's address
    private static final int SERVER_PORT = 1422; // Change to your server's port


    public static ResponseModel registerToServer(UserModel u) {
        ResponseModel responseModel = null;
        try (Socket socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            UserModel user = u;

            String userJson = JsonUtils.userModelToJson(user);
            RequestModel myReq = new RequestModel(RequestTypesEnum.REGISTER, userJson);
            String reqJson = JsonUtils.requestModelToJson(myReq);
            out.println(reqJson); // Send JSON string to the server
            System.out.println("UserModel sent to server as JSON: " + userJson);

            // Listen for a response from the server
            String responseJson = in.readLine();
            if (responseJson != null) {
                // Convert JSON string to ResponseModel
                responseModel = JsonUtils.jsonToResponseModel(responseJson);
                System.out.println("Received response -> staues code :" + responseModel.getStatus() + " - Message : " + responseModel.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return responseModel;
    }

    public static LoginResponseModel loginToServer(LoginRequestModel u) {
        LoginResponseModel responseModel = null;
        try (Socket socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Create a UserModel object and convert it to JSON
            LoginRequestModel user = u;

            String userJson = JsonUtils.LoginRequstModelToJson(user);
            RequestModel myReq = new RequestModel(RequestTypesEnum.LOGIN, userJson);
            String reqJson = JsonUtils.requestModelToJson(myReq);
            out.println(reqJson); // Send JSON string to the server
            System.out.println("UserModel sent to server as JSON: " + userJson);

            // Listen for a response from the server
            String responseJson = in.readLine();
            if (responseJson != null) {
                // Convert JSON string to ResponseModel
                responseModel = JsonUtils.jsonToLoginResponseModel(responseJson);
                System.out.println("Received response -> staues code :" + responseModel.getStatus() + " - Message : " + responseModel.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return responseModel;
    }
}
