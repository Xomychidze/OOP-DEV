package task4;

import java.util.Arrays;
import java.util.Date;

public class TestEmployee {

    public static void main(String[] args) {

        Date d2020 = new Date(120, 0, 15);   
        Date d2018 = new Date(118, 5, 1);    
        Date d2022 = new Date(122, 9, 20);   

        Employee alice = new Employee("Alice",  75_000, d2020, "NIN-001");
        Employee bob   = new Employee("Bob",    55_000, d2018, "NIN-002");
        Employee carol = new Employee("Carol",  90_000, d2022, "NIN-003");
        Employee dave  = new Employee("Dave",   55_000, d2018, "NIN-004");  

        Manager  zara  = new Manager("Zara",   120_000, d2020, "NIN-005", 15_000);
        Manager  omar  = new Manager("Omar",   120_000, d2022, "NIN-006", 25_000); 

        zara.addEmployee(alice);
        zara.addEmployee(bob);
        omar.addEmployee(carol);

        System.out.println(" Created Employees");
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(carol);
        System.out.println(dave);
        System.out.println(zara);
        System.out.println(omar);

        System.out.println("\n Comparable (salary)");
        System.out.println("alice > bob? " + (alice.compareTo(bob) > 0));     
        System.out.println("bob == dave? " + (bob.compareTo(dave) == 0));     
        System.out.println("zara vs omar (bonus)? " + (zara.compareTo(omar) < 0)); 

        Employee[] bysalary = {alice, bob, carol, dave, zara, omar};
        Arrays.sort(bysalary);
        System.out.println("\n=== Sorted by Salary (natural order) ===");
        for (Employee e : bysalary) System.out.println(e.getName() + " -> " + e.getAnnualSalary());

        Employee[] byname = {alice, bob, carol, dave, zara, omar};
        Arrays.sort(byname, Employee.BY_NAME);
        System.out.println("\n=== Sorted by Name ===");
        for (Employee e : byname) System.out.println(e.getName());

        Employee[] bydate = {alice, bob, carol, dave, zara, omar};
        Arrays.sort(bydate, Employee.BY_HIRE_DATE);
        System.out.println("\n=== Sorted by Hire Date ===");
        for (Employee e : bydate)
            System.out.printf("%-8s -> %tF%n", e.getName(), e.getHireDate());

        System.out.println("\n=== equals ===");
        Employee alice2 = new Employee("Alice", 75_000, d2020, "NIN-001");
        System.out.println("alice.equals(alice2): " + alice.equals(alice2));  
        System.out.println("alice.equals(bob):    " + alice.equals(bob));     
        System.out.println("zara.equals(omar):    " + zara.equals(omar));     

        System.out.println("\n=== Clone ===");
        Employee aliceClone = alice.clone();
        aliceClone.setName("Alice-Clone");
        aliceClone.setAnnualSalary(99_999);
        System.out.println("Original: " + alice);
        System.out.println("Clone:    " + aliceClone);

        Manager zaraClone = zara.clone();
        zaraClone.setName("Zara-Clone");
        zaraClone.addEmployee(dave);
        System.out.println("Original manager team size: " + zara.getTeam().size());   // 2
        System.out.println("Cloned manager team size:   " + zaraClone.getTeam().size()); // 3
    }
}
