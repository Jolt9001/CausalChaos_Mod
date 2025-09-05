package jolt9001.causalchaos.actions.base_impl.dash.dashstrike;

public class DashData implements IDashData {
    private boolean dashing;

    @Override
    public boolean isDashing() { return dashing; }

    @Override
    public void setDashing(boolean value) { dashing = value; }
}
