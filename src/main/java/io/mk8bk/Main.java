package io.mk8bk;

import io.mk8bk.gui.GameFrame;
import io.mk8bk.server.ChessWebServer;

public class Main {
    public static void main(String[] args) {
        // GameFrame gameFrame = new GameFrame(true);
        ChessWebServer chessWebServer = ChessWebServer.getInstance();
        chessWebServer.start();
    }
}