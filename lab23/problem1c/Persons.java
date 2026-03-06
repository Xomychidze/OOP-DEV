public class Persons {

    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persons)) return false;

        Persons p = (Persons) o;
        return age == p.age && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}