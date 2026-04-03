package task4;

import java.util.Comparator;
import java.util.Date;

public class Employee extends Person implements Comparable<Employee>, Cloneable {

    private double annualSalary;
    private Date   hireDate;
    private String nationalInsuranceNumber;


    public Employee(String name, double annualSalary, Date hireDate, String nin) {
        super(name);
        this.annualSalary           = annualSalary;
        this.hireDate               = new Date(hireDate.getTime()); // defensive copy
        this.nationalInsuranceNumber = nin;
    }

    public Employee(String name, double annualSalary) {
        this(name, annualSalary, new Date(), "N/A");
    }

    // Copy constructor
    public Employee(Employee other) {
        super(other.getName());
        this.annualSalary           = other.annualSalary;
        this.hireDate               = new Date(other.hireDate.getTime());
        this.nationalInsuranceNumber = other.nationalInsuranceNumber;
    }


    public double getAnnualSalary()            { return annualSalary; }
    public void   setAnnualSalary(double s)    { this.annualSalary = s; }

    public Date   getHireDate()                { return new Date(hireDate.getTime()); }
    public void   setHireDate(Date d)          { this.hireDate = new Date(d.getTime()); }

    public String getNationalInsuranceNumber() { return nationalInsuranceNumber; }
    public void   setNationalInsuranceNumber(String n) { this.nationalInsuranceNumber = n; }


    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.annualSalary, other.annualSalary);
    }


    /** Sort by name alphabetically */
    public static final Comparator<Employee> BY_NAME =
            Comparator.comparing(Person::getName);

    /** Sort by hire date (earliest first) */
    public static final Comparator<Employee> BY_HIRE_DATE =
            Comparator.comparing(Employee::getHireDate);


    @Override
    public String toString() {
        return String.format("Employee{name='%s', salary=%.2f, hireDate=%tF, nin='%s'}",
                getName(), annualSalary, hireDate, nationalInsuranceNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return Double.compare(annualSalary, e.annualSalary) == 0
                && nationalInsuranceNumber.equals(e.nationalInsuranceNumber);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + nationalInsuranceNumber.hashCode();
    }


    @Override
    public Employee clone() {
        Employee copy = (Employee) super.clone();
        copy.hireDate = new Date(this.hireDate.getTime()); // deep copy of mutable Date
        return copy;
    }
}
