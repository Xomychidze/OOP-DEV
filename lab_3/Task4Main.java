import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * TASK 4 — Full test of Person → Employee → Manager hierarchy
 */
public class Task4Main {
    public static void main(String[] args) {

        // ── Setup ────────────────────────────────────────────────
        Date d2019 = new GregorianCalendar(2019, 5,  1).getTime();
        Date d2020 = new GregorianCalendar(2020, 0, 15).getTime();
        Date d2021 = new GregorianCalendar(2021, 11, 1).getTime();

        Employee alice   = new Employee("Alice",   30, 60_000, d2020, "INS-001");
        Employee bob     = new Employee("Bob",     25, 45_000, d2019, "INS-002");
        Employee charlie = new Employee("Charlie", 35, 75_000, d2021, "INS-003");

        Manager diana = new Manager("Diana", 40, 90_000, d2020, "MGR-001", 15_000);
        Manager eve   = new Manager("Eve",   45, 90_000, d2019, "MGR-002", 20_000);

        diana.addEmployee(alice);
        diana.addEmployee(bob);

        // ── toString ─────────────────────────────────────────────
        System.out.println("=== toString ===");
        System.out.println(alice);
        System.out.println(charlie);
        System.out.println(diana);

        // ── equals ───────────────────────────────────────────────
        System.out.println("\n=== equals ===");
        Employee aliceCopy = new Employee("Alice", 30, 99_999, d2021, "INS-001");
        System.out.println("alice.equals(aliceCopy) [same name+ins]: " + alice.equals(aliceCopy)); // true
        System.out.println("alice.equals(bob)       [different]:      " + alice.equals(bob));      // false
        System.out.println("diana.equals(eve)       [diff managers]:  " + diana.equals(eve));      // false

        // ── Comparable — sort by salary (natural order) ───────────
        System.out.println("\n=== Comparable: sort by salary ===");
        Employee[] staff = { charlie, alice, bob };
        Arrays.sort(staff);
        for (Employee e : staff) {
            System.out.println("  " + e.getName() + " → $" + e.getSalary());
        }

        // ── Comparator: sort by name ─────────────────────────────
        System.out.println("\n=== Comparator: sort by name ===");
        Arrays.sort(staff, new NameComparator());
        for (Employee e : staff) {
            System.out.println("  " + e.getName());
        }

        // ── Comparator: sort by hire date ────────────────────────
        System.out.println("\n=== Comparator: sort by hire date ===");
        Arrays.sort(staff, new HireDateComparator());
        for (Employee e : staff) {
            System.out.println("  " + e.getName() + " → hired " + e.getHireDate());
        }

        // ── Manager compareTo (same salary → compare by bonus) ───
        System.out.println("\n=== Manager compareTo (equal salary, diff bonus) ===");
        int cmp = diana.compareTo(eve);
        System.out.println("diana vs eve: " + (cmp < 0 ? "diana < eve" : cmp > 0 ? "diana > eve" : "equal"));
        // diana bonus=15000, eve bonus=20000 → diana < eve

        // ── clone ────────────────────────────────────────────────
        System.out.println("\n=== clone ===");
        Employee aliceClone = alice.clone();
        System.out.println("Original: " + alice);
        System.out.println("Clone:    " + aliceClone);
        System.out.println("Same object? " + (alice == aliceClone));          // false
        System.out.println("Equal?        " + alice.equals(aliceClone));      // true
        // Prove deep clone of Date:
        alice.getHireDate().setTime(0); // modify original's date
        System.out.println("After modifying original's hireDate:");
        System.out.println("  Original date: " + alice.getHireDate());
        System.out.println("  Clone date:    " + aliceClone.getHireDate()); // unchanged

        Manager dianaClone = diana.clone();
        System.out.println("Manager clone team size: " + dianaClone.getTeamSize()); // 2

        // ── Describable & Identifiable ────────────────────────────
        System.out.println("\n=== Describable & Identifiable ===");
        System.out.println(alice.describe());
        System.out.println("ID: " + alice.getId());
        System.out.println(diana.describe());
        System.out.println("ID: " + diana.getId());
    }
}
