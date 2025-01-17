
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.models;

/**
 *
 * @author Admin
 */
public class GameModel {
    private String username;
    private MoveModel move;

    public GameModel(String username, MoveModel move) {
        this.username = username;
        this.move = move;
    }

    public GameModel() {
    }
    
      public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MoveModel getMove() {
        return move;
    }

    public void setMove(MoveModel move) {
        this.move = move;
    }



//public class GameModel {
//    private String id;
//    private Player player1;
//    private Player player2;
//
//    public GameModel() {
//    }
//
//    public GameModel(String id, Player player1, Player player2) {
//        this.id = id;
//        this.player1 = player1;
//        this.player2 = player2;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Player getPlayer1() {
//        return player1;
//    }
//
//    public void setPlayer1(Player player1) {
//        this.player1 = player1;
//    }
//
//    public Player getPlayer2() {
//        return player2;
//    }
//
//    public void setPlayer2(Player player2) {
//        this.player2 = player2;
//    }
//    
//    
//    

}
