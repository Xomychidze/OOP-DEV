package lab23.problem4;

abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }

    public double getPower() {
        double V = getPotentialDiff();
        return (V * V) / getResistance();
    }

    public void printInfo(String name) {
        System.out.printf("%-10s | R = %6.3f Ω | V = %6.3f V | I = %6.3f A | P = %6.3f W%n",
                name, getResistance(), getPotentialDiff(), getCurrent(), getPower());
    }
}

class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;

    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0.0;
    }

    @Override
    public double getResistance() { return resistance; }

    @Override
    public double getPotentialDiff() { return potentialDifference; }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }
}

class Series extends Circuit {
    private Circuit c1, c2;

    public Series(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        return c1.getResistance() + c2.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return c1.getPotentialDiff() + c2.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        double I = V / getResistance();
        c1.applyPotentialDiff(I * c1.getResistance());
        c2.applyPotentialDiff(I * c2.getResistance());
    }
}

class Parallel extends Circuit {
    private Circuit c1, c2;

    public Parallel(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        return 1.0 / (1.0 / c1.getResistance() + 1.0 / c2.getResistance());
    }

    @Override
    public double getPotentialDiff() {
        return c1.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        c1.applyPotentialDiff(V);
        c2.applyPotentialDiff(V);
    }
}

public class CircuitTest {
    public static void main(String[] args) {

        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c, d);
        Circuit h = new Series(g, e);
        Circuit circuit = new Parallel(h, f);

        double V = 12.0;
        circuit.applyPotentialDiff(V);

        System.out.println("══════════════════════════════════════════════════════════════════");
        System.out.printf("Applied voltage: %.1f V%n", V);
        System.out.printf("Equivalent resistance: %.3f Ω%n%n", circuit.getResistance());
        System.out.println("Component        | Resistance |  Voltage  |  Current  |   Power  ");
        System.out.println("──────────────────────────────────────────────────────────────────");

        a.printInfo("Resistor a");
        b.printInfo("Resistor b");
        c.printInfo("Resistor c");
        d.printInfo("Resistor d");
        e.printInfo("Resistor e");

        System.out.println("──────────────────────────────────────────────────────────────────");
        f.printInfo("Series f");
        g.printInfo("Parallel g");
        h.printInfo("Series h");
        circuit.printInfo("TOTAL");
        System.out.println("══════════════════════════════════════════════════════════════════");

        System.out.println("\n── Simple Series (4Ω + 6Ω = 10Ω) with 10V ──");
        Circuit r1 = new Resistor(4.0);
        Circuit r2 = new Resistor(6.0);
        Circuit series = new Series(r1, r2);
        series.applyPotentialDiff(10.0);
        r1.printInfo("R1 (4Ω)");
        r2.printInfo("R2 (6Ω)");
        series.printInfo("Total");

        System.out.println("\n── Simple Parallel (4Ω ∥ 6Ω = 2.4Ω) with 10V ──");
        Circuit r3 = new Resistor(4.0);
        Circuit r4 = new Resistor(6.0);
        Circuit parallel = new Parallel(r3, r4);
        parallel.applyPotentialDiff(10.0);
        r3.printInfo("R3 (4Ω)");
        r4.printInfo("R4 (6Ω)");
        parallel.printInfo("Total");
    }
}