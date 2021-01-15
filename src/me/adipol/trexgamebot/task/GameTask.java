package me.adipol.trexgamebot.task;

import me.adipol.trexgamebot.Main;
import me.adipol.trexgamebot.keys.JumpRobot;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameTask implements Runnable {
    private Thread thread;
    private boolean isEnable;

    @Override
    public void run() {
        while(isEnable) {
            try {
                Robot robot = new Robot();
                int colors = 0;

                Rectangle rectangle = new Rectangle(Main.X, Main.Y, Main.WIDTH, Main.HEIGHT);
                BufferedImage bufferedImage = robot.createScreenCapture(rectangle);



                for(int x = 0; x<bufferedImage.getWidth(); x++)
                    for(int y = 0; y<bufferedImage.getHeight(); y++) {
                        colors+=bufferedImage.getRGB(x, y);
                    }



                if((colors != (Main.WIDTH * Main.HEIGHT) * -526345)) {
                    colors = 0;
                    JumpRobot.getUpPlayer(robot);
                    JumpRobot.jumpPlayer(robot);
                    JumpRobot.bendDownPlayer(robot);

                    rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    bufferedImage = robot.createScreenCapture(rectangle);


                    //resetowanie gry
                    if(bufferedImage.getRGB(670, 312) == -11316397)
                       Main.gameTime = 0;
                }

                colors = 0;


            }
            catch (AWTException ex) {
                System.out.println("error: " + ex);
            }
        }
    }

    public void start() {
        isEnable = true;
        thread = new Thread(this);
        thread.start();
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
