package task4;

import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {

    private Vector<Employee> team;
    private double bonus;


    public Manager(String name, double salary, Date hireDate, String nin, double bonus) {
        super(name, salary, hireDate, nin);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }


    public void addEmployee(Employee e)    { team.add(e); }
    public void removeEmployee(Employee e) { team.remove(e); }
    public Vector<Employee> getTeam()      { return team; }

    public double getBonus() { return bonus; }
    public void   setBonus(double b) { this.bonus = b; }


    @Override
    public int compareTo(Employee other) {
        int cmp = super.compareTo(other);
        if (cmp != 0) return cmp;
        // salaries are equal — compare by bonus if other is also a Manager
        if (other instanceof Manager) {
            return Double.compare(this.bonus, ((Manager) other).bonus);
        }
        return cmp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Manager{name='%s', salary=%.2f, bonus=%.2f, teamSize=%d",
                getName(), getAnnualSalary(), bonus, team.size()));
        if (!team.isEmpty()) {
            sb.append(", team=[");
            for (int i = 0; i < team.size(); i++) {
                sb.append(team.get(i).getName());
                if (i < team.size() - 1) sb.append(", ");
            }
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Manager)) return false;
        return Double.compare(bonus, ((Manager) o).bonus) == 0;
    }


    @Override
    public Manager clone() {
        Manager copy = (Manager) super.clone();
        // Deep copy of Vector — clone each employee
        copy.team = new Vector<>();
        for (Employee e : this.team) {
            copy.team.add(e.clone());
        }
        return copy;
    }
}
