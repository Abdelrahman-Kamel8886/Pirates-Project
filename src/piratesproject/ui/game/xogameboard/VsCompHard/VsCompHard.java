package piratesproject.ui.game.xogameboard.VsCompHard;

import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.stage.Stage;
import minmaxalgorithim.State;
import piratesproject.Main;
import piratesproject.ui.game.minmaxalgorithim.AdversarialSearchTicTacToe;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.home.HomePageController;

/**
 *
 * @author Admin
 */
public class VsCompHard extends XOGameBoard {
    
    Thread minMaxthread;
    Stage stage;
    
    public VsCompHard(Stage stage) {
        super(stage);
        initGame();
    }
    
    private void initGame() {
        
        backIcon.addEventHandler(EventType.ROOT, new EventHandler() {
            @Override
            public void handle(Event event) {
                Main.resetScene(new HomePageController(stage));
                minMaxthread.stop();
                
            }
        });
        
        retryIcon.addEventHandler(EventType.ROOT, new EventHandler() {
            @Override
            public void handle(Event event) {
                String[] board = {"", "", "", "", "", "", "", "", ""};
                State restet_state = new State(0, board);
                drawBoard(restet_state);
                minMaxthread.stop();
            }
        });
        
        minMaxthread = new Thread(new Runnable() {
            @Override
            public void run() {
                minMax();
            }
        });
        minMaxthread.start();
    }
    
    
    void minMax() {
        AdversarialSearchTicTacToe adsTicTacToe = new AdversarialSearchTicTacToe();
        
        String[] board = {"", "", "", "", "", "", "", "", ""};
        
        State state = new State(0, board);
        
        Scanner scanner = new Scanner(System.in);
        
        while (!adsTicTacToe.isTerminal(state)) {
            drawBoard(state);
            
            int aiMove = adsTicTacToe.minMaxDecision(state);
            state.changeState(aiMove, "X");
            System.out.println("AI chose position: " + aiMove);
            
            if (adsTicTacToe.isTerminal(state)) {
                break;
            }
            
            drawBoard(state);
            System.out.print("Your move (0-8): ");
            int userInput;
            while (true) {
                userInput = Integer.parseInt(scanner.nextLine());
                if (userInput >= 0 && userInput < 9 && state.getStateIndex(userInput).isEmpty()) {
                    break;
                }
                System.out.print("Invalid move! Try again (0-8): ");
            }
            state.changeState(userInput, "O");
        }
        
        drawBoard(state);
        System.out.println("Game is over");
        int result = adsTicTacToe.utilityOf(state);
        if (result == 1) {
            System.out.println("AI wins!");
        } else if (result == -1) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }
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

