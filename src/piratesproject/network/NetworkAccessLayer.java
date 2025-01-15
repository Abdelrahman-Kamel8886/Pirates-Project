package piratesproject.network;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
=======
import java.io.*;
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
import piratesproject.enums.RequestTypesEnum;
import piratesproject.models.GameModel;
//import piratesproject.models.GameModel;
import piratesproject.models.LoginRequestModel;
import piratesproject.models.LoginResponseModel;
import piratesproject.models.MoveModel;
import piratesproject.models.RequestModel;
import piratesproject.models.ResponseModel;
import piratesproject.models.UserModel;
=======
import javafx.application.Platform;
import piratesproject.enums.RequestTypesEnum;
import piratesproject.interfaces.NetworkResponseHandler;
import piratesproject.models.*;
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
import piratesproject.utils.Consts;
import piratesproject.utils.JsonUtils;

public class NetworkAccessLayer {

<<<<<<< HEAD
    private static final String SERVER_HOST = "10.191.210.111"; // Change to your server's address
    private static final int SERVER_PORT = 1422; // Change to your server's port
    static   Socket socket;
   static PrintWriter out;
    static BufferedReader in;
    public  static ResponseModel registerToServer(UserModel u) {
        ResponseModel responseModel = null;
        try  {
             socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
                 out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
=======
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
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
        }
    }

<<<<<<< HEAD
    public static   LoginResponseModel loginToServer(LoginRequestModel u) {
        LoginResponseModel responseModel = null;
        try  {
            socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
                 out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
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
=======
    // Public method to get the singleton instance
    public static NetworkAccessLayer getInstance(NetworkResponseHandler responseHandler) {
        if (instance == null) {
            instance = new NetworkAccessLayer(responseHandler);
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
        }
        return instance;
    }

<<<<<<< HEAD
    public static  ArrayList<UserModel> getOnlineUsers() {
        ArrayList<UserModel> list = null;
        try  {
            
                 out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            RequestModel myReq = new RequestModel(RequestTypesEnum.USERSTABLE, "");
            String reqJson = JsonUtils.requestModelToJson(myReq);
            out.println(reqJson); // Send JSON string to the server

            // Listen for a response from the server
            String responseJson = in.readLine();
            if (responseJson != null) {
                // Convert JSON string to ResponseModel
                list = JsonUtils.jsonToUsersArray(responseJson);
=======
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
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
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

    public void setResponseHandler(NetworkResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    public void closeConnection() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (th != null && th.isAlive()) {
                th.interrupt();
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, "Error closing connection", ex);
        }
<<<<<<< HEAD
        return list;

=======
>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
    }

    public static  void sendMove(GameModel gameMove) {
        try  {
//           socket = new Socket(Consts.SERVER_HOST, Consts.SERVER_PORT);
            // Create a UserModel object and convert it to JSON
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String gameMoveJson = JsonUtils.gameModelToJson(gameMove);
            RequestModel myReq = new RequestModel(RequestTypesEnum.GAMEMOVE, gameMoveJson);
            String reqJson = JsonUtils.requestModelToJson(myReq);
            out.println(reqJson); // Send JSON string to the server

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static  MoveModel getMove() {
        
        MoveModel gameMove = null;
        try  {
           
            // Create a UserModel object and convert it to JSON
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String gameMovejson;
            gameMovejson= in.readLine();
            System.out.println(gameMovejson);
            gameMove = JsonUtils.jsonToGameMove(gameMovejson);          
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return gameMove;
    }

}
