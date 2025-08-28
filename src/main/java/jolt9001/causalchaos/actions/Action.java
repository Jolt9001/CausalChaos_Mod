package jolt9001.causalchaos.actions;

public abstract class Action {
    private boolean doing = false;
    private int doingTick = 0;
    private int notDoingTick = 0;

    public void setDoingTick(int doingTick) {
        this.doingTick = doingTick;
    }

    public void setNotDoingTick(int notDoingTick) {
        this.notDoingTick = notDoingTick;
    }

    public int getDoingTick() {
        return doingTick;
    }

    public int getNotDoingTick() {
        return notDoingTick;
    }
    public boolean isDoing() {
        return doing;
    }
    public void setDoing(boolean value) {
        doing = value;
    }
}
