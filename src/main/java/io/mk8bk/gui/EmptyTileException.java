package io.mk8bk.gui;

public class EmptyTileException extends Exception {
    public EmptyTileException(){
        super("Can't pop Piece from non Empty Tile.");
    }
    public EmptyTileException(TileCode tileCode){
        super("Can't pop Piece from non Empty Tile %s.".formatted(tileCode.getTileCode()));
    }
}
