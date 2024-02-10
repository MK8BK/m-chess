package io.mk8bk.gui;

import io.mk8bk.commons.actions.ChessAction;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    // window width and height
    private final int width;
    private final int height;
    private boolean myTurn;

    // main panels
    private final BoardPanel boardPanel;
    private final MessagePanel messagePanel;
    private final MovesPanel movesPanel;

    public GameFrame(boolean whiteView) {
        myTurn = whiteView;

        // get screen dimensions
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        float scale = .95f;
        this.width = (int)(scale * d.width);
        this.height = (int)(scale * d.height);

        // most common screen size is 1920x1080 ~ 19x11
        int widthUnit = width/19;
        int heightUnit = height/11;
        int screenUnit = Math.min(widthUnit, heightUnit);

        // instantiating the 3 main panels
        this.boardPanel = new BoardPanel(whiteView, screenUnit);
        this.messagePanel = new MessagePanel(screenUnit);
        this.movesPanel = new MovesPanel(screenUnit);

        // adding the main panels to the frame
        this.setLayout(new BorderLayout(5, 5));
        this.add(this.boardPanel, BorderLayout.CENTER);
        this.add(this.messagePanel, BorderLayout.EAST);
        this.add(this.movesPanel, BorderLayout.NORTH);

        // displaying the window
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void applyOpponentMove(ChessAction chessAction){
        boardPanel.applyOpponentMove(chessAction);
    }
}
