package exercises.implement_arrayList_methods;


public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        System.out.println("Original list:");
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.print(listInteger.get(i) + " ");
        }
        System.out.println("\n");

        // Clone the list
        MyList<Integer> clonedList = listInteger.clone();
        System.out.println("Cloned list:");
        for (int i = 0; i < clonedList.size(); i++) {
            System.out.print(clonedList.get(i) + " ");
        }
        System.out.println("\n");

        // Modify original list and show cloned list remains unchanged
        listInteger.add(6);
        System.out.println("Modified original list:");
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.print(listInteger.get(i) + " ");
        }
        System.out.println("\n");

        System.out.println("Cloned list after modification:");
        for (int i = 0; i < clonedList.size(); i++) {
            System.out.print(clonedList.get(i) + " ");
        }
    }
}
