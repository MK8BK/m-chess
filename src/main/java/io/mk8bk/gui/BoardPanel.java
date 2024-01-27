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
    }

    private void initTiles() {
        int offset = whiteView?0:1;
        TilePanel temp = null;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Color background = ((offset+i+j)%2 == 0)?Color.WHITE:Color.BLACK;
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
