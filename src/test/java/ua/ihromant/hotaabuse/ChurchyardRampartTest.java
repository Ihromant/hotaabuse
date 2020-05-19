package ua.ihromant.hotaabuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Point;

public class ChurchyardRampartTest {
    private Environment env;

    @BeforeEach
    private void init() throws AWTException {
        this.env = new Environment(new Point());
    }

    @Test
    public void findSpecAttack() {
        env.directClick(1125, 730);
        // book env.directClick(1150, 730);
    }

    public void begin() {
        // 1 round
        env.click(-6, 0);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.CENTAUR, Unit.CENTAUR, Unit.CENTAUR);
        env.clickWhenMoraleDef(8, 1, Unit.CENTAUR, Unit.CENTAUR, Unit.CENTAUR);
        env.clickWhenMoraleDef(8, 9, Unit.CENTAUR, Unit.CENTAUR);
        env.clickWhenMoraleDef(6, 10, Unit.CENTAUR);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(0, 7, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 2 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(0, 0, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 3 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(8, 0, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 4 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(12, 0, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 5 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(14, 4, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 6 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(9, 10, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 7 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(1, 10, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 8 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(7, 9, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 9 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(0, 3, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 10 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(6, 0, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 11 round
        env.clickWhenMoraleDef(14, 0, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 12 round
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.clickWhenMoraleDef(7, 1, Unit.GRAND_ELF, Unit.UNKNOWN);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 13 round
        env.clickWhenMoraleDef(14, 6, Unit.GRAND_ELF, Unit.ZOMBIE);
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        // 14 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.clickWhenMoraleDef(8, 10, Unit.GRAND_ELF, Unit.ZOMBIE);
        // 15 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.clickWhenMoraleDef(0, 10, Unit.GRAND_ELF, Unit.ZOMBIE);
        // 16 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.clickWhenMoraleDef(0, 3, Unit.GRAND_ELF, Unit.ZOMBIE);
        // 17 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.clickWhenMoraleDef(6, 0, Unit.GRAND_ELF, Unit.ZOMBIE);
        // 18 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.clickWhenMoraleDef(14, 0, Unit.GRAND_ELF, Unit.ZOMBIE);
        // 19 round
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
        env.waitUnit();
        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
        env.specificClickWhenMoraleDef(7, 2, AttackDirection.NORTH, Unit.GRAND_ELF, Unit.UNKNOWN);
        // 20 round
//        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
//        env.clickWhenMoraleDel(14, 4);
//        // 21 round
//        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
//        env.clickWhenMoraleDel(9, 10);
//        // 22 roundwd
//        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
//        env.clickWhenMoraleDel(1, 10);
//        // 23 round
//        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.ZOMBIE);
//        env.waitUnit();
//        env.delayUntilQueueInState(Unit.GRAND_ELF, Unit.UNKNOWN);
//        env.specificClickWhenMoraleDel(4, 9, Unit.GRAND_ELF, Unit.UNKNOWN);
    }

    public void killFirstStackMelee() {

    }

    @Test
    public void fullScript() {
        begin();
        // killFirstStackMelee();
    }
}
