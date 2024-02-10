package io.mk8bk.gui;

import javax.swing.*;
import java.awt.*;

public class CenterTilePanel extends JPanel {
    private boolean highlight;
    public CenterTilePanel(int screenUnit){

        this.setPreferredSize(new Dimension(screenUnit, screenUnit));
        this.setOpaque(false);
        highlight = false;
    }
    public void setHighlight(boolean b){
        highlight = b;
        repaint();
    }

    // @Override
    // public void repaint(){
    //     if(highlight){
    //         this.setOpaque(true);
    //     }
    //     super.repaint();
    // }
}
