package lab4;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Rex", 3, "male", "Shepherd", "large");

        dog.makeSound();        // overriding
        dog.eat();              // базовый метод
        dog.eat(new Food("Meat", "animal", 5)); // overloading + overriding

        System.out.println("Dog id: " + dog.getId());

        // вызов конструктора без параметров
        Dog dog2 = new Dog();
        System.out.println("Dog2 id: " + dog2.getId());
    }
}
