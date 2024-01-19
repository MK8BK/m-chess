package io.mk8bk.gui;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {
    private final int screenUnit;
    private final Color tileColor;

    public TilePanel(int screenUnit, Color tileColor) {
        this.screenUnit = screenUnit;
        this.tileColor = tileColor;
        this.setBackground(tileColor);
        this.setPreferredSize(new Dimension(screenUnit, screenUnit));
    }
}
