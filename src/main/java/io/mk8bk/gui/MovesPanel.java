package io.mk8bk.gui;

import javax.swing.*;
import java.awt.*;

public class MovesPanel extends JPanel {
    private final int screenUnit;
    public MovesPanel(int screenUnit){
        this.screenUnit = screenUnit;
        this.setPreferredSize(new Dimension(screenUnit*8,screenUnit));
//        this.setBackground(Color.RED);
//        this.setOpaque(true);
    }

}
