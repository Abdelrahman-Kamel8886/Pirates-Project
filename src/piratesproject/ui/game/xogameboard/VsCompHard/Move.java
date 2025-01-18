/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.game.xogameboard.VsCompHard;

/**
 *
 * @author Taj
 */
public class Move {
    int postion ; 
    String Symbol ;

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }
    
    public Move(int postion, String Symbol) {
        this.postion = postion;
        this.Symbol = Symbol;
    }
}
