
package piratesproject.models;

public class HistoryModel {
     private Player player1;
    private Player player2;
    private Player winner;
    private String gameSequance;
    
    public HistoryModel(){
        this.gameSequance = "";
    }

    public HistoryModel(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameSequance = "";
    }

    public HistoryModel(Player player1, Player player2, Player winner, String gameSequance) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.gameSequance = gameSequance;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getGameSequance() {
        return gameSequance;
    }

    public void setGameSequance(String gameSequance) {
        this.gameSequance = gameSequance;
    }
    
     @Override
    public String toString() {
        return "RecordModel{" +
                "player1=" + (player1 != null ? player1.toString() : "null") +
                ", player2=" + (player2 != null ? player2.toString() : "null") +
                ", winner=" + (winner != null ? winner.toString() : "null") +
                ", gameSequance='" + gameSequance + '\'' +
                '}';
    }
}
