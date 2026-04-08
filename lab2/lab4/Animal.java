package lab4;

public class Animal {
    private static int idCount = 1;
    private String name;
    private int age;
    private String sex;
    private final int id;

    public Animal() {
        this.id = idCount++;
    }

    public Animal(String name, int age, String sex ){
        this.name = name;
        this.age = age; 
        this.sex = sex; 
        this.id = idCount++; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void makeSound(){
        System.out.println("Some sound");
    }

    public void eat(){
        System.out.println("Animal eats");
    }

    public void eat(Food food){ 
        System.out.printf("This dog eats: %s%n", food.getName());
    }

    

}



