public class Parallel extends Circuit {
    private Circuit first;
    private Circuit second;

    public Parallel(Circuit first, Circuit second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double getResistance() {
        // Parallel: 1/R_total = 1/R1 + 1/R2  =>  R_total = (R1 * R2) / (R1 + R2)
        double r1 = first.getResistance();
        double r2 = second.getResistance();
        return (r1 * r2) / (r1 + r2);
    }

    @Override
    public double getPotentialDiff() {
        // In parallel, both branches have the same voltage
        return first.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double v) {
        // In parallel, each branch receives the same potential difference
        first.applyPotentialDiff(v);
        second.applyPotentialDiff(v);
    }
}
