package practice.install_bubble_sort_algorithm;

public class BubbleSort {

    private static void swap(int list[],int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    private static void bubbleSort(int[] list) {
        for (int i = 0 ; i < list.length - 1; i++) {
            for (int j = list.length-1 ; j > i;j--){
                if (list[j] < list[j-1]){
                    swap(list,j, j-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}