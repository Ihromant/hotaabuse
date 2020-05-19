package ua.ihromant.hotaabuse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(600, 400);
        robot.mousePress(InputEvent.BUTTON1_MASK);
    }
}
