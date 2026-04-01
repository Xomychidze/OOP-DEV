/**
 * TASK 2 — Demo: Moveable → Swimmable hierarchy + implementations
 *
 * Interface hierarchy:
 *   Moveable
 *     └── Swimmable       (extends Moveable — adds swim-specific methods)
 *
 * Implementing classes:
 *   Robot  → implements Moveable only
 *   Fish   → implements Swimmable (and therefore Moveable)
 *   Duck   → implements Swimmable AND Flyable  (multiple interfaces!)
 */
public class Task2Main {
    public static void main(String[] args) {

        Robot robot = new Robot("R2D2", 3.0);
        Fish  fish  = new Fish("Nemo", 1.5, 50);
        Duck  duck  = new Duck("Donald");

        // ── Each class in action ────────────────────────────────
        System.out.println("=== Robot (Moveable only) ===");
        robot.move();

        System.out.println("\n=== Fish (Swimmable extends Moveable) ===");
        fish.move();   // inherited from Moveable
        fish.swim();   // extra from Swimmable

        System.out.println("\n=== Duck (Swimmable + Flyable — multiple interfaces) ===");
        duck.move();   // from Moveable (via Swimmable)
        duck.swim();   // from Swimmable
        duck.fly();    // from Flyable

        // ── Polymorphism with Moveable reference ─────────────────
        System.out.println("\n=== Polymorphism: Moveable[] holds Robot, Fish, Duck ===");
        Moveable[] movers = { robot, fish, duck };
        for (Moveable m : movers) {
            System.out.printf("%-25s speed=%.1f m/s → ", m, m.getSpeed());
            m.move();
        }

        // ── Check if a Moveable can also swim ─────────────────────
        System.out.println("\n=== instanceof check ===");
        for (Moveable m : movers) {
            if (m instanceof Swimmable) {
                System.out.println(m + " can also SWIM.");
            }
            if (m instanceof Flyable) {
                System.out.println(m + " can also FLY.");
            }
        }
    }
}
