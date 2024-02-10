package io.mk8bk.gui;

import io.mk8bk.commons.ChessColor;
import io.mk8bk.commons.pieces.PieceType;

import javax.swing.*;
import java.awt.*;

class SpritePanel extends JPanel {
    public ImageIcon getSprite() {
        return sprite;
    }

    private ImageIcon sprite;

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    protected int height;
    protected int width;

    public SpritePanel(ImageIcon imageIcon, int width, int height) {
        this.sprite = imageIcon;
        this.height = height;
        this.width = width;
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(this.width, this.height));
    }

    public SpritePanel(int width, int height) {
        this.sprite = null;
        this.height = height;
        this.width = width;
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(this.width, this.height));
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.sprite.getImage(),0,0, this.width,this.height,null);
    }

    public void setSprite(ImageIcon image) {
        this.sprite = image;
        this.repaint();
    }

//    @Override
//    public java.awt.Component add(java.awt.Component component){
//        return super.add(component);
//    }
}

public class PiecePanel extends JPanel {
    private final int screenUnit;
    private final SpritePanel spritePanel;

    public PiecePanel(int screenUnit, PieceType pieceType, ChessColor chessColor) {
        this.screenUnit = screenUnit;
        ImageIcon background = new ImageIcon(
                "src/main/resources/sprites/allsplit/" +
                        chessColor.getColorCode() +
                        pieceType.verboseName + ".png");
        this.spritePanel = new SpritePanel(background, screenUnit, screenUnit);
        this.add(spritePanel);
        this.setOpaque(false);
    }
}
