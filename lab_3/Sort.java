/**
 * TASK 5 — Generic Sort class
 *
 * Can sort ANY array whose element type implements Comparable<T>.
 * The type bound <T extends Comparable<T>> ensures we can call compareTo().
 *
 * Contains:
 *   - swap()          : reusable swap used by both algorithms
 *   - bubbleSort()    : O(n²) — simple but slow
 *   - selectionSort() : O(n²) — fewer swaps than bubble sort
 *   - printArray()    : helper for printing results
 */
public class Sort {

    /**
     * Swap two elements in an array.
     * Works for ANY object type (no Comparable needed here).
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T temp  = arr[i];
        arr[i]  = arr[j];
        arr[j]  = temp;
    }

    /**
     * Bubble Sort — repeatedly swaps adjacent elements if they are in wrong order.
     * After each pass, the largest unsorted element "bubbles" to the end.
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * Selection Sort — finds the minimum element and moves it to the front.
     * Makes fewer swaps than Bubble Sort.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /** Print any array on one line */
    public static <T> void printArray(T[] arr) {
        System.out.print("  [ ");
        for (T item : arr) System.out.print(item + "  ");
        System.out.println("]");
    }
}
