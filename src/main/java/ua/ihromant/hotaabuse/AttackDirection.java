package ua.ihromant.hotaabuse;

public enum AttackDirection {
    NORTH(0, -20), NORTH_EAST(16, -15), EAST(16, 0), SOUTH_EAST(16, 13),
    SOUTH(0, 20), SOUTH_WEST(-17, 13), WEST(-17, 0), NORTH_WEST(-17, -15),
    CENTER(0, 0);
    private final int xSwap;
    private final int ySwap;
    AttackDirection(int xSwap, int ySwap) {
        this.xSwap = xSwap;
        this.ySwap = ySwap;
    }

    public int getxSwap() {
        return xSwap;
    }

    public int getySwap() {
        return ySwap;
    }
}
