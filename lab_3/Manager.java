import java.util.Date;
import java.util.Vector;


public class Manager extends Employee {
    private Vector<Employee> team;
    private double bonus;

    // Full constructor
    public Manager(String name, int age, double salary, Date hireDate,
                   String insuranceNumber, double bonus) {
        super(name, age, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }

    // Convenience constructor
    public Manager(String name, int age, double salary, double bonus) {
        this(name, age, salary, new Date(), "MGR-000", bonus);
    }

    // --- Team management ---
    public void addEmployee(Employee e) { team.add(e); }
    public void removeEmployee(Employee e) { team.remove(e); }
    public Vector<Employee> getTeam() { return team; }
    public int getTeamSize()          { return team.size(); }

    // --- Bonus ---
    public double getBonus()          { return bonus; }
    public void setBonus(double b)    { this.bonus = b; }

    // --- Override toString ---
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manager[name=").append(getName())
          .append(", salary=$").append(getSalary())
          .append(", bonus=$").append(bonus)
          .append(", teamSize=").append(team.size())
          .append(", ins=").append(getInsuranceNumber()).append("]");
        return sb.toString();
    }

    // --- Override equals ---
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        Manager m = (Manager) obj;
        return super.equals(m) && Double.compare(this.bonus, m.bonus) == 0;
    }

    // --- Override compareTo: salary first, then bonus if both are managers ---
    @Override
    public int compareTo(Employee other) {
        int cmp = Double.compare(this.getSalary(), other.getSalary());
        if (cmp != 0) return cmp;
        // Same salary: compare by bonus only if the other is also a Manager
        if (other instanceof Manager) {
            return Double.compare(this.bonus, ((Manager) other).bonus);
        }
        return 0;
    }

    // --- Clone: shallow copy of team Vector ---
    @Override
    public Manager clone() {
        Manager copy = (Manager) super.clone(); // deep-clones hireDate (via Employee.clone)
        copy.team = new Vector<>(this.team);    // new Vector, same Employee references
        return copy;
    }

    // --- Describable ---
    @Override
    public String describe() {
        return "Manager " + getName() + " leads " + team.size()
                + " employee(s) and earns $" + getSalary()
                + " + $" + bonus + " bonus.";
    }
}
