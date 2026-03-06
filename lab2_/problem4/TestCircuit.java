public class TestCircuit {
    public static void main(String[] args) {
        System.out.println("=== Electrical Circuit System ===\n");

        // Build the circuit from the lab example (Figure 1)
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);         // a + b = 6 Ohm
        Circuit g = new Parallel(c, d);       // c || d = 2 Ohm
        Circuit h = new Series(g, e);         // g + e = 4 Ohm
        Circuit circuit = new Parallel(h, f); // h || f = 2.4 Ohm

        System.out.printf("Equivalent Resistance: %.4f Ohm%n", circuit.getResistance());
        // Expected: 12/5 = 2.4 Ohm

        // Apply 12V across the whole circuit
        double voltage = 12.0;
        circuit.applyPotentialDiff(voltage);

        System.out.printf("Applied Voltage: %.1f V%n", voltage);
        System.out.printf("Total Current:   %.4f A%n", circuit.getCurrent());
        System.out.printf("Total Power:     %.4f W%n", circuit.getPower());

        System.out.println("\n--- Simple series circuit (2 resistors, 10V) ---");
        Circuit r1 = new Resistor(4.0);
        Circuit r2 = new Resistor(6.0);
        Circuit seriesCircuit = new Series(r1, r2);
        seriesCircuit.applyPotentialDiff(10.0);
        System.out.printf("Resistance: %.1f Ohm%n", seriesCircuit.getResistance()); // 10 Ohm
        System.out.printf("Current:    %.2f A%n", seriesCircuit.getCurrent());       // 1.0 A
        System.out.printf("Power:      %.2f W%n", seriesCircuit.getPower());          // 10.0 W

        System.out.println("\n--- Simple parallel circuit (2 resistors, 6V) ---");
        Circuit r3 = new Resistor(6.0);
        Circuit r4 = new Resistor(3.0);
        Circuit parallelCircuit = new Parallel(r3, r4);
        parallelCircuit.applyPotentialDiff(6.0);
        System.out.printf("Resistance: %.1f Ohm%n", parallelCircuit.getResistance()); // 2.0 Ohm
        System.out.printf("Current:    %.2f A%n", parallelCircuit.getCurrent());       // 3.0 A
        System.out.printf("Power:      %.2f W%n", parallelCircuit.getPower());          // 18.0 W
    }
}
