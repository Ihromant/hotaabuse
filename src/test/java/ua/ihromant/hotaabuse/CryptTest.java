package ua.ihromant.hotaabuse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CryptTest {
    private Environment env;

    @BeforeEach
    private void init() throws AWTException {
        this.env = new Environment(new Point());
    }

    @Test
    public void saveImage() throws IOException {
        BufferedImage image = env.makePicture(new Rectangle(new Point(497, 722), new Dimension(30, 35)));
        ImageIO.write(image, "png", new File("/tmp/pictures/test.png"));
    }

    @Test
    public void testWidth() throws IOException {
        BufferedImage image = env.makePicture(new Rectangle(new Point(497, 722), new Dimension(30, 35)));
        BufferedImage image1 = env.makePicture(new Rectangle(new Point(497 + 40, 722), new Dimension(30, 35)));
        ImageIO.write(image, "png", new File("/tmp/pictures/test.png"));
        ImageIO.write(image1, "png", new File("/tmp/pictures/test1.png"));
    }

    @Test
    public void readLine() throws IOException {
        for (int i = 0; i < 10; i++) {
            BufferedImage image = env.makePicture(new Rectangle(new Point(497 + 40 * i, 722), new Dimension(30, 35)));
            ImageIO.write(image, "png", new File("/tmp/pictures/test" + i + ".png"));
        }
    }

    @Test
    public void compareImages() throws IOException {
        int[] bytes = ImageUtil.extractBytes("/tmp/pictures/test4.png");
        int[] bytes1 = ImageUtil.extractBytes("/tmp/pictures/test5.png");
        Assertions.assertEquals(bytes.length, bytes1.length);
        int counter = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == bytes1[i]) {
                counter++;
            }
        }
        double rate = 1.0 * counter / bytes.length;
        System.out.println(rate);
        Assertions.assertTrue(rate > 0.95);
    }

    @Test
    public void testImageComparison() {
        BufferedImage image = ImageUtil.readImageClassPath("gremlin");
        BufferedImage image1 = env.makePicture(new Rectangle(new Point(497, 722), new Dimension(30, 35)));
        Assertions.assertTrue(ImageUtil.compareImages(image, image1));
    }

    @Test
    public void testUnitsFromQueue() {
        Unit[] units = env.getUnitsFromQueue(6);
        Assertions.assertArrayEquals(units,
                new Unit[] {Unit.GREMLIN, Unit.WIGHT, Unit.SKELETON, Unit.SKELETON, Unit.WALKING_DEAD, Unit.WALKING_DEAD});
    }

    @Test
    public void testClickOnField() {
        env.click(8, 10);
    }

    @Test
    public void testCrypt() {
        if (env.queueStartsWith(Unit.GARGOLYE, Unit.GARGOLYE, Unit.GARGOLYE, Unit.VAMPIRE)) {
            testCryptMaxi();
        } else {
            if (env.queueStartsWith(Unit.GARGOLYE, Unit.GARGOLYE, Unit.GARGOLYE, Unit.GREMLIN, Unit.WIGHT)) {
                testCryptPreMini();
            } else {
                testCryptMini();
            }
        }
    }

    private void testCryptPreMini() {
        env.clickWhenMoraleDef(1, 9, new Unit[] {Unit.GARGOLYE, Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(0, 8, new Unit[] {Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(9, 10, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(14, 5, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GARGOLYE);
        env.clickWhenMoraleDef(0, 10, new Unit[] {Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(7, 6, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(11, 2, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE);
        env.clickWhenMoraleDef(2, 2, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(14, 2, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE);
        env.clickWhenMoraleDef(0, 9, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(12, 4, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.clickWhenMoraleDef(7, 1, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GREMLIN, Unit.WIGHT);
        if (env.queueStartsWith(Unit.GREMLIN, Unit.WIGHT, Unit.UNKNOWN)) {
            env.waitUnit();
            env.delayUntilQueueInState(Unit.GREMLIN);
            env.click(8, 3);
        } else {
            env.clickWhenMoraleDef(10, 1, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GREMLIN);
            env.click(8, 3);
        }
    }

    private void testCryptMini() {
        env.clickWhenMoraleDef(0, 1, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(6, 10, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(9, 10, new Unit[]{Unit.GARGOLYE});
        env.clickWhenMoraleDef(14, 5, new Unit[]{Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GARGOLYE);
        env.clickWhenMoraleDef(4, 5, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(7, 6, new Unit[]{Unit.GARGOLYE});
        env.clickWhenMoraleDef(11, 2, new Unit[]{Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GARGOLYE);
        env.clickWhenMoraleDef(2, 10, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(9, 4, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(11, 7, new Unit[]{Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GARGOLYE);
        env.clickWhenMoraleDef(6, 10, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(12, 9, new Unit[] {Unit.GARGOLYE});
        env.clickWhenMoraleDef(13, 0, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE);
        if (env.queueStartsWith(Unit.GARGOLYE, Unit.GREMLIN)) {
            env.clickWhenMoraleDef(4, 4, new Unit[] {Unit.GARGOLYE});
            env.clickWhenMoraleDef(9, 1, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GREMLIN);
            env.clickWhenMoraleDef(8, 0, new Unit[] {Unit.GARGOLYE});
            env.clickWhenMoraleDef(13, 5, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GREMLIN);
            env.clickWhenMoraleDef(14, 0, new Unit[] {Unit.GARGOLYE});
            env.clickWhenMoraleDef(7, 2, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GREMLIN);
            env.waitUnit();
            env.clickWhenMoraleDef(10, 1, new Unit[] {Unit.GREMLIN});
        } else {

        }
    }

    private void testCryptMaxi() {
        env.clickWhenMoraleDef(0, 7, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE, Unit.GARGOLYE});
        env.clickWhenMoraleDef(10, 5, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GREMLIN, Unit.GARGOLYE);
        env.clickWhenMoraleDef(13, 0, new Unit[] {Unit.GREMLIN});
        env.clickWhenMoraleDef(8, 0, new Unit[] {Unit.GARGOLYE, Unit.UNKNOWN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.GARGOLYE);
        env.clickWhenMoraleDef(8, 10, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.clickWhenMoraleDef(12, 4, new Unit[] {Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.UNKNOWN);
        env.clickWhenMoraleDef(2, 1, new Unit[] {Unit.GARGOLYE, Unit.UNKNOWN});
        env.clickWhenMoraleDef(5, 10, new Unit[]{Unit.GARGOLYE, Unit.GREMLIN});
        env.clickWhenMoraleDef(0, 3, new Unit[]{Unit.GARGOLYE, Unit.GARGOLYE});
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.clickWhenMoraleDef(12, 1, new Unit[]{Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.VAMPIRE);
        env.clickWhenMoraleDef(2, 10, new Unit[]{Unit.GARGOLYE, Unit.VAMPIRE});
        env.delayUntilQueueInState(Unit.GREMLIN);
        env.clickWhenMoraleDef(12, 1, new Unit[]{Unit.GREMLIN});
        env.delayUntilQueueInState(Unit.GARGOLYE, Unit.VAMPIRE);
        env.clickWhenMoraleDef(9, 10, new Unit[] {Unit.GARGOLYE});
        env.delayUntilQueueInState(Unit.GREMLIN, Unit.WALKING_DEAD);
        env.clickWhenMoraleDef(8, 10, new Unit[] {Unit.GREMLIN, Unit.WALKING_DEAD});
        env.delayUntilQueueInState(Unit.GREMLIN, Unit.VAMPIRE);
        env.clickWhenMoraleDef(8, 10, new Unit[] {Unit.GREMLIN});
        if (env.queueStartsWith(Unit.WALKING_DEAD, Unit.UNKNOWN) || env.queueStartsWith(Unit.GREMLIN, Unit.WALKING_DEAD)) {
            env.delayUntilQueueInState(Unit.GREMLIN, Unit.WALKING_DEAD);
            env.clickWhenMoraleDef(7, 3, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GREMLIN, Unit.WALKING_DEAD);
            env.clickWhenMoraleDef(9, 1, new Unit[] {Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GREMLIN, Unit.WALKING_DEAD);
            env.click(12, 1);
        } else {
            env.delayUntilQueueInState(Unit.GREMLIN);
            env.clickWhenMoraleDef(11, 4, new Unit[]{Unit.GREMLIN});
            env.delayUntilQueueInState(Unit.GREMLIN);
            if (env.queueStartsWith(Unit.GREMLIN, Unit.VAMPIRE)) {
                env.clickWhenMoraleDef(13, 1, new Unit[]{Unit.GREMLIN});
            } else {
                env.clickWhenMoraleDef(9, 1, new Unit[]{Unit.GREMLIN});
                env.delayUntilQueueInState(Unit.GREMLIN);
                env.clickWhenMoraleDef(7, 0, new Unit[]{Unit.GREMLIN});
                env.delayUntilQueueInState(Unit.GREMLIN);
                env.clickWhenMoraleDef(1, 0, new Unit[]{Unit.GREMLIN});
                env.delayUntilQueueInState(Unit.GREMLIN);
            }
        }
    }
}
