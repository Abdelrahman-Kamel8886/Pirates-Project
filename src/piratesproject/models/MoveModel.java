package piratesproject.models;

public class MoveModel {
    private int row;
    private int col;
    private String symbol;

    public MoveModel() {
    }

    public MoveModel(int row, int col, String symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    
    
    
    
    
}
