package piratesproject.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.models.RequestModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
import piratesproject.ui.home.FXMLController;
import piratesproject.utils.Consts;
import piratesproject.utils.JsonUtils;

public class NetworkAccessLayer {

    private static final String SERVER_HOST = "172.16.224.222"; // Change to your server's address
    private static final int SERVER_PORT = 1422; // Change to your server's port

    public static void registerToServer(UserModel u, Stage s) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Create a UserModel object and convert it to JSON
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
                ResponseModel responseModel = JsonUtils.jsonToResponseModel(responseJson);
                if (responseModel.getStatus() == Consts.CONNECTION_SUCCESS) {
                    Platform.runLater(() -> {
                        FXMLController signupPage = new FXMLController(s);
                        Scene signupScene = new Scene(signupPage, 1920, 1080);
                        s.setScene(signupScene);
                    });

                }
                System.out.println("Received response -> staues code :" + responseModel.getStatus() + " - Message : " + responseModel.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
