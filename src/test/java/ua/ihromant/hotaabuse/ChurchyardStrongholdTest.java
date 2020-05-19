package ua.ihromant.hotaabuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Point;

public class ChurchyardStrongholdTest {
    private Environment env;

    @BeforeEach
    private void init() throws AWTException {
        this.env = new Environment(new Point());
    }

    @Test
    public void testHovering() {
        env.clickWhenMoraleDef(7,
                0,
                AttackDirection.WEST, Unit.WOLF_RAIDER);
    }

    public void begin() {
        // 1 round
        env.clickWhenMoraleDef(13, 0, AttackDirection.SOUTH, Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(7, 9, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(8, 9, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(7, 8, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(7, 7, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(6, 7, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(6, 8, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        // 2 round
        env.waitUnit();
        env.clickWhenMoraleDef(6, 4, AttackDirection.CENTER, Unit.ZOMBIE);
        env.clickWhenMoraleDef(14, 6, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(13, 6, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(14, 7, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(14, 8, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(10, 4, AttackDirection.WEST, Unit.WOLF_RAIDER, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER, Unit.HOBGOBLIN);
        // 3 round
        env.clickWhenMoraleDef(1, 10, Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(10, 0, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(11, 1, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(11, 2, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(11, 0, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        // 4 round
        env.waitUnit();
        env.clickWhenMoraleDef(4, 0, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(5, 1, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(5, 0, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(14, 5, AttackDirection.CENTER, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(10, 5, AttackDirection.SOUTH, Unit.WOLF_RAIDER, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER, Unit.HOBGOBLIN);
        // 5 round
        env.clickWhenMoraleDef(10, 10, Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(3, 5, Unit.HOBGOBLIN, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(3, 6, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(2, 6, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        // 6 round
        env.waitUnit();
        env.clickWhenMoraleDef(6, 4, AttackDirection.CENTER, Unit.ZOMBIE);
        env.clickWhenMoraleDef(1, 9, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(1, 10, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(4, 8, AttackDirection.NORTH_EAST, Unit.WOLF_RAIDER, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER, Unit.HOBGOBLIN);
        // 7 round
        env.clickWhenMoraleDef(7, 0, Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(8, 10, Unit.HOBGOBLIN, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(9, 9, Unit.HOBGOBLIN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER, Unit.HOBGOBLIN);
        // 8 round
        env.waitUnit();
        env.clickWhenMoraleDef(6, 8, AttackDirection.CENTER, Unit.ZOMBIE);
        env.clickWhenMoraleDef(10, 3, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(8, 4, AttackDirection.SOUTH_WEST, Unit.WOLF_RAIDER, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.WOLF_RAIDER, Unit.HOBGOBLIN);
        // 9 round
        env.clickWhenMoraleDef(0, 10, Unit.WOLF_RAIDER);
        env.clickWhenMoraleDef(5, 0, Unit.HOBGOBLIN);
        // 10 round
        env.waitUnit();
        env.clickWhenMoraleDef(7, 1, AttackDirection.CENTER, Unit.HOBGOBLIN);
        env.clickWhenMoraleDef(5, 5, AttackDirection.CENTER, Unit.HOBGOBLIN);
    }

    @Test
    public void fullScript() {
        begin();
        // killFirstStackMelee();
    }
}
