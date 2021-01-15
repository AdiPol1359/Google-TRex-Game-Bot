package me.adipol.trexgamebot.task;

import me.adipol.trexgamebot.Main;

import javax.swing.*;

public class GameCounterTask implements Runnable {
    private Thread thread;
    private boolean isEnable;

    @Override
    public void run() {
        while(isEnable) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Main.gameTime += 1;

            Main.gameCounter.setText("Czas trwania gry: " + Main.gameTime + "s");

            if(Main.gameTime == 30) {
                Main.X+= 5;
            }


            if(Main.gameTime == 60) {
                Main.X+= 5;
            }

            if(Main.gameTime == 90) {
                Main.X+= 5;
            }
        }
    }

    public void start() {
        isEnable = true;
        thread = new Thread(this);
        thread.start();
        Main.gameTime = 0;
    }

    public void stop() {
        isEnable = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
