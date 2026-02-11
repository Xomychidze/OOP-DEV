package lab3;

import java.util.Scanner;

public class Analyzer {
    public static void main(Scanner input) {
        Data data = new Data(); 
        System.out.println("Hello, Nurik!");
        System.out.println("It's first problem");
        System.out.println("You should write number for starting");
        System.out.println("If you want to exit then write Q");
        
        while (true){ 
            System.out.println("Enter number (Q to quit):");
            String number = input.next();

            if("Q".equals(number)){
                break; 
            }
            try {
                double num = Double.parseDouble(number); 
                data.addNumber(num); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or Q to quit.");
                }   
        }


        System.out.printf("AVG: %.2f%n", data.avgData());
        System.out.printf("MAX: %.2f%n", data.getMaxNumber());

    }    
}

class  Data { 
    private int cnt; 
    private double sumNumber; 
    private double maxNumber; 

    public Data() {
        this.cnt = 0;
        this.sumNumber = 0.0; 
    }

    public void addNumber(double num){ 
        this.sumNumber += num; 
               
        if(this.maxNumber < num && this.cnt > 1 ) this.maxNumber = num; 
        else if (this.cnt == 0) this.maxNumber = num;
        
        this.cnt += 1; 
    }

    public double avgData(){
        if(this.cnt == 0) return 0; 
        else return this.sumNumber / this.cnt;  
    }

    public double getMaxNumber(){
        return this.maxNumber; 
    }


    
}