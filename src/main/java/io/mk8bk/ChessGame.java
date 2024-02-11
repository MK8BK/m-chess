package io.mk8bk;

import io.mk8bk.controller.ChessController;
import io.mk8bk.server.ChessAuthenticator;
import io.mk8bk.server.ChessWebServer;

public class ChessGame {


    public static void main(String[] args) {
        ChessController chessController = new ChessController();
        chessController.launch();
    }
}