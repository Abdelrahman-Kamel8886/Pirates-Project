package piratesproject.ui.game.xogameboard.VsCompHard;

import java.util.Scanner;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import piratesproject.ui.game.minmaxalgorithim.State;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.enums.VideoTypeEnum;
import piratesproject.forms.draw.DrawForm;
import piratesproject.ui.game.minmaxalgorithim.AdversarialSearchTicTacToe;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.home.HomePageController;


public class VsCompHard extends XOGameBoard {

    Thread minMaxthread;
    Stage stage;
    State Mystate;
    String globalBoard[] = {"", "", "", "", "", "", "", "", ""};
    AdversarialSearchTicTacToe AiTicTacToe;

    public VsCompHard(Stage stage) {
        super(stage);
        initGame();
        State state = new State(0, globalBoard);
        //make ai start playing. 
        int aiMove = AiTicTacToe.minMaxDecision(state);
        globalBoard[aiMove] = "X";
        drawBoard(globalBoard);
    }
       
    public void checkWin(State state) {
        
        int result = AiTicTacToe.utilityOf(state);
        if (result == 1) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> showVideo(VideoTypeEnum.LOSS)); // Show the video after the pause
            pause.play();
        changeButtonDiableEnable(true);
        System.out.println("AI wins!");
        } else if (result == -1) {
             PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> showVideo(VideoTypeEnum.WIN)); // Show the video after the pause
            pause.play(); 
            changeButtonDiableEnable(true);
            System.out.println("You win!");
        } else {
            // add draw video
            System.out.println("It's a draw!");
        }
    }

    public void clickEvent(int postion, Button button) {
        //check if ""
        if (globalBoard[postion] == "") {
            globalBoard[postion] = "O";
            State state = new State(postion, globalBoard);
            int aiMove = AiTicTacToe.minMaxDecision(state);
            if (aiMove != -1) {
                globalBoard[aiMove] = "X";
                button.setText("o");
                checkWin(state);
                drawBoard(globalBoard);
            }
        }
    }

    public void listenToAllEvents() {
        backIcon.addEventHandler(EventType.ROOT, new EventHandler() {
            @Override
            public void handle(Event event) {
                Main.resetScene(new HomePageController(stage));
            }
        });
        btnGrid_0_0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(0, btnGrid_0_0);
            }
        });
        btnGrid_0_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(1, btnGrid_0_1);

            }
        });
        btnGrid_0_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(2, btnGrid_0_2);

            }
        });
        btnGrid_1_0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(3, btnGrid_1_0);

            }
        });
        btnGrid_1_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(4, btnGrid_1_1);

            }
        });
        btnGrid_1_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(5, btnGrid_1_2);

            }
        });
        btnGrid_2_0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(6, btnGrid_2_0);

            }
        });
        btnGrid_2_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(7, btnGrid_2_1);

            }
        });
        btnGrid_2_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickEvent(8, btnGrid_2_2);

            }
        });

        retryIcon.addEventHandler(EventType.ROOT, new EventHandler() {
            @Override
            public void handle(Event event) {
                globalBoard = new String[]{"", "", "", "", "", "", "", "", ""};
                drawBoard(globalBoard);
                changeButtonDiableEnable(false);
            }
        });
    }

    private void initGame() {
        AiTicTacToe = new AdversarialSearchTicTacToe();
        listenToAllEvents();
    }

    public void drawBoard(String[] state) {

        btnGrid_0_0.setText(state[0]);
        btnGrid_0_1.setText(state[1]);
        btnGrid_0_2.setText(state[2]);
        btnGrid_1_0.setText(state[3]);
        btnGrid_1_1.setText(state[4]);
        btnGrid_1_2.setText(state[5]);
        btnGrid_2_0.setText(state[6]);
        btnGrid_2_1.setText(state[7]);
        btnGrid_2_2.setText(state[8]);
    }
    
        public void changeButtonDiableEnable(Boolean flag) {

        btnGrid_0_0.setDisable(flag);
        btnGrid_0_1.setDisable(flag);
        btnGrid_0_2.setDisable(flag);
        btnGrid_1_0.setDisable(flag);
        btnGrid_1_1.setDisable(flag);
        btnGrid_1_2.setDisable(flag);
        btnGrid_2_0.setDisable(flag);
        btnGrid_2_1.setDisable(flag);
        btnGrid_2_2.setDisable(flag);
    }
        
          private void showVideo(VideoTypeEnum videoType) {
        
        DrawForm drawBase = new DrawForm();
        switch (videoType) {
            case WIN:
                drawBase.display(stage, Pathes.WIN_VEDIO_PATH); // Use the correct path for the win video
                break;
            case LOSS:
                drawBase.display(stage, Pathes.LOSS_VEDIO_PATH); // Use the correct path for the loss video
                break;
            case DRAW:
                drawBase.display(stage, Pathes.DRAW_VEDIO_PATH); // Use the correct path for the draw video
                break;
        }
    }
}
