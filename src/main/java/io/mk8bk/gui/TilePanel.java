package io.mk8bk.gui;

import io.mk8bk.commons.PieceType;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {
    private final int screenUnit;
    private final JPanel centerPanel;
    private PiecePanel piecePanel;

    private final Color tileColor;
    private final Color textColor;
    private final TileCode tileCode;
    private final JPanel codePanel;
    public TilePanel(int screenUnit, Color tileColor, TileCode tileCode, Color textColor) {
        this.screenUnit = screenUnit;
        this.tileColor = tileColor;
        this.textColor = textColor;
        this.tileCode = tileCode;
        int centerUnit = (int)(screenUnit*0.8);

//        JPanel topPanel = new JPanel();
//        topPanel.add(new JLabel());
//        topPanel.setPreferredSize(new Dimension(screenUnit, (screenUnit-centerUnit)/3));
//        this.add(topPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(centerUnit,centerUnit));
        centerPanel.setOpaque(false);
        this.add(centerPanel, BorderLayout.CENTER);

        codePanel = new JPanel();
        codePanel.setPreferredSize(new Dimension(screenUnit, (screenUnit-centerUnit)/2));
        JLabel codeLabel = new JLabel(tileCode.getTileCode());
        codeLabel.setForeground(textColor);
        codePanel.add(codeLabel);
        codePanel.setOpaque(false);
        this.add(codePanel, BorderLayout.SOUTH);

        this.setBackground(tileColor);
        this.setPreferredSize(new Dimension(screenUnit, screenUnit));
    }

    public PiecePanel popPiecePanel() throws EmptyTileException {
        if(piecePanel==null)
            throw new EmptyTileException(this.tileCode);
        PiecePanel tmp = piecePanel;
        this.piecePanel = null;
        return tmp;
    }

    public void addPiecePanel(PiecePanel piecePanel) throws NonEmptyTileException {
        if(this.piecePanel != null)
            throw new NonEmptyTileException(this.tileCode);
        this.centerPanel.add(piecePanel);
    }

}
