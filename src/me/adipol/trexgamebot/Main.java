package me.adipol.trexgamebot;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import me.adipol.trexgamebot.components.ElementsPanel;
import me.adipol.trexgamebot.components.GameCounterLabel;
import me.adipol.trexgamebot.components.GameStatusLabel;
import me.adipol.trexgamebot.listener.KeyListener;
import me.adipol.trexgamebot.listener.StartButtonListener;
import me.adipol.trexgamebot.task.GameCounterTask;
import me.adipol.trexgamebot.task.GameTask;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class Main extends JFrame {
    public static int gameTime = 0;
    public static int WIDTH = 16;
    public static int HEIGHT = 10;
    public static int X = ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - 185; //471
    public static int Y = 353; //353
    public static int enableButton = GlobalKeyEvent.VK_F2;

    JPanel elementsPanel = new ElementsPanel();
    public static JButton startButton;
    public static JLabel gameCounter = new GameCounterLabel();
    public static JLabel gameStatus = new GameStatusLabel();

    GlobalKeyboardHook keyboardHook;
    GameTask gameTask;
    GameCounterTask gameCounterTask;


    public Main() {
        super("T-Rex Google Bot");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setResizable(false);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));

        keyboardHook = new GlobalKeyboardHook(true);
        gameTask = new GameTask();
        gameCounterTask = new GameCounterTask();
        startButton = new JButton("START!");

        keyboardHook.addKeyListener(new KeyListener(gameTask, gameCounterTask, startButton));
        startButton.addActionListener(new StartButtonListener(gameTask, gameCounterTask, startButton));

        this.initComponents();
        this.pack();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {
            System.out.println("EX: " + ex.getMessage());
        }

        updateComponentTreeUI(this);
    }

    public void initComponents() {
        GroupLayout layout = new GroupLayout(this.getContentPane());
        //layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addComponent(elementsPanel, 300, 300, 300)
                .addComponent(startButton, 300, 300, 300)
                .addComponent(gameStatus)
                .addComponent(gameCounter)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(elementsPanel, 55, 55, 55)
                .addComponent(startButton, 65, 65, 65)
                .addComponent(gameStatus)
                .addComponent(gameCounter)

        );

        this.setLayout(layout);
    }

    public static void main(String[] args) throws AWTException {
        new Main();
    }
}
