
package piratesproject.ui.game.minmaxalgorithim;

import java.util.ArrayList;
import piratesproject.ui.game.minmaxalgorithim.State;

public class AdversarialSearchTicTacToe {

    // Predefined winning combinations
    public static final int[][] WIN_LINES = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
        {0, 4, 8}, {2, 4, 6}             // Diagonals
    };

    public int minMaxDecision(State state) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;

        for (State nextState : successorsOf(state)) {
            int score = minValue(nextState, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (score > bestScore) {
                bestScore = score;
                bestMove = nextState.getPosition();
            }
        }

        System.out.println("Best Move: " + bestMove);
        return bestMove;
    }

    public  int maxValue(State state, int alpha, int beta) {
        if (isTerminal(state)) {
            return utilityOf(state);
        }

        int v = Integer.MIN_VALUE;
        for (State nextState : successorsOf(state)) {
            v = Math.max(v, minValue(nextState, alpha, beta));
            if (v >= beta) {
                return v; // Beta cutoff
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(State state, int alpha, int beta) {
        if (isTerminal(state)) {
            return utilityOf(state);
        }

        int v = Integer.MAX_VALUE;
        for (State nextState : successorsOf(state)) {
            v = Math.min(v, maxValue(nextState, alpha, beta));
            if (v <= alpha) {
                return v; // Alpha cutoff
            }
            beta = Math.min(beta, v);
        }
        return v;
    }

      public boolean isTerminal(State state) {
        return utilityOf(state) != 0 || allSpotsTaken(state);
    }

    public int utilityOf(State state) {
        for (int[] line : WIN_LINES) {
            String a = state.getStateIndex(line[0]);
            String b = state.getStateIndex(line[1]);
            String c = state.getStateIndex(line[2]);
            if (a.equals(b) && b.equals(c)) {
                if (a.equals("X")) return 1;  // X wins
                if (a.equals("O")) return -1; // O wins
            }
        }
        return 0; // Draw or ongoing
    }
    public int[] getLine(State state) {
        for (int[] line : WIN_LINES) {
            String a = state.getStateIndex(line[0]);
            String b = state.getStateIndex(line[1]);
            String c = state.getStateIndex(line[2]);
            if (a.equals(b) && b.equals(c)) {
                if (a.equals("X")) return line;  // X wins
                if (a.equals("O")) return line; // O wins
            }
        }
        return null; // Draw or ongoing
    }

    private boolean allSpotsTaken(State state) {
        for (String spot : state.getState()) {
            if (!spot.equals("X") && !spot.equals("O")) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<State> successorsOf(State state) {
        ArrayList<State> possibleMoves = new ArrayList<>();
        String currentPlayer = determinePlayer(state);

        for (int i = 0; i < 9; i++) {
            if (!state.getStateIndex(i).equals("X") && !state.getStateIndex(i).equals("O")) {
                String[] newState = state.getState().clone();
                newState[i] = currentPlayer;
                possibleMoves.add(new State(i, newState));
            }
        }
        return possibleMoves;
    }

    private String determinePlayer(State state) {
        int xCount = 0, oCount = 0;
        for (String s : state.getState()) {
            if (s.equals("X")) xCount++;
            if (s.equals("O")) oCount++;
        }
        return xCount <= oCount ? "X" : "O";
    }
}


