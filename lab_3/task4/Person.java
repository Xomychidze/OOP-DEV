package task4;

public class Person implements Cloneable {
    private String name;

    public Person(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
    }

    public String getName()          { return name; }
    public void   setName(String n)  { this.name = n; }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        return name.equals(((Person) o).name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
