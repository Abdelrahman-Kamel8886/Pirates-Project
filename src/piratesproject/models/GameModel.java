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
}
