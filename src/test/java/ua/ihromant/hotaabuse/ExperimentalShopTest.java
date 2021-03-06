package ua.ihromant.hotaabuse;

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
import java.util.Arrays;

public class ExperimentalShopTest {
    private Environment env;
    
    @BeforeEach
    private void init() throws AWTException {
        this.env = new Environment(new Point());
    }

    @Test
    public void testCast() {
        env.click(-6, 0);
        env.cast(5, 3, 0);
    }

    private void begin() {
        // 1 round
        env.click(-6, 0);
        env.cast(5, 3, 0);
        env.delayUntilQueueInState(Unit.THUNDERBIRD, Unit.ORC);
        env.clickWhenMoraleDef(6, 4, Unit.THUNDERBIRD);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(4, 3, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.WOLF_RIDER);
        env.clickWhenMoraleDef(4, 4, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.HOBGOBLIN, Unit.WOLF_RIDER);
        env.clickWhenMoraleDef(7, 7, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RIDER);
        env.clickWhenMoraleDef(5, 2, Unit.WOLF_RIDER, Unit.WOLF_RIDER);
        env.clickWhenMoraleDef(6, 5, Unit.WOLF_RIDER);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(1, 1, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 2 round
        env.cast(6, 5, 0);
        env.delayUntilQueueInState(Unit.THUNDERBIRD, Unit.WOLF_RIDER);
        env.clickWhenMoraleDef(0, 0, Unit.THUNDERBIRD);
        env.clickWhenMoraleDef(0, 2, Unit.WOLF_RIDER);
        env.waitUnit();
        env.clickWhenMoraleDef(2, 1, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(2, 0, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(5, 6, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 3 round
        env.cast(0, 0, 0);
        env.clickWhenMoraleDef(12, 2, Unit.THUNDERBIRD);
        env.clickWhenMoraleDef(10, 10, Unit.ORC);
        env.clickWhenMoraleDef(9, 1, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(9, 0, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 4 round
        env.cast(10, 10, 0);
        env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
        env.clickWhenMoraleDef(13, 10, Unit.ORC);
        env.clickWhenMoraleDef(8, 1, AttackDirection.CENTER, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
    }

    private void firstGolemKilling() {
        Integer[] numbs;
        while ((numbs = env.getNumbersFromQueue(7)) != null
            && (numbs[2] == null || !numbs[2].equals(10))) {
            // odd round from 5th
            env.clickWhenMoraleDef(12, 3, Unit.THUNDERBIRD);
            env.waitUnit();
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(9, 3, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // even round from 6th
            env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.waitUnit();
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(3, 3, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
        env.cast(0, 3, 7);
        env.clickWhenMoraleDef(11, 3, Unit.THUNDERBIRD);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(9, 3, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // even round from 6th
        env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(3, 3, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        while (!Arrays.equals(new Unit[] {Unit.THUNDERBIRD, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.ORC},
                env.getUnitsFromQueue(6))) {
            // odd round from 5th
            env.clickWhenMoraleDef(12, 3, Unit.THUNDERBIRD);
            env.waitUnit();
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(9, 3, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // even round from 6th
            env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.waitUnit();
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(3, 3, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
    }

    public void regroupForFourStacks() {
        // 1st round
        env.clickWhenMoraleDef(11, 5, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(8, 5, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 2 round
        env.clickWhenMoraleDef(0, 7, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(3, 7, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 3 round
        env.clickWhenMoraleDef(10, 10, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(14, 6, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 4 round
        env.clickWhenMoraleDef(4, 0, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(6, 4, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 5 round
        env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(13, 10, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        // 6 round
        env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(10, 10, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
    }

    private void secondGolemKilling() {
        while (!Arrays.equals(new Unit[] {Unit.THUNDERBIRD, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.ORC},
                env.getUnitsFromQueue(5))) {
            // odd round from 5th
            env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(11, 1, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // even round from 6th
            env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(6, 3, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
    }

    public void regroupForThreeStacks() {
        env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(8, 10, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
    }

    private void thirdFourthGolemKilling() {
        while (!Arrays.equals(new Unit[] {Unit.THUNDERBIRD, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.ORC},
                env.getUnitsFromQueue(4))) {
            // odd round from 5th
            env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(3, 2, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // even round from 6th
            env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(9, 2, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
        // odd round from 5th
        env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
        env.delayUntilQueueInState(Unit.ORC);
        env.clickWhenMoraleDef(4, 1, Unit.ORC);
        env.delayUntilQueueInState(Unit.THUNDERBIRD);
        while (!Arrays.equals(new Unit[] {Unit.THUNDERBIRD, Unit.STEEL_GOLEM, Unit.ORC},
                env.getUnitsFromQueue(3))) {
            // even round from 6th
            env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(10, 1, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // odd round from 5th
            env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(4, 1, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
    }

    private void lastGolemKilling() {
        Integer[] numbs;
        while ((numbs = env.getNumbersFromQueue(3)) != null
                && (numbs[1] == null || !numbs[1].equals(9))) {
            // odd round from 5th
            env.clickWhenMoraleDef(13, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(10, 0, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
            // even round from 6th
            env.clickWhenMoraleDef(2, 0, Unit.THUNDERBIRD);
            env.delayUntilQueueInState(Unit.ORC);
            env.clickWhenMoraleDef(4, 0, Unit.ORC);
            env.delayUntilQueueInState(Unit.THUNDERBIRD);
        }
//        env.cast(0, 3, 7);
//        env.clickWhenMoraleDef(11, 3, Unit.THUNDERBIRD);
//        env.waitUnit();
//        env.delayUntilQueueInState(Unit.ORC);
//        env.clickWhenMoraleDef(9, 3, Unit.ORC);
//        env.delayUntilQueueInState(Unit.THUNDERBIRD);
//        // even round from 6th
//        env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
//        env.delayUntilQueueInState(Unit.ORC);
//        env.waitUnit();
//        env.delayUntilQueueInState(Unit.ORC);
//        env.clickWhenMoraleDef(3, 3, Unit.ORC);
//        env.delayUntilQueueInState(Unit.THUNDERBIRD);
//        while (!Arrays.equals(new Unit[] {Unit.THUNDERBIRD, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.STEEL_GOLEM, Unit.ORC},
//                env.getUnitsFromQueue(6))) {
//            // odd round from 5th
//            env.clickWhenMoraleDef(12, 3, Unit.THUNDERBIRD);
//            env.waitUnit();
//            env.delayUntilQueueInState(Unit.ORC);
//            env.clickWhenMoraleDef(9, 3, Unit.ORC);
//            env.delayUntilQueueInState(Unit.THUNDERBIRD);
//            // even round from 6th
//            env.clickWhenMoraleDef(0, 3, Unit.THUNDERBIRD);
//            env.delayUntilQueueInState(Unit.ORC);
//            env.waitUnit();
//            env.delayUntilQueueInState(Unit.ORC);
//            env.clickWhenMoraleDef(3, 3, Unit.ORC);
//            env.delayUntilQueueInState(Unit.THUNDERBIRD);
//        }
    }

    @Test
    public void fullScript() {
        begin();
        firstGolemKilling();
        regroupForFourStacks();
        secondGolemKilling();
        regroupForThreeStacks();
        thirdFourthGolemKilling();
        lastGolemKilling();
    }

    public void readLineNumbers() throws IOException {
        for (int i = 0; i < 10; i++) {
            BufferedImage image = env.makePicture(new Rectangle(new Point(497 + 40 * i, 760), new Dimension(30, 10)));
            ImageIO.write(image, "png", new File("/tmp/pictures/test" + i + ".png"));
        }
    }
}
