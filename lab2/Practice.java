package lab2;

import java.util.Scanner;


public class Practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("My name is Nurik");
        System.out.println("Select task:");
        System.out.println("1 - Students");
        System.out.println("2 - Write triangle");
        System.out.println("3 - Time");
        System.out.print("Your choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> funcStudent(input);
            case 2 -> funcTriangle(input);
            case 3 -> funcTime(input);
            default -> System.out.println("Invalid choice!");
        }

        input.close();
    }

    static void funcStudent(Scanner input) {
        System.out.print("Write number: ");
        int studentId = input.nextInt();
        input.nextLine();
        System.out.print("Write name: ");
        String studentName = input.nextLine();

        Student nurik = new Student(studentId, studentName);

        System.out.println("\nBefore increment:");
        System.out.println(nurik);

        nurik.increaseYear();

        System.out.println("\nAfter increment:");
        System.out.println(nurik);
    }

    static void funcTriangle(Scanner input) {
        System.out.print("Write length of triangle: ");
        int lengthTriangle = input.nextInt();

        Triangle triangle = new Triangle(lengthTriangle);
        System.out.println();
        triangle.writeTriangle();
    }

    static void funcTime(Scanner input) {
        System.out.print("Write hour: ");
        int hour = input.nextInt();
        System.out.print("Write minute: ");
        int minute = input.nextInt();
        System.out.print("Write second: ");
        int second = input.nextInt();

        Time time = new Time(hour, minute, second);

        System.out.println("\nUniversal format:");
        System.out.println(time.toUniversal());

        System.out.println("\nStandard format:");
        System.out.println(time.toStandard());
    }
}


class Triangle {
    private int length;

    public Triangle(int l) {
        this.length = l;
    }

    public void writeTriangle() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("[*]");
            }
            System.out.println();
        }
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toUniversal() {
        String amPm = hour < 12 ? "AM" : "PM";
        int h = hour % 12;
        if (h == 0) h = 12;
        return String.format("%02d:%02d:%02d %s", h, minute, second, amPm);
    }

    public String toStandard() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
