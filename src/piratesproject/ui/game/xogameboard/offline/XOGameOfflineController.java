package piratesproject.ui.game.xogameboard.offline;

import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import minmaxalgorithim.AdversarialSearchTicTacToe;
import minmaxalgorithim.State;
import piratesproject.ui.game.xogameboard.XOGameBoard;

public class XOGameOfflineController extends XOGameBoard {

    public void showWinState() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:///C:/Users/Taj/Desktop/youWin.mp4"));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

    }

    public XOGameOfflineController(Stage stage) {
        super(stage);

        btnGrid_0_0.setOnAction((ActionEvent event) -> {
            drawSuccesslines();
            getChildren().add(mediaView);
            showWinState();
        });
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                minMax();

            }
        });
        thread.start();

    }

    void minMax() {
        AdversarialSearchTicTacToe adsTicTacToe = new AdversarialSearchTicTacToe();

        String[] board = {"", "", "", "", "", "", "", "", ""};

        State state = new State(0, board);

        Scanner scanner = new Scanner(System.in);

        while (!adsTicTacToe.isTerminal(state)) {
            System.out.println(state);
            board[adsTicTacToe.minMaxDecision(state)] = "X";
            if (!adsTicTacToe.isTerminal(state)) {
                drawBoard(state);
                System.out.print(": ");
                int userInput = Integer.parseInt(scanner.nextLine());
                state.changeState(userInput, "O");
            }
        }

        drawBoard(state);
        System.out.println("Game is over");

    }

    public void drawBoard(State state) {
        for (int i = 0; i < 7; i += 3) {
            System.out.println(state.getStateIndex(i) + " "
                    + state.getStateIndex(i + 1) + " " + state.getStateIndex(i + 2));
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                btnGrid_0_0.setText(state.getStateIndex(0));
                btnGrid_0_1.setText(state.getStateIndex(1));
                btnGrid_0_2.setText(state.getStateIndex(2));
                btnGrid_1_0.setText(state.getStateIndex(3));
                btnGrid_1_1.setText(state.getStateIndex(4));
                btnGrid_1_2.setText(state.getStateIndex(5));
                btnGrid_2_0.setText(state.getStateIndex(6));
                btnGrid_2_1.setText(state.getStateIndex(7));
                btnGrid_2_2.setText(state.getStateIndex(8));
            }
        });

    }

}
