package io.mk8bk.gui;

public class TileCode {
    private final int columnIndex;
    private final int rowIndex;
    private final boolean whiteView;
    private final char column;
    private final int row;
    public TileCode(int rowIndex, int columnIndex, boolean whiteView){
        // TODO compute using whiteView
        this.row = rowIndex+1;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.whiteView = whiteView;
        this.column = (char)(columnIndex+(int)'a');
    }
    public String getTileCode(){
        return String.valueOf(column)+row;
    }
}
