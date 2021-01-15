package me.adipol.trexgamebot.listener;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;
import me.adipol.trexgamebot.Main;
import me.adipol.trexgamebot.keys.JumpRobot;
import me.adipol.trexgamebot.layout.ElementsPanelLayout;
import me.adipol.trexgamebot.task.GameCounterTask;
import me.adipol.trexgamebot.task.GameTask;

import javax.swing.*;
import java.awt.*;

public class KeyListener implements GlobalKeyListener {
    private boolean isKeyPress = false;
    private boolean isBotStart = false;
    public static boolean isChangeKey = false;
    GameTask gameTask;
    GameCounterTask gameCounterTask;
    private JButton startButton;

    public KeyListener(GameTask gameTask, GameCounterTask gameCounterTask, JButton startButton) {
        this.gameTask = gameTask;
        this.gameCounterTask = gameCounterTask;
        this.startButton = startButton;
    }

    @Override
    public void keyPressed(GlobalKeyEvent e) {
        //odpalenie bota
        if(e.getVirtualKeyCode() == Main.enableButton && !isChangeKey) {
            if(!isKeyPress) {
                if(!isBotStart) {
                    gameTask.start();
                    gameCounterTask.start();
                    isBotStart = true;
                    startButton.setText("STOP!");
                    ElementsPanelLayout.changeKeyButton.setEnabled(false);
                    Main.gameStatus.setText("<html>Status: <span style='color: green;'>ENABLED</span></html>");
                }

                else {
                    gameTask.stop();
                    gameCounterTask.stop();
                    try {
                        JumpRobot.getUpPlayer(new Robot());
                    }
                    catch(Exception ex) {

                    }

                    isBotStart = false;
                    startButton.setText("START!");
                    ElementsPanelLayout.changeKeyButton.setEnabled(true);
                    Main.gameStatus.setText("<html>Status: <span style='color: red;'>DISABLED</span></html>");
                    Main.gameCounter.setText("Czas trwania gry: 0s");
                }
            }

            isKeyPress = true;
        }

        //zmiana przycisku na start
        if(isChangeKey) {
            switch(e.getVirtualKeyCode()) {
                case GlobalKeyEvent.VK_F1:
                    Main.enableButton = GlobalKeyEvent.VK_F1;
                    ElementsPanelLayout.actualKey.setText("F1");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F2:
                    Main.enableButton = GlobalKeyEvent.VK_F2;
                    ElementsPanelLayout.actualKey.setText("F2");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F3:
                    Main.enableButton = GlobalKeyEvent.VK_F3;
                    ElementsPanelLayout.actualKey.setText("F3");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F4:
                    Main.enableButton = GlobalKeyEvent.VK_F4;
                    ElementsPanelLayout.actualKey.setText("F4");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F5:
                    Main.enableButton = GlobalKeyEvent.VK_F5;
                    ElementsPanelLayout.actualKey.setText("F5");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F6:
                    Main.enableButton = GlobalKeyEvent.VK_F6;
                    ElementsPanelLayout.actualKey.setText("F6");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F7:
                    Main.enableButton = GlobalKeyEvent.VK_F7;
                    ElementsPanelLayout.actualKey.setText("F7");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F8:
                    Main.enableButton = GlobalKeyEvent.VK_F8;
                    ElementsPanelLayout.actualKey.setText("F8");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F9:
                    Main.enableButton = GlobalKeyEvent.VK_F9;
                    ElementsPanelLayout.actualKey.setText("F9");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F10:
                    Main.enableButton = GlobalKeyEvent.VK_F10;
                    ElementsPanelLayout.actualKey.setText("F10");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F11:
                    Main.enableButton = GlobalKeyEvent.VK_F11;
                    ElementsPanelLayout.actualKey.setText("F11");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                case GlobalKeyEvent.VK_F12:
                    Main.enableButton = GlobalKeyEvent.VK_F12;
                    ElementsPanelLayout.actualKey.setText("F12");
                    ElementsPanelLayout.changeKeyButton.setText("Start / Stop");
                    Main.startButton.setEnabled(true);
                    break;
                default:
                    System.out.println("Zły przycisk!");
            }
            isChangeKey = false;
        }

    }

    @Override
    public void keyReleased(GlobalKeyEvent e) {
        if(e.getVirtualKeyCode() == Main.enableButton)
            if(isKeyPress)
                isKeyPress = false;
    }
}
