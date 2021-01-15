package me.adipol.trexgamebot.keys;

import java.awt.*;
import java.awt.event.KeyEvent;

public class JumpRobot {
    public static void jumpPlayer(Robot robot) {
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(80);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(200);
    }

    public static void bendDownPlayer(Robot robot) {
        robot.keyPress(KeyEvent.VK_DOWN);
    }

    public static void getUpPlayer(Robot robot) {
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.delay(20);
    }
}
