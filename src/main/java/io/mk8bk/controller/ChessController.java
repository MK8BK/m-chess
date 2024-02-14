package io.mk8bk.controller;

import io.mk8bk.commons.ChessColor;
import io.mk8bk.commons.pojos.BoardState;
import io.mk8bk.engine.ChessEngine;
import io.mk8bk.server.ChessWebServer;

import java.util.Objects;

public class ChessController {
    private final ChessEngine chessEngine;
    private final String[] userNames = new String[2];
    private final ChessWebServer chessWebServer;
    private final ChessPlayer player1;
    private final ChessPlayer player2;

    public ChessController() {
        chessWebServer = ChessWebServer.getInstance();
        chessWebServer.registerController(this);
        chessEngine = ChessEngine.getInstance();
        player2 = new ChessPlayer();
        player1 = new ChessPlayer();
    }

    public void launch() {
        chessWebServer.start();
    }


    public void setUserColor(String username, ChessColor chessColor) {
        ChessPlayer player;
        if(Objects.equals(player1.getUserName(), username))
            player = player1;
        else if(Objects.equals(player2.getUserName(), username))
            player = player2;
        else throw new RuntimeException("Unregistered user got past authentication.");
        player.setColor(chessColor);


    }

    public boolean playerHasColor(String username) {
        ChessPlayer player;
        if(Objects.equals(player1.getUserName(), username))
            player = player1;
        else if(Objects.equals(player2.getUserName(), username))
            player = player2;
        else throw new RuntimeException("Unregistered user got past authentication.");
        return !Objects.isNull(player.getColor());
    }

    public boolean canChooseColor(String username) {
        ChessPlayer player, otherPlayer;
        if(Objects.equals(player1.getUserName(), username)){
            player = player1;
            otherPlayer = player2;
        }else if(Objects.equals(player2.getUserName(), username)){
            player = player2;
            otherPlayer = player1;
        }else{
            throw new RuntimeException("Unregistered user got past authentication.");
        }
        return Objects.isNull(player.getColor()) && Objects.isNull(otherPlayer.getColor());
    }

    public BoardState getBoardState() {
        return null;
    }
}
