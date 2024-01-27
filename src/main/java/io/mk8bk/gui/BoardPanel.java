package io.mk8bk.gui;

import io.mk8bk.commons.Move;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final boolean whiteView;
    private boolean myTurn;
    private final int screenUnit;

    private final TilePanel[][] boardTiles;

    public BoardPanel(boolean whiteView, int screenUnit) {
        this.whiteView = whiteView;
        this.myTurn = whiteView;
        this.screenUnit = screenUnit;

        boardTiles = new TilePanel[8][8];
        initTiles();

        this.setLayout(new GridLayout(8,8));
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                this.add(boardTiles[i][j]);
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
                        background,
                        new TileCode(i, j, whiteView),
                        foreground
                );
                boardTiles[i][j] = temp;
            }
        }
    }

    public void applyOpponentMove(Move move) {

    }
}
