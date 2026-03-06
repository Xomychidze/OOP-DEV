public class Employees extends Persons {

    private String employeeId;
    private String department;

    public Employees(String name, int age, String employeeId, String department) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;

        Employees e = (Employees) o;
        return employeeId.equals(e.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId.hashCode();
    }

    @Override
    public String toString() {
        return getName() + " id:" + employeeId + " dept:" + department;
    }


}