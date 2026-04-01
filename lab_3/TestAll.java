import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * TASK 6 — Master test class
 *
 * Tests:
 *   - Sort with Chocolates  (Task 5)
 *   - Sort with Times       (Task 5)
 *   - Sort with Employees   (Tasks 4 & 5)
 *   - Person: Cloneable, Serializable, Describable, Identifiable  (Task 6)
 *   - Animal: Comparable, Cloneable, Describable, Identifiable    (Task 6)
 */
public class TestAll {

    // ─────────────────────────────────────────────────────────────
    //  Helper: print a section title
    // ─────────────────────────────────────────────────────────────
    static void title(String t) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("  " + t);
        System.out.println("═".repeat(50));
    }

    public static void main(String[] args) {

        // ══════════════════════════════════════════════════════════
        //  TASK 5: Sort — Chocolates
        // ══════════════════════════════════════════════════════════
        title("TASK 5 — Sort Chocolates (by weight, Bubble Sort)");

        Chocolate[] chocolates = {
            new Chocolate("Twix",    58.0),
            new Chocolate("KitKat", 45.0),
            new Chocolate("Snickers",52.7),
            new Chocolate("Bounty",  57.0),
            new Chocolate("Milka",   100.0)
        };
        System.out.print("Before: "); Sort.printArray(chocolates);
        Sort.bubbleSort(chocolates);
        System.out.print("After:  "); Sort.printArray(chocolates);

        // ══════════════════════════════════════════════════════════
        //  TASK 5: Sort — Times
        // ══════════════════════════════════════════════════════════
        title("TASK 5 — Sort Times (Selection Sort)");

        Time[] times = {
            new Time(14, 30,  0),
            new Time( 9, 15, 45),
            new Time(23,  0,  1),
            new Time( 9, 15, 30),
            new Time( 0,  0,  0)
        };
        System.out.print("Before: "); Sort.printArray(times);
        Sort.selectionSort(times);
        System.out.print("After:  "); Sort.printArray(times);

        // ══════════════════════════════════════════════════════════
        //  TASK 5: Sort — Employees (by salary)
        // ══════════════════════════════════════════════════════════
        title("TASK 5 — Sort Employees (by salary, Bubble Sort)");

        Date d1 = new GregorianCalendar(2020, 0,  1).getTime();
        Date d2 = new GregorianCalendar(2019, 5,  1).getTime();
        Date d3 = new GregorianCalendar(2021, 11, 1).getTime();

        Employee[] employees = {
            new Employee("Zara",  28, 70_000, d1, "INS-010"),
            new Employee("Alice", 30, 50_000, d2, "INS-011"),
            new Employee("Bob",   25, 85_000, d3, "INS-012")
        };
        System.out.print("Before: "); Sort.printArray(employees);
        Sort.bubbleSort(employees);
        System.out.print("After:  "); Sort.printArray(employees);

        // Also test with Arrays.sort using NameComparator
        System.out.println("\nSame array sorted by name (Arrays.sort + NameComparator):");
        Arrays.sort(employees, new NameComparator());
        Sort.printArray(employees);

        // ══════════════════════════════════════════════════════════
        //  TASK 6: Person — improved with 4 interfaces
        // ══════════════════════════════════════════════════════════
        title("TASK 6 — Person (Cloneable + Serializable + Describable + Identifiable)");

        Person p1 = new Person("Nurmukhamed", 20);
        Person p2 = new Person("Aizat", 21);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        // Describable
        System.out.println("\ndescribe():");
        System.out.println("  " + p1.describe());
        System.out.println("  " + p2.describe());

        // Identifiable
        System.out.println("\ngetId():");
        System.out.println("  " + p1.getId());
        System.out.println("  " + p2.getId());

        // Cloneable
        Person p1clone = p1.clone();
        System.out.println("\nClone of p1: " + p1clone);
        System.out.println("Same object? " + (p1 == p1clone));
        System.out.println("Equal?       " + p1.equals(p1clone));

        // equals
        System.out.println("\np1.equals(p2): " + p1.equals(p2));

        // ══════════════════════════════════════════════════════════
        //  TASK 6: Animal (Pet) — improved with 4 interfaces
        // ══════════════════════════════════════════════════════════
        title("TASK 6 — Animal/Pet (Comparable + Cloneable + Describable + Identifiable)");

        Animal cat  = new Animal("Whiskers", "Cat",  4);
        Animal dog  = new Animal("Buddy",    "Dog",  2);
        Animal fish = new Animal("Goldie",   "Fish", 1);

        // Describable & Identifiable
        System.out.println("describe(): " + cat.describe());
        System.out.println("getId():    " + cat.getId());

        // Comparable — sort animals by name
        Animal[] pets = { cat, dog, fish };
        System.out.println("\nPets before sort: "); Sort.printArray(pets);
        Sort.selectionSort(pets); // works because Animal implements Comparable<Animal>
        System.out.println("Pets after sort (by name alphabetically):");
        Sort.printArray(pets);

        // Cloneable
        Animal catClone = cat.clone();
        System.out.println("\nClone of cat: " + catClone);
        System.out.println("Same object? " + (cat == catClone));
        System.out.println("Equal?       " + cat.equals(catClone));

        System.out.println("\n✓ All tests passed!");
    }
}
