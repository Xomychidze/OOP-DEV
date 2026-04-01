import java.util.Date;

public class Employee extends Person implements Comparable<Employee> {
    private double salary;
    private Date   hireDate;
    private String insuranceNumber;

    // Full constructor
    public Employee(String name, int age, double salary, Date hireDate, String insuranceNumber) {
        super(name, age);
        this.salary          = salary;
        this.hireDate        = hireDate;
        this.insuranceNumber = insuranceNumber;
    }

    // Convenience constructor (today's date, placeholder insurance)
    public Employee(String name, int age, double salary) {
        this(name, age, salary, new Date(), "INS-000");
    }

    // --- Getters / Setters ---
    public double getSalary()          { return salary; }
    public Date   getHireDate()        { return hireDate; }
    public String getInsuranceNumber() { return insuranceNumber; }
    public void   setSalary(double s)  { this.salary = s; }

    // --- Override toString ---
    @Override
    public String toString() {
        return "Employee[name=" + getName()
                + ", salary=$" + salary
                + ", hired=" + hireDate
                + ", ins=" + insuranceNumber + "]";
    }

    // --- Override equals: same name + same insurance = same employee ---
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return getName().equals(e.getName())
                && insuranceNumber.equals(e.insuranceNumber);
    }

    // --- Comparable<Employee>: higher salary = "greater" employee ---
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    // --- Deep clone: Date is mutable, so we copy it ---
    @Override
    public Employee clone() {
        Employee copy = (Employee) super.clone(); // Person.clone() handles super
        copy.hireDate = new Date(this.hireDate.getTime()); // deep copy
        return copy;
    }

    // --- Describable ---
    @Override
    public String describe() {
        return "Employee " + getName() + " earns $" + salary + "/year.";
    }

    // --- Identifiable: insurance number is the unique ID ---
    @Override
    public String getId() {
        return insuranceNumber;
    }
}
