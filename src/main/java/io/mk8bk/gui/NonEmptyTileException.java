package io.mk8bk.gui;

public class NonEmptyTileException extends Exception {
    public NonEmptyTileException(){
        super("Can't add Piece to non Empty Tile.");
    }
    public NonEmptyTileException(TileCode tileCode){
        super("Can't add Piece to non Empty Tile %s.".formatted(tileCode.getTileCode()));
    }
}
