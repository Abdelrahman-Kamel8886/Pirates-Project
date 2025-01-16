package piratesproject.network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.*;
import piratesproject.utils.Consts;
import piratesproject.utils.JsonUtils;

public class NetworkAccessLayer {

    private static NetworkAccessLayer instance; // Singleton instance
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private Thread th;
    private NetworkResponseHandler responseHandler;

    // Private constructor to prevent direct instantiation
    private NetworkAccessLayer(NetworkResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        try {
            socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            receive();
        } catch (IOException ex) {
            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, "Connection failed", ex);
        }
    }

    // Public method to get the singleton instance
    public static NetworkAccessLayer getInstance(NetworkResponseHandler responseHandler) {
        if (instance == null) {
            instance = new NetworkAccessLayer(responseHandler);
        }
        return instance;
    }

    private void receive() {
        th = new Thread(this::listenFromServer);
        th.setDaemon(true); // Ensure the thread stops when the application exits
        th.start();
    }

    private void listenFromServer() {
        try {
            while (!socket.isClosed()) {
                String responseJson = in.readLine();
                if (responseJson != null) {
                    ResponseModel responseModel = JsonUtils.jsonToResponseModel(responseJson);
                    if (responseHandler != null) {
                        Platform.runLater(() -> responseHandler.onResponseReceived(responseModel));
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, "Error receiving data", ex);
        }
    }

    public void sendRegisteration(UserModel user) {
        String userJson = JsonUtils.userModelToJson(user);
        RequestModel myReq = new RequestModel(RequestTypesEnum.REGISTER, userJson);
        String reqJson = JsonUtils.requestModelToJson(myReq);
        out.println(reqJson);
    }

    public void sendLogin(LoginRequestModel user) {
        String userJson = JsonUtils.LoginRequstModelToJson(user);
        RequestModel myReq = new RequestModel(RequestTypesEnum.LOGIN, userJson);
        String reqJson = JsonUtils.requestModelToJson(myReq);
        out.println(reqJson);
    }

    public void getOnlineUsers() {
        RequestModel myReq = new RequestModel(RequestTypesEnum.USERSTABLE, "none");
        String reqJson = JsonUtils.requestModelToJson(myReq);
        out.println(reqJson);
    }

    public void sentInvitation(InvitationModel invitationModel) {
        System.out.println("ssssdsd");
        String invitationDataString = JsonUtils.invitationModelToJson(invitationModel);
        RequestModel requestModel = new RequestModel(RequestTypesEnum.INVITATION, invitationDataString);
        String reqJson = JsonUtils.requestModelToJson(requestModel);
        out.println(reqJson);
    }

    public void confirmInvitation(InvitationModel invitationModel) {
        String invitationDataString = JsonUtils.invitationModelToJson(invitationModel);
        RequestModel requestModel = new RequestModel(RequestTypesEnum.CONFIRM_INVITATION, invitationDataString);
        String reqJson = JsonUtils.requestModelToJson(requestModel);
        out.println(reqJson);
    }

    public void exitApplication() {

        try {
            RequestModel requestModel = new RequestModel(RequestTypesEnum.EXIT, "");
            String reqJson = JsonUtils.requestModelToJson(requestModel);
            out.println(reqJson);
            th.stop();
            out.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
        }
    }

    public void setResponseHandler(NetworkResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    public void closeConnection() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                th.stop();
            }
            if (th != null && th.isAlive()) {
                th.interrupt();
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, "Error closing connection", ex);
        }
    }
}
