public class Series extends Circuit {
    private Circuit first;
    private Circuit second;

    public Series(Circuit first, Circuit second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double getResistance() {
        // Series: R_total = R1 + R2
        return first.getResistance() + second.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return first.getPotentialDiff() + second.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double v) {
        // In series, current is the same: I = V / R_total
        // Each component's voltage: V_i = I * R_i
        double totalR = getResistance();
        double current = v / totalR;
        first.applyPotentialDiff(current * first.getResistance());
        second.applyPotentialDiff(current * second.getResistance());
    }
}
