package me.adipol.trexgamebot.components;

import me.adipol.trexgamebot.layout.ElementsPanelLayout;

import javax.swing.*;
import java.awt.*;

public class ElementsPanel extends JPanel {
    public ElementsPanel() {
        super();
        this.setBorder(BorderFactory.createTitledBorder("Ustawienia bota"));
        this.setLayout(new ElementsPanelLayout(this));
    }
}
