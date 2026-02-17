package lab2;


class Student {
    private int id;
    private String name;
    private int yearOfStudy = 1;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public int getYear() { return yearOfStudy; }
    public String getName() { return name; }

    public void increaseYear() { ++yearOfStudy; }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Year: %d", id, name, yearOfStudy);
    }
}
