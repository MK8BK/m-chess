package io.mk8bk.controller;

import io.mk8bk.commons.ChessColor;

public class ChessPlayer {
    private final ChessColor color;
    private String username;
    public ChessPlayer(ChessColor chessColor) {
        color = chessColor;
    }

    public void setUsername(String name){
        if(null==username){
            username = name;
        }else{
            throw new RuntimeException("Username already set");
        }
    }
}
