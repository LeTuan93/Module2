package practice.install_selection_sort_algorithm;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};


    private static void swap(double[] list,int i ,int j){
        double tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int tmp = i;
            for (int j =  i+1 ;j<list.length;j++ ){
                if (list[tmp]>list[j]){
                    tmp = j;
                }
                if (tmp != i){
                    swap(list,tmp,i);
                }
            }
        }
    }
    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

}
