package me.adipol.trexgamebot.listener;

import me.adipol.trexgamebot.Main;
import me.adipol.trexgamebot.layout.ElementsPanelLayout;
import me.adipol.trexgamebot.task.GameCounterTask;
import me.adipol.trexgamebot.task.GameTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {
    private JButton startButton;
    private boolean isStartBot = false;
    GameTask gameTask;
    GameCounterTask gameCounterTask;

    public StartButtonListener(GameTask gameTask, GameCounterTask gameCounterTask, JButton button) {
        this.gameTask = gameTask;
        this.gameCounterTask = gameCounterTask;
        this.startButton = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isStartBot) {
            startButton.setText("STOP!");
            isStartBot = true;
            ElementsPanelLayout.changeKeyButton.setEnabled(false);

            gameTask.start();
            gameCounterTask.start();

            Main.gameStatus.setText("<html>Status: <span style='color: green;'>ENABLED</span></html>");
        }
        else {
            startButton.setText("START!");
            isStartBot = false;
            ElementsPanelLayout.changeKeyButton.setEnabled(true);

            gameTask.stop();
            gameCounterTask.stop();

            Main.gameStatus.setText("<html>Status: <span style='color: red;'>DISABLED</span></html>");
            Main.gameCounter.setText("Czas trwania gry: 0s");
        }
    }
}
