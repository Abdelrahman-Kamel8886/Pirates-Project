/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.ui.game.xogameboard.VsCompHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HardRecord {
    

    ArrayList<Move> moveRecord ; 
    int currentPostion = 0  ; 
    
    public HardRecord() {
        moveRecord = new ArrayList<>();
    }
    
    
    void add(int postion , String c ){
        moveRecord.add(new Move(postion , c ));
    }
    
   public void print(){
       for(Move m : moveRecord){
           System.out.println("____________________");
           System.out.println(m.postion);
           System.out.println(m.Symbol);
           System.out.println("____________________");
       }
   } 
   
   public Move next(){
        
       if (currentPostion < moveRecord.size()){
           Move move =  moveRecord.get(currentPostion);
           currentPostion+=1;
           return move; 
           
       }
       else return null;
   }
   
      public void clear(){
            moveRecord.clear();
            }
   
   
   
//    Map<Integer, String> recordMap = new HashMap<Integer, String>();
//    
//
//    public HardRecord() {
//    }
//    
//    void add(int postion , String c ){
//        recordMap.put(postion, c) ; 
//    }
//    
//    public String[] mapTOSteingArray(){
//        String[] Board = new String[9] ; 
//        for(Map.Entry<Integer ,String> i : recordMap.entrySet()){
//            Board[i.getKey()] = i.getValue();
//        }
//        return Board ; 
//    }
}
