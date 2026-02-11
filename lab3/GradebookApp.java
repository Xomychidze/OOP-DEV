package lab3;

import java.util.*;

public class GradebookApp {
    public static void gradeStart() {
        Course course = new Course("Data Structures");
        Gradebook gradebook = new Gradebook(course);
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student("Student" + i, "desc", 3, "pic.png"));
        }
        Random rand = new Random();
        for (Student s : students) {
            List<Double> grades = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                grades.add(50.0 + rand.nextInt(51));
            }
            gradebook.put(s, grades);
        }
        gradebook.averageTestGrades();
    }
}

class Student {
    private String name;
    private String description;
    private int credits;
    private String pictureFile;

    public Student(String name, String description, int credits, String pictureFile) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.pictureFile = pictureFile;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}

class Course {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}

class Gradebook extends HashMap<Student, List<Double>> {
    private Course course;

    public Gradebook() {}

    public Gradebook(Course course) {
        this.course = course;
    }

    public void displayCreditHours() {
        System.out.println("displayCreditHours not implemented");
    }

    public void averageTestGrades() {
        int highGrades = 0;
        for (Map.Entry<Student, List<Double>> entry : this.entrySet()) {
            List<Double> grades = entry.getValue();
            double avg = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            System.out.println(entry.getKey().getName() + ": " + String.format("%.2f", avg));
            if (grades.stream().anyMatch(g -> g >= 90)) {
                highGrades++;
            }
        }
        System.out.println("Number of students with grades >=90: " + highGrades);
    }
}
