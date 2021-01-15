package me.adipol.trexgamebot.listener;

import me.adipol.trexgamebot.Main;
import me.adipol.trexgamebot.layout.ElementsPanelLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeKeyButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.startButton.setEnabled(false);
        ElementsPanelLayout.changeKeyButton.setText("WCIŚNIJ PRZYCISK");
        KeyListener.isChangeKey = true;
    }
}
