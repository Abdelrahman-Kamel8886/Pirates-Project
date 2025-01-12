package minmaxalgorithim;

import java.util.ArrayList;

public class AdversarialSearchTicTacToe {

    public int minMaxDecision(State state){
        ArrayList<State> possibleMoves = successorsOf(state);
        ArrayList<Integer> movesList = new ArrayList<>();


        for (State states: possibleMoves) {
            movesList.add(minValue(states));
        }

        int max = movesList.get(0);
        int bestIndex = 0;

        for (int i = 1; i < movesList.size(); i++) {

            if( movesList.get(i) > max){
                max = movesList.get(i);
                bestIndex = i;
            }
        }

        System.out.println(possibleMoves);
        System.out.println(movesList);

        int action = possibleMoves.get(bestIndex).getPosition();
        System.out.println("Action: " + action);
        return action;
    }

    //Picks best option for the X-player
    private int maxValue(State state){
        if (isTerminal(state)){
            return utilityOf(state);
        }
        int v = (int) -Double.POSITIVE_INFINITY;

        for (State possibleMove: successorsOf(state)) {
            v = Math.max(v, minValue(possibleMove));
        }
        System.out.println(v);
        return v;
    }

    //Picks best option for the O-player
    private int minValue(State state){
        if (isTerminal(state)){
            return utilityOf(state);
        }

        int v = (int) Double.POSITIVE_INFINITY;
        for (State possibleMove: successorsOf(state)) {

            v = Math.min(v, maxValue(possibleMove));
        }
        System.out.println(v);
        return v;
    }

    //Returns true if the game is over
    public boolean isTerminal(State state) {
        int takenSpots = 0;
        for (int a = 0; a < 9; a++) {
            if(state.getStateIndex(a).equals("X") || state.getStateIndex(a).equals("O") ){
                takenSpots++;
            }

            String line = checkState(state, a);

            //Check for Winners
            if (line.equals("XXX")) {
                return true;
            } else if (line.equals("OOO")) {
                return true;
            }

            if(takenSpots == 9){
                return true;
            }
        }
        return false;
    }

    //Returns +1 if X is winner
    //Return -1 if O is winner
    //Returns 0 if no one won
    private int utilityOf(State state){
        for (int a = 0; a < 8; a++) {
            String line = checkState(state, a);
            //Check for Winners
            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return -1;
            }
        }
        return 0;
    }

    //Find any win state if it exists
private String checkState(State state, int a) {
    String result;
    switch (a) {
        case 0:
            result = state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
            break;
        case 1:
            result = state.getStateIndex(3) + state.getStateIndex(4) + state.getStateIndex(5);
            break;
        case 2:
            result = state.getStateIndex(6) + state.getStateIndex(7) + state.getStateIndex(8);
            break;
        case 3:
            result = state.getStateIndex(0) + state.getStateIndex(3) + state.getStateIndex(6);
            break;
        case 4:
            result = state.getStateIndex(1) + state.getStateIndex(4) + state.getStateIndex(7);
            break;
        case 5:
            result = state.getStateIndex(2) + state.getStateIndex(5) + state.getStateIndex(8);
            break;
        case 6:
            result = state.getStateIndex(0) + state.getStateIndex(4) + state.getStateIndex(8);
            break;
        case 7:
            result = state.getStateIndex(2) + state.getStateIndex(4) + state.getStateIndex(6);
            break;
        default:
            result = "";
            break;
    }
    return result;
}

    //Returns all possible states form a given state
    private ArrayList<State> successorsOf(State state){
        ArrayList<State> possibleMoves = new ArrayList<>();
        int xMoves = 0;
        int yMoves = 0;
        String player;

        //Calculate player turn
        for (String s: state.getState()) {
            if (s.equals("X")) {
                xMoves++;
            }else if(s.equals("O")){
                yMoves++;
            }
        }

        if(xMoves <= yMoves){
            player = "X";
        } else {
            player = "O";
        }

        //Create all possible states
        for (int i = 0; i < 9; i++) {
            String[] newState = state.getState().clone();

            if(newState[i] != "X" && newState[i] != "O"){
                newState[i] = player;
                possibleMoves.add(new State(i, newState));
            }
        }
        return possibleMoves;
    }
}