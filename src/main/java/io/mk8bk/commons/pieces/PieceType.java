package io.mk8bk.commons.pieces;

public enum PieceType {
    KING('K', "king"),
    QUEEN('q', "queen"),
    ROOK('r', "rook"),
    BISHOP('b', "bishop"),
    KNIGHT('k', "knight"),
    PAWN('p', "pawn");
    public final char code;
    public final String verboseName;
    PieceType(char code,String verboseName){
        this.code = code;
        this.verboseName = verboseName;
    }
}
