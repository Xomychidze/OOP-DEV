/**
 * TASK 1 — Demo: Interface vs Abstract Class
 *
 * ┌──────────────────────────────────────────────────────────────┐
 * │           ABSTRACT CLASS vs INTERFACE — Summary              │
 * ├─────────────────────┬────────────────────────────────────────┤
 * │  Abstract Class     │  Interface                             │
 * ├─────────────────────┼────────────────────────────────────────┤
 * │  Can have fields    │  Only constants (public static final)  │
 * │  Can have code      │  Only abstract methods (Java 7)        │
 * │  Single inheritance │  Multiple implementation allowed       │
 * │  "is-a"             │  "can-do" / "has-a-capability"         │
 * │  Constructor OK     │  No constructors                       │
 * ├─────────────────────┼────────────────────────────────────────┤
 * │ Use when classes    │ Use when UNRELATED classes need the    │
 * │ share STATE (fields)│ same CONTRACT (set of methods)         │
 * │ and CODE            │                                        │
 * └─────────────────────┴────────────────────────────────────────┘
 */
public class Task1Main {
    public static void main(String[] args) {

        // ── Abstract Class example ──────────────────────────────
        System.out.println("=== Abstract Class: AbstractVehicle ===");
        System.out.println("Car and Plane share brand/year fields and displayInfo() code.");
        System.out.println("They cannot exist without implementing startEngine().\n");

        Car car = new Car("Toyota", 2022, 4);
        car.startEngine();
        car.displayInfo();

        Plane plane = new Plane("Boeing 737", 2020, 12000);
        plane.startEngine();
        plane.displayInfo();

        // ── Interface example ───────────────────────────────────
        System.out.println("\n=== Interface: Flyable ===");
        System.out.println("Bird and Plane are UNRELATED classes, yet both can fly.");
        System.out.println("Flyable is a shared contract, not shared code.\n");

        // Polymorphism: treat completely different objects the same way
        Flyable[] flyers = { plane, new Bird("Eagle", 1000) };
        for (Flyable f : flyers) {
            f.fly();
            System.out.println("  → Max altitude: " + f.getMaxAltitude() + "m");
        }

        // ── Combined: abstract class + interface ─────────────────
        System.out.println("\n=== Plane does BOTH ===");
        System.out.println("Plane extends AbstractVehicle AND implements Flyable.");
        System.out.println("This is the key advantage: you can only extend ONE class,");
        System.out.println("but you can implement MANY interfaces.\n");

        plane.displayInfo();   // from AbstractVehicle
        plane.fly();           // from Flyable
    }
}
