package task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface MyCollection<E> extends Iterable<E> {

    boolean add(E element);
    boolean remove(Object o);
    boolean contains(Object o);
    int size();
    boolean isEmpty();
    void clear();
    Object[] toArray();
    boolean addAll(MyCollection<? extends E> other);
    boolean removeAll(MyCollection<?> other);
    boolean retainAll(MyCollection<?> other);
    boolean containsAll(MyCollection<?> other);
    Iterator<E> iterator();

    default boolean isNotEmpty() {
        return !isEmpty();
    }
}

class MyArrayCollection<E> implements MyCollection<E> {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayCollection() {
        data = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        data[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null ? o == null : data[i].equals(o)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null ? o == null : data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public boolean addAll(MyCollection<? extends E> other) {
        boolean changed = false;
        for (E e : other) {
            add(e);
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(MyCollection<?> other) {
        boolean changed = false;
        for (Object o : other) {
            while (remove(o)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(MyCollection<?> other) {
        boolean changed = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!other.contains(data[i])) {
                remove(data[i]);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean containsAll(MyCollection<?> other) {
        for (Object o : other) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (E) data[index++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

class MyCollectionDemo {
    public static void main(String[] args) {
        MyCollection<String> col = new MyArrayCollection<>();

        col.add("Almaty");
        col.add("Astana");
        col.add("Shymkent");
        col.add("Almaty");

        System.out.println("Collection: " + col);
        System.out.println("Size: " + col.size());
        System.out.println("Contains 'Astana': " + col.contains("Astana"));

        col.remove("Astana");
        System.out.println("After remove 'Astana': " + col);

        System.out.println("Iterating:");
        for (String s : col) {
            System.out.println("  " + s);
        }
    }
}