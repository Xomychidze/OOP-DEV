import java.util.Comparator;

public class HireDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee a, Employee b) {
        return a.getHireDate().compareTo(b.getHireDate());
    }
}
