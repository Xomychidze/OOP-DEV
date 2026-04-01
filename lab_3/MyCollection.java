
public interface MyCollection<E> {

    /** Add an element. Returns true if the collection changed. */
    boolean add(E element);

    /** Remove one occurrence of element. Returns true if removed. */
    boolean remove(Object element);

    /** Check if element is in the collection. */
    boolean contains(Object element);

    /** Number of elements. */
    int size();

    /** True if no elements. */
    boolean isEmpty();

    /** Remove all elements. */
    void clear();

    /** Return all elements as an array. */
    Object[] toArray();
}
