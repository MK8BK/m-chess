package io.mk8bk.commons;

public enum PieceType {
    KING("K"),
    QUEEN("q"),
    ROOK("r"),
    BISHOP("b"),
    KNIGHT("k");
    final String code;
    PieceType(String s){
        code = s;
    }
}
