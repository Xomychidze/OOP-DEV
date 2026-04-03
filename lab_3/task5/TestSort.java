package task5;

class Chocolate implements Comparable<Chocolate> {
    private String name;
    private double weight; // grams

    public Chocolate(String name, double weight) {
        this.name   = name;
        this.weight = weight;
    }

    public double getWeight() { return weight; }
    public String getName()   { return name; }

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return String.format("Chocolate{name='%s', weight=%.1fg}", name, weight);
    }
}

class Time implements Comparable<Time> {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59
                || seconds < 0 || seconds > 59)
            throw new IllegalArgumentException("Invalid time values");
        this.hours   = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int totalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.totalSeconds(), other.totalSeconds());
    }

    @Override
    public String toString() {
        return String.format("Time{%02d:%02d:%02d}", hours, minutes, seconds);
    }
}

class Sort {

    static <E> void swap(E[] array, int i, int j) {
        E temp    = array[i];
        array[i]  = array[j];
        array[j]  = temp;
    }


    static <E extends Comparable<E>> void bubbleSort(E[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }


    static <E extends Comparable<E>> void mergeSort(E[] array) {
        if (array.length <= 1) return;
        mergeSortHelper(array, 0, array.length - 1);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> void mergeSortHelper(E[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right) {
        Object[] temp = new Object[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i].compareTo(array[j]) <= 0)
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= mid)  temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int m = 0; m < temp.length; m++)
            array[left + m] = (E) temp[m];
    }
}

public class TestSort {

    static <E> void print(E[] arr) {
        for (E e : arr) System.out.println("  " + e);
    }

    public static void main(String[] args) {

        Chocolate[] chocolates = {
            new Chocolate("Twix",      58.0),
            new Chocolate("Snickers",  52.7),
            new Chocolate("KitKat",    45.0),
            new Chocolate("Milka",    100.0),
            new Chocolate("Bounty",    57.0),
        };

        System.out.println("=== Chocolates (Bubble Sort by weight) ===");
        Sort.bubbleSort(chocolates);
        print(chocolates);

        Time[] times = {
            new Time(14, 30,  0),
            new Time( 8,  5, 45),
            new Time(23, 59, 59),
            new Time( 0,  0,  1),
            new Time(12,  0,  0),
        };

        System.out.println("\n=== Times (Merge Sort) ===");
        Sort.mergeSort(times);
        print(times);

        System.out.println("\n=== Employees (Bubble Sort by salary) ===");
        LocalEmployee[] employees = {
            new LocalEmployee("Bob",   55_000),
            new LocalEmployee("Carol", 90_000),
            new LocalEmployee("Alice", 75_000),
            new LocalEmployee("Dave",  45_000),
        };
        Sort.bubbleSort(employees);
        print(employees);

        System.out.println("\n=== Employees (Merge Sort by salary) ===");
        LocalEmployee[] employees2 = {
            new LocalEmployee("Zara",  120_000),
            new LocalEmployee("Omar",  120_000),
            new LocalEmployee("Eve",    30_000),
        };
        Sort.mergeSort(employees2);
        print(employees2);
    }
}

class LocalEmployee implements Comparable<LocalEmployee> {
    private String name;
    private double salary;

    LocalEmployee(String name, double salary) {
        this.name = name; this.salary = salary;
    }

    @Override public int compareTo(LocalEmployee o) {
        return Double.compare(this.salary, o.salary);
    }

    @Override public String toString() {
        return String.format("Employee{name='%s', salary=%.0f}", name, salary);
    }
}
