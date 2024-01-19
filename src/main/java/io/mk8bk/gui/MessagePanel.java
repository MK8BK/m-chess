package io.mk8bk.gui;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    private final int screenUnit;

    public MessagePanel(int screenUnit) {
        this.screenUnit = screenUnit;
        this.setPreferredSize(new Dimension(screenUnit*4, screenUnit*8));

    }
}