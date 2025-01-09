/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.win;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Taj
 */
public class WinScreenController extends WinScreenBase implements Initializable {

    public WinScreenController(){
    super();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:///C:/Users/Taj/Desktop/youWin.mp4"));
       mediaPlayer.setAutoPlay(true);
      mediaView.setMediaPlayer(mediaPlayer);
               }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
