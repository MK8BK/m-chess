package io.mk8bk.commons;

import java.awt.*;

public enum ChessColor {
    BLACK(Color.BLACK),
    WHITE(Color.WHITE);
    private final Color color;
    ChessColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public char getColorCode(){
        return (this==ChessColor.BLACK)?'b':'w';
    }

    public ChessColor getEnemyColor(){
        return (this==ChessColor.BLACK)?ChessColor.WHITE:ChessColor.BLACK;
    }
}
