public abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double v);

    public double getCurrent() {
        double resistance = getResistance();
        if (resistance == 0) return 0;
        return getPotentialDiff() / resistance;
    }

    public double getPower() {
        double v = getPotentialDiff();
        double resistance = getResistance();
        if (resistance == 0) return 0;
        return (v * v) / resistance;
    }
}
