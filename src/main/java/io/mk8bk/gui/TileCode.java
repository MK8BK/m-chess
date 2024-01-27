package io.mk8bk.gui;

public class TileCode {
    public final int columnIndex;
    public final int rowIndex;
    public final boolean whiteView;
    public final char column;
    public final int row;
    public final String tileCode;
    public TileCode(int rowIndex, int columnIndex, boolean whiteView){
        this.whiteView = whiteView;
        if(whiteView){
            this.row = rowIndex+1;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.column = (char)(-columnIndex+(int)'h');
            this.tileCode = String.valueOf(column)+row;
        }else{
            this.row = 8-rowIndex;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.column = (char)(columnIndex+(int)'a');
            this.tileCode = String.valueOf(column)+row;
        }
    }
    public String getTileCode(){
        return this.tileCode;
    }
}
