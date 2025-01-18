package piratesproject.ui.game.xogameboard.VsCompHard;

import com.google.gson.Gson;
import java.util.Arrays;

import java.util.Scanner;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import piratesproject.ui.game.minmaxalgorithim.State;
import piratesproject.Main;
import piratesproject.drawable.values.Pathes;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.enums.VideoTypeEnum;
import piratesproject.forms.draw.DrawForm;
import piratesproject.network.NetworkAccessLayer;
import piratesproject.ui.game.minmaxalgorithim.AdversarialSearchTicTacToe;
import piratesproject.ui.game.xogameboard.XOGameBoard;
import piratesproject.ui.home.HomePageController;
import piratesproject.utils.SharedModel;

public class VsCompHard extends XOGameBoard {

    Thread minMaxthread;
    Stage stage;
    State Mystate;
    HardRecord hardrecord;
    String globalBoard[] = {"", "", "", "", "", "", "", "", ""};
    String recordBoard[] = {"", "", "", "", "", "", "", "", ""};
    AdversarialSearchTicTacToe AiTicTacToe;
    private NetworkAccessLayer networkAccessLayer;

    public VsCompHard(Stage stage) {
        super(stage);
        initGame();
        State state = new State(0, globalBoard);
        networkAccessLayer = NetworkAccessLayer.getInstance();
        if (SharedModel.getUser() != null) {
            networkAccessLayer.sentAvilableState(1);
        }
        listenToAllEvents();
    }

    public void checkWin(State state) {

        int result = AiTicTacToe.utilityOf(state);
        if (result == 1) {
            int[] resultLine = AiTicTacToe.getLine(state);
            drawWinLine(getlineNumber(resultLine));
            changeButtonDiableEnable(true);
            System.out.println("AI wins!");

            PauseTransition pause = new PauseTransition(Duration.seconds(.2));
            pause.setOnFinished(event -> showVideo(VideoTypeEnum.LOSS)); // Show the video after the pause
            pause.play();
            changeButtonDiableEnable(true);
            System.out.println("AI wins!");

        } else if (result == -1) {
            int[] resultLine = AiTicTacToe.getLine(state);
            drawSuccesslines();
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
            hardrecord.add(postion, "O");
            State state = new State(postion, globalBoard);
            int aiMove = AiTicTacToe.minMaxDecision(state);
            if (aiMove != -1) {
                globalBoard[aiMove] = "X";
                button.setText("o");
                hardrecord.add(aiMove, "X");
                checkWin(state);
                drawBoard(globalBoard);
            }
        }
    }

    public void playRecord() {
        Move move = hardrecord.next();
        if (move != null) {
            recordBoard[move.postion] = move.Symbol;
            drawBoard(recordBoard);
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

        retryIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                record.print();
//                String data = JsonUtils.hardRecordTojson(record);
//                System.out.println(data);
                hardrecord.clear();
                hardrecord.currentPostion = 0;
                initGame();
                changeButtonDiableEnable(false);
            }

        });

        recordButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playRecord();
            }

        });
    }

    private void initGame() {
        drawSuccesslines();
        AiTicTacToe = new AdversarialSearchTicTacToe();
        globalBoard = new String[]{"", "", "", "", "", "", "", "", ""};
        recordBoard = new String[]{"", "", "", "", "", "", "", "", ""};
        drawBoard(globalBoard);
        State state = new State(0, globalBoard);
        hardrecord = new HardRecord();
        int aiMove = AiTicTacToe.minMaxDecision(state);
        globalBoard[aiMove] = "X";
        hardrecord.add(aiMove, "X");
        drawBoard(globalBoard);
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

        DrawForm drawBase = new DrawForm(LevelTypesEnum.Hard);
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

    public int getlineNumber(int[] line) { 
        
        //         Rows
        if (Arrays.equals(line, new int[]{0, 1, 2})) {
            return 0 ; 
        }
        else if (Arrays.equals(line, new int[]{3, 4, 5})) {
            return 3 ; 
        }
        else if (Arrays.equals(line, new int[]{6, 7, 8})) {
            return 4 ; 
        }
        else if (Arrays.equals(line, new int[]{0, 3, 6})) {
            return 5 ; 
        }
        else if (Arrays.equals(line, new int[]{1, 4, 7})) {
            return 6 ; 
        }
        else if (Arrays.equals(line, new int[]{2, 5, 8})) {
            return 7 ; 
        }
        else if (Arrays.equals(line, new int[]{2, 4, 6})) {
            return 8 ; 
        }
        else if (Arrays.equals(line, new int[]{0, 4, 8})) {
            return 2 ; 
        }
       return 0 ;
    }

    private void drawWinLine(int winCondition) {
        
        switch (winCondition) {
            case 0:
                line1.setVisible(true);
                break;
            case 1:
                line3.setVisible(true);
                break;
            case 2:
                line4.setVisible(true);
                break;
            case 5:
                line5.setVisible(true);
                break;
            case 4:
                line6.setVisible(true);
                break;
            case 3:
                line7.setVisible(true);
                break;
            case 6:
                line2.setVisible(true);
                break;
            case 7:
                line8.setVisible(true);
                break;
        }
    }
}
