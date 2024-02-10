package io.mk8bk.gui;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {
    private final int screenUnit;
    private final int pieceScreenUnit;
    private final CenterTilePanel centerPanel;
    private PiecePanel piecePanel;

    private final Color tileColor;
    private final Color textColor;
    private final TileCode tileCode;
    private final JPanel codePanel;
    public TilePanel(int screenUnit, int pieceScreenUnit, Color tileColor, Color textColor, TileCode tileCode) {
        this.screenUnit = screenUnit;
        this.tileColor = tileColor;
        this.textColor = textColor;
        this.tileCode = tileCode;
        this.pieceScreenUnit = pieceScreenUnit;
        int codeLabelHeight = (screenUnit-pieceScreenUnit)/2;

        // just used to center centerPanel
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel());
        topPanel.setPreferredSize(new Dimension(screenUnit, codeLabelHeight));
        topPanel.setOpaque(false);
        this.add(topPanel, BorderLayout.NORTH);

        centerPanel = new CenterTilePanel(pieceScreenUnit);
        this.add(centerPanel, BorderLayout.CENTER);

        codePanel = new JPanel();
        codePanel.setPreferredSize(new Dimension(screenUnit, codeLabelHeight));
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
        this.centerPanel.remove(0);
        return tmp;
    }

    public void addPiecePanel(PiecePanel piecePanel) throws NonEmptyTileException {
        if(this.piecePanel != null){
            throw new NonEmptyTileException(this.tileCode);
        }
        this.piecePanel = piecePanel;
        this.centerPanel.add(piecePanel);
    }

    public void highlight(boolean b){
        this.centerPanel.setHighlight(b);
    }
}
