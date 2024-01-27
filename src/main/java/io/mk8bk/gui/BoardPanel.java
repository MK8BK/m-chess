package io.mk8bk.gui;

import io.mk8bk.commons.ChessColor;
import io.mk8bk.commons.Move;
import io.mk8bk.commons.PieceType;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final boolean whiteView;
    private boolean myTurn;
    private final int screenUnit;
    private final int pieceScreenUnit;

    private final TilePanel[][] boardTiles;

    public BoardPanel(boolean whiteView, int screenUnit) {
        this.whiteView = whiteView;
        this.myTurn = whiteView;
        this.screenUnit = screenUnit;
        this.pieceScreenUnit = (int)(screenUnit*0.6);

        boardTiles = new TilePanel[8][8];
        initTiles();
        initPieces();

        this.setLayout(new GridLayout(8,8));
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                this.add(boardTiles[i][j]);
            }
        }
    }

    private void initPieces() {
        ChessColor playerColor = (whiteView)?ChessColor.WHITE:ChessColor.BLACK;
        for(int i=0; i<8; i++){
            PiecePanel pawnPanel = new PiecePanel(pieceScreenUnit, PieceType.PAWN, playerColor);
            try {
                this.boardTiles[6][i].addPiecePanel(pawnPanel);
            } catch (NonEmptyTileException e) {
                throw new RuntimeException(e);
            }
        }

        ChessColor enemyColor = playerColor.getEnemyColor();
        for(int i=0; i<8; i++){
            PiecePanel pawnPanel = new PiecePanel(pieceScreenUnit, PieceType.PAWN, enemyColor);
            try {
                this.boardTiles[1][i].addPiecePanel(pawnPanel);
            } catch (NonEmptyTileException e) {
                throw new RuntimeException(e);
            }
        }

        PiecePanel playerRook1 = new PiecePanel(pieceScreenUnit, PieceType.ROOK, playerColor);
        PiecePanel playerRook2 = new PiecePanel(pieceScreenUnit, PieceType.ROOK, playerColor);
        PiecePanel enemyRook1 = new PiecePanel(pieceScreenUnit, PieceType.ROOK, enemyColor);
        PiecePanel enemyRook2 = new PiecePanel(pieceScreenUnit, PieceType.ROOK, enemyColor);
        try {
            boardTiles[7][0].addPiecePanel(playerRook1);
            boardTiles[7][7].addPiecePanel(playerRook2);
            boardTiles[0][0].addPiecePanel(enemyRook1);
            boardTiles[0][7].addPiecePanel(enemyRook2);
        } catch (NonEmptyTileException e) {
            throw new RuntimeException(e);
        }

        PiecePanel playerKnight1 = new PiecePanel(pieceScreenUnit, PieceType.KNIGHT, playerColor);
        PiecePanel playerKnight2 = new PiecePanel(pieceScreenUnit, PieceType.KNIGHT, playerColor);
        PiecePanel enemyKnight1 = new PiecePanel(pieceScreenUnit, PieceType.KNIGHT, enemyColor);
        PiecePanel enemyKnight2= new PiecePanel(pieceScreenUnit, PieceType.KNIGHT, enemyColor);
        try {
            boardTiles[7][1].addPiecePanel(playerKnight1);
            boardTiles[7][6].addPiecePanel(playerKnight2);
            boardTiles[0][1].addPiecePanel(enemyKnight1);
            boardTiles[0][6].addPiecePanel(enemyKnight2);
        } catch (NonEmptyTileException e) {
            throw new RuntimeException(e);
        }
        PiecePanel playerBishop1 = new PiecePanel(pieceScreenUnit, PieceType.BISHOP, playerColor);
        PiecePanel playerBishop2 = new PiecePanel(pieceScreenUnit, PieceType.BISHOP, playerColor);
        PiecePanel enemyBishop1 = new PiecePanel(pieceScreenUnit, PieceType.BISHOP, enemyColor);
        PiecePanel enemyBishop2 = new PiecePanel(pieceScreenUnit, PieceType.BISHOP, enemyColor);
        try {
            boardTiles[7][2].addPiecePanel(playerBishop1);
            boardTiles[7][5].addPiecePanel(playerBishop2);
            boardTiles[0][2].addPiecePanel(enemyBishop1);
            boardTiles[0][5].addPiecePanel(enemyBishop2);
        } catch (NonEmptyTileException e) {
            throw new RuntimeException(e);
        }

        PiecePanel playerKing = new PiecePanel(pieceScreenUnit, PieceType.KING, playerColor);
        PiecePanel enemyKing = new PiecePanel(pieceScreenUnit, PieceType.KING, enemyColor);
        PiecePanel playerQueen = new PiecePanel(pieceScreenUnit, PieceType.QUEEN, playerColor);
        PiecePanel enemyQueen = new PiecePanel(pieceScreenUnit, PieceType.QUEEN, enemyColor);
        int queenColumn;
        if(whiteView)
            queenColumn = 3;
        else
            queenColumn = 4;
        int kingColumn = (queenColumn == 3)?4:3;
        try {
            boardTiles[7][kingColumn].addPiecePanel(playerKing);
            boardTiles[7][queenColumn].addPiecePanel(playerQueen);
            boardTiles[0][kingColumn].addPiecePanel(enemyKing);
            boardTiles[0][queenColumn].addPiecePanel(enemyQueen);
        } catch (NonEmptyTileException e) {
            throw new RuntimeException(e);
        }

    }

    private void initTiles() {
//        int offset = whiteView?0:1;
        TilePanel temp = null;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Color background = ((i+j)%2 == 0)?Color.WHITE:Color.BLACK;
                Color foreground = (background==Color.BLACK)?Color.WHITE:Color.BLACK;
                temp = new TilePanel(
                        this.screenUnit,
                        this.pieceScreenUnit,
                        background,
                        foreground,
                        new TileCode(i, j, whiteView)
                );
                boardTiles[i][j] = temp;
            }
        }
    }

    public void applyOpponentMove(Move move) {

    }
}
