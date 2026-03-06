import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people;

    public PersonRegistry() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Registered: " + person.getName());
    }

    public boolean removePerson(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                people.remove(p);
                System.out.println("Removed from registry: " + name);
                return true;
            }
        }
        System.out.println("Person not found: " + name);
        return false;
    }

    public List<Person> getPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (p.hasPet()) result.add(p);
        }
        return result;
    }

    public List<Person> getPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (!p.hasPet()) result.add(p);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== PersonRegistry ===\n");
        for (Person p : people) {
            sb.append("  ").append(p).append("\n");
        }
        sb.append("======================");
        return sb.toString();
    }
}
