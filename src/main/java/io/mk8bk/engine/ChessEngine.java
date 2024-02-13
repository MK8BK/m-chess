package io.mk8bk.engine;

import io.mk8bk.commons.actions.ChessAction;
import io.mk8bk.controller.ChessPlayer;

public class ChessEngine {
    private static ChessEngine chessEngine;
    private static ChessAction[] availableChessActions;
    public static ChessAction[] getAvailableMoves(){
        return null;
    }

    public static ChessEngine getInstance(){
        if(chessEngine==null){
            chessEngine = new ChessEngine();
        }
        return chessEngine;
    }
    private ChessEngine(){

    }

    public void applyMove(ChessAction chessAction) throws InvalidMoveException {

    }

}
