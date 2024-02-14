package io.mk8bk.controller;

import io.mk8bk.commons.ChessColor;

public class ChessPlayer {
    private ChessColor color;
    private String username;

    public void setUsername(String name){
        if(null==username){
            username = name;
        }else{
            throw new RuntimeException("Username already set");
        }
    }

    public void setColor(ChessColor color){
        if(null==this.color){
            this.color = color;
        }else{
            throw new RuntimeException("Username already set");
        }
    }

    public String getUserName() {
        return username;
    }
    public ChessColor getColor(){
        return color;
    }
}
