package exercises.install_insertion_sort_algorithm;

public class InsertionSort {

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int pos = i;
            while ( pos > 0  && x < arr[pos-1]) {
                arr[pos] = arr[pos-1];
                pos -=1;
            }
            arr[pos] = x;
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
