/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.forms.sendinvitatation;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piratesproject.Main;
import piratesproject.forms.lodinanimation.LodingAnimationController;
import piratesproject.forms.lodinanimation.LodingAnimationHandler;

/**
 * FXML Controller class
 *
 * @author jaila
 */
public class SendInvitationFormController extends SendInvitationForm {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public SendInvitationFormController(Stage stage) {
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("test");
                //Parent root = new LodingAnimationController();
                //SendInvitationFormHandler.resetScene(root);   
                SendInvitationToServer();
            }
        });
    }

    void SendInvitationToServer() {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("Test Test");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
