package ua.ihromant.hotaabuse;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Environment {
    private static final Point UNIT_QUEUE_TOP = new Point(497, 722);
    private static final Dimension UNIT_QUEUE_SIZE = new Dimension(30, 35);
    private static final int UNIT_QUEUE_OFFSET = 40;
    private static final double HEXAGON_RADIUS = 25;
    private static final double SIN_60 = Math.sin(Math.PI / 3);
    private static final double COS_60 = 0.561;
    private static final int xTop = 502;
    private static final int yTop = 275;
    private final Robot robot;
    private final Point offset;

    public Environment(Point offset) throws AWTException {
        this.robot = new Robot();
        this.offset = offset;
    }

    public BufferedImage makePicture(Rectangle rect) {
        Point p = rect.getLocation();
        p.translate((int) offset.getX(), (int) offset.getY());
        rect.setLocation(p);
        return robot.createScreenCapture(rect);
    }

    public Unit[] getUnitsFromQueue(int size) {
        List<BufferedImage> cachedImages = Arrays.stream(Unit.values())
                .map(u -> ImageUtil.readImageClassPath(u.name().toLowerCase()))
                .collect(Collectors.toList());
        Unit[] result = new Unit[size];
        return IntStream.range(0, result.length)
                .mapToObj(i -> {
                    Point p = new Point(UNIT_QUEUE_TOP);
                    p.translate(i * UNIT_QUEUE_OFFSET, 0);
                    OptionalInt found = IntStream.range(0, cachedImages.size())
                            .filter(j -> ImageUtil.compareImages(cachedImages.get(j),
                                    makePicture(new Rectangle(p, UNIT_QUEUE_SIZE))))
                            .findAny();
                    if (found.isPresent()) {
                        return Unit.values()[found.getAsInt()];
                    }
                    return Unit.UNKNOWN;
                })
                .toArray(Unit[]::new);
    }

    public void click(int x, int y) {
        System.out.println("Clicking on " + x + ", " + y);
        Point p = computeCenter(x, y);
        directClick(p.x, p.y);
        delay(1200);
    }

    public void click(int x, int y, AttackDirection dir) {
        System.out.println("Clicking on " + x + ", " + y + " from direction " + dir);
        Point p = computeCenter(x, y);
        p.translate(dir.getxSwap(), dir.getySwap());
        directClick(p.x, p.y);
        delay(1200);
    }

    public void cast(int x, int y, int place) {
        System.out.println("Casting spell on place " + place + " and then to coordinates " + x + "," + y);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        delay(100);
        directClick(520 + place % 3 * 100, 260 + place / 3 * 100);
        delay(200);
        Point p = computeCenter(x, y);
        directClick(p.x, p.y);
    }

    public void move(int xCor, int yCor) {
        robot.mouseMove(xCor, yCor);
    }

    public boolean queueStartsWith(Unit... units) {
        return Arrays.equals(units, getUnitsFromQueue(units.length));
    }

    public void clickWhenMoraleDef(int x, int y, Unit... unitsInQueue) {
        click(x, y);
        if (Arrays.equals(unitsInQueue, getUnitsFromQueue(unitsInQueue.length))) {
            System.out.println("Deffing because units are " + Arrays.toString(unitsInQueue));
            delay(1000);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            delay(50);
        }
    }

    public void directClick(int xCor, int yCor) {
        robot.mouseMove(xCor, yCor);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void specificClickWhenMoraleDef(int x, int y, AttackDirection dir, Unit... unitsInQueue) {
        directClick(1125, 730);
        click(x, y, dir);
        if (Arrays.equals(unitsInQueue, getUnitsFromQueue(unitsInQueue.length))) {
            System.out.println("Deffing because units are " + Arrays.toString(unitsInQueue));
            delay(1000);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            delay(50);
        }
    }

    public void clickWhenMoraleDef(int x, int y, AttackDirection dir, Unit... unitsInQueue) {
        click(x, y, dir);
        if (Arrays.equals(unitsInQueue, getUnitsFromQueue(unitsInQueue.length))) {
            System.out.println("Deffing because units are " + Arrays.toString(unitsInQueue));
            delay(1000);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            delay(50);
        }
    }

    public void delay(int milliseconds) {
        robot.delay(milliseconds);
    }

    public void delayUntilQueueInState(Unit... state) {
        System.out.println("Pause until queue begins with " + Arrays.toString(state));
        do {
            delay(100);
        } while (!Arrays.equals(state, getUnitsFromQueue(state.length)));
    }

    public void waitUnit() {
        System.out.println("Waiting by unit");
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        delay(100);
    }

    public Point computeCenter(int x, int y) {
        int xSub = 2 * x - y % 2;
        int ySub = 3 * y;
        double xSwap = SIN_60 * HEXAGON_RADIUS * xSub;
        double ySwap = COS_60 * HEXAGON_RADIUS * ySub;
        return new Point(xTop + (int) xSwap,
                yTop + (int) ySwap);
    }
}
