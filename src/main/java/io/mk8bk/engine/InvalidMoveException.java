package io.mk8bk.engine;

import io.mk8bk.commons.actions.ChessAction;

public class InvalidMoveException extends IllegalArgumentException{
    public InvalidMoveException(){
        super("ChessAction is not allowed.");
    }
    public InvalidMoveException(ChessAction chessAction){
        super("ChessAction %s is not allowed.".formatted(chessAction.toString()));
    }

}
