package me.adipol.trexgamebot.components;

import javax.swing.*;

public class GameStatusLabel extends JLabel {
    public GameStatusLabel() {
        super();
        this.setText("<html>Status: <span style='color: red;'>DISABLED</span></html>");
    }
}
