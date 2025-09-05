package jolt9001.causalchaos.actions.base_impl.dash.dashstrike;

public class DashData implements IDashData {
    private int dashTicks, strikeWindow;
    private boolean dashing;

    @Override
    public int getDashTicks() {
        return dashTicks;
    }

    @Override
    public void setDashTicks(int v) {
        dashTicks = v;
    }

    @Override
    public int getStrikeWindow() {
        return strikeWindow;
    }

    @Override
    public void setStrikeWindow(int v) {
        strikeWindow = v;
    }

    @Override
    public boolean isDashing() { return dashing; }

    @Override
    public void setDashing(boolean v) { dashing = v; }
}
