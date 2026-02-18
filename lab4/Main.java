package lab4;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Animal / Dog Demo ===");
        Dog dog = new Dog("Rex", 3, "male", "Shepherd", "large");

        dog.makeSound();                        // overriding
        dog.eat();                              // базовый метод
        dog.eat(new Food("Meat", "animal", 5)); // overloading + overriding
        System.out.println("Dog id: " + dog.getId());

        Dog dog2 = new Dog();                   // super() без параметров
        System.out.println("Dog2 id: " + dog2.getId());

        System.out.println("\n=== Person / Student / Staff Demo ===");

        Person person = new Person("Alex", "Almaty");
        System.out.println(person);

        Student student = new Student("Nurik", "Astana", "Computer Science", 2, 150000);
        System.out.println(student);

        Staff staff = new Staff("John", "London", "IT School", 3000);
        System.out.println(staff);
    }
}
