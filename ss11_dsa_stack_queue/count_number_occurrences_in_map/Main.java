package count_number_occurrences_in_map;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<String,Integer>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i =0;i<str.length();i++) {
            map.put(str.substring(i,i+1),1);
        }
        System.out.println(map);

    }
}
