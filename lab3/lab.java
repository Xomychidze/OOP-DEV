package lab3;  
import java.util.Scanner; 

public class lab{ 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, Nurik!");
        System.out.println("It's programm for lab1 when you can get 5 points");
        System.out.println("Select problem:");
        System.out.println("1  - Problem");
        System.out.println("2  - Problem");
        System.out.println("3  - Problem");
        System.out.println("4  - Problem");
        System.out.println("5  - Problem");
        System.out.print("Your choice: ");
        
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> Analyzer.main(input);
            case 2 -> ownClass.clientCreate(input);
            case 3 -> Temperature.lookTemp();
            case 4 -> GradebookApp.gradeStart();
            case 5 -> DragonLaunch.dragonSimulation();
            default -> System.out.println("Invalid choice!");
        }

        input.close();
    }    
}