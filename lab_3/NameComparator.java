import java.util.Comparator;

/**
 * TASK 4 — Comparator #1: sort employees by name (alphabetically)
 */
public class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee a, Employee b) {
        return a.getName().compareTo(b.getName());
    }
}
