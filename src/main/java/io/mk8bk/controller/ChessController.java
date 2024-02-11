package io.mk8bk.controller;

import io.mk8bk.commons.ChessColor;
import io.mk8bk.engine.ChessEngine;
import io.mk8bk.server.ChessWebServer;

public class ChessController {
    private final ChessEngine chessEngine;
    private final ChessWebServer chessWebServer;
    private final ChessPlayer whitePlayer;
    private final ChessPlayer blackPlayer;

    public ChessController() {
        chessWebServer = ChessWebServer.getInstance();
        chessEngine = ChessEngine.getInstance();
        blackPlayer = new ChessPlayer(ChessColor.BLACK);
        whitePlayer = new ChessPlayer(ChessColor.WHITE);
    }

    public void launch() {
        chessWebServer.start();
    }
}
