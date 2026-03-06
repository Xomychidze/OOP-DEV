package problem1c;
import java.util.HashSet;
import java.util.Set;

public class TestPersonEmployee {
    public static void main(String[] args) {
        System.out.println("=== Testing Person with HashSet ===");
        Set<Person> people = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);
        Person p3 = new Person("Alice", 30); 

        people.add(p1);
        people.add(p2);
        people.add(p3); 

        System.out.println("People in set (expected 2): " + people.size());
        for (Person p : people) {
            System.out.println("  " + p);
        }

        System.out.println("\n=== Testing Employee with HashSet ===");
        Set<Employee> employees = new HashSet<>();
        Employee e1 = new Employee("John", 40, "E001", "Engineering");
        Employee e2 = new Employee("Sara", 35, "E002", "Marketing");
        Employee e3 = new Employee("Different Name", 99, "E001", "HR"); // same ID as e1 -> duplicate

        employees.add(e1);
        employees.add(e2);
        employees.add(e3); // should not be added (same employeeId)

        System.out.println("Employees in set (expected 2): " + employees.size());
        for (Employee e : employees) {
            System.out.println("  " + e);
        }

        System.out.println("\n=== equals() checks ===");
        System.out.println("p1.equals(p3): " + p1.equals(p3));   // true
        System.out.println("p1.equals(p2): " + p1.equals(p2));   // false
        System.out.println("e1.equals(e3): " + e1.equals(e3));   // true (same id)
        System.out.println("e1.equals(e2): " + e1.equals(e2));   // false
    }
}
