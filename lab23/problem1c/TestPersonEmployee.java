import java.util.HashSet;
import java.util.Set;

public class TestPersonEmployee {
    public static void main(String[] args) {
        System.out.println("=== Testing Person with HashSet ===");
        Set<Persons> people = new HashSet<>();
        Persons p1 = new Persons("Alice", 30);
        Persons p2 = new Persons("Bob", 25);
        Persons p3 = new Persons("Alice", 30); 

        people.add(p1);
        people.add(p2);
        people.add(p3); 

        System.out.println("People in set (expected 2): " + people.size());
        for (Persons p : people) {
            System.out.println("  " + p);
        }

        System.out.println("\n=== Testing Employee with HashSet ===");
        Set<Employees> employees = new HashSet<>();
        Employees e1 = new Employees("John", 40, "E001", "Engineering");
        Employees e2 = new Employees("Sara", 35, "E002", "Marketing");
        Employees e3 = new Employees("Different Name", 99, "E001", "HR"); // same ID as e1 -> duplicate

        employees.add(e1);
        employees.add(e2);
        employees.add(e3); // should not be added (same employeeId)

        System.out.println("Employees in set (expected 2): " + employees.size());
        for (Employees e : employees) {
            System.out.println("  " + e);
        }

        System.out.println("\n=== equals() checks ===");
        System.out.println("p1.equals(p3): " + p1.equals(p3));   // true
        System.out.println("p1.equals(p2): " + p1.equals(p2));   // false
        System.out.println("e1.equals(e3): " + e1.equals(e3));   // true (same id)
        System.out.println("e1.equals(e2): " + e1.equals(e2));   // false
    }
}
