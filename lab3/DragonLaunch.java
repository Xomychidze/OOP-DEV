package lab3;

import java.util.Vector;

enum Gender {
    BOY, GIRL
}
public class DragonLaunch {
    private Vector<Person> kidnappedPeople = new Vector<>();

    
    public void kidnap(Person p) {
        kidnappedPeople.add(p);
        willDragonEatOrNot();
    }

    private void willDragonEatOrNot() {
        for (int i = 0; i < kidnappedPeople.size() - 1; i++) {
            Person first = kidnappedPeople.get(i);
            Person second = kidnappedPeople.get(i + 1);
            if (first.getGender() == Gender.BOY && second.getGender() == Gender.GIRL) {
                kidnappedPeople.remove(i + 1);
                kidnappedPeople.remove(i);
                i = -1;
            }
        }
    }

    public void printKidnapped() {
        for (Person p : kidnappedPeople) {
            System.out.println(p);
        }
    }

    public static void dragonSimulation() {
        DragonLaunch dl = new DragonLaunch();
        dl.kidnap(new Person("Alice", Gender.GIRL));
        dl.kidnap(new Person("Bob", Gender.BOY));
        dl.kidnap(new Person("Charlie", Gender.BOY));
        dl.kidnap(new Person("Diana", Gender.GIRL));
        dl.kidnap(new Person("Eve", Gender.GIRL));
        dl.kidnap(new Person("Elona", Gender.GIRL));
        dl.printKidnapped();
    }
}

class Person {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ")";
    }
}

