package ua.ihromant.hotaabuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Point;

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
        env.delayUntilQueueInState(Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.STEEL_GOLEM);
        env.clickWhenMoraleDef(4, 4, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.HOBGOBLIN, Unit.STEEL_GOLEM);
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
//        env.cast(0, 0, 0);
//        env.clickWhenMoraleDef(12, 2, Unit.THUNDERBIRD);
//        env.clickWhenMoraleDef(10, 10, Unit.ORC);
//        env.clickWhenMoraleDef(9, 1, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
//        env.clickWhenMoraleDef(9, 0, Unit.HOBGOBLIN);
//        env.delayUntilQueueInState(Unit.THUNDERBIRD);
//        // 4 round
    }

    @Test
    public void fullScript() {
        begin();
        // killFirstStackMelee();
    }
}
