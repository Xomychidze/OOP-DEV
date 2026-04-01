import java.io.Serializable;


public class Person implements Cloneable, Serializable, Describable, Identifiable {
    private String name;
    private int    age;

    // No-arg constructor
    public Person() {
        this("Unknown", 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // --- Getters / Setters ---
    public String getName()      { return name; }
    public int    getAge()       { return age; }
    public void   setName(String name) { this.name = name; }
    public void   setAge(int age)      { this.age  = age; }

    // --- Object overrides ---
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person p = (Person) obj;
        return name.equals(p.name) && age == p.age;
    }

    // --- Cloneable ---
    @Override
    public Person clone() {
        try {
            return (Person) super.clone(); // shallow — String is immutable so no deep copy needed
        } catch (CloneNotSupportedException e) {
            return null; // never happens since we implement Cloneable
        }
    }

    // --- Describable ---
    @Override
    public String describe() {
        return "My name is " + name + " and I am " + age + " years old.";
    }

    // --- Identifiable ---
    @Override
    public String getId() {
        return name + "_" + age;
    }
}
