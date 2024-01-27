package io.mk8bk.engine;

import io.mk8bk.commons.Move;

public class InvalidMoveException extends IllegalArgumentException{
    public InvalidMoveException(){
        super("Move is not allowed.");
    }
    public InvalidMoveException(Move move){
        super("Move %s is not allowed.".formatted(move.toString()));
    }

}
