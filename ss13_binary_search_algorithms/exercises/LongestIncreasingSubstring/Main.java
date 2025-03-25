package exercises.LongestIncreasingSubstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String findLongestIncreasingSubsequence(String s) {
        List<Character> lis = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int pos = binarySearch(lis, c);
            if (pos == lis.size()) {
                lis.add(c);
            } else {
                lis.set(pos, c);
            }
        }

        for (char c : lis) {
            result.append(c);
        }

        return result.toString();
    }

    private static int binarySearch(List<Character> lis, char key) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String inputString = scanner.nextLine();
        scanner.close();

        String result = findLongestIncreasingSubsequence(inputString);
        System.out.println("Chuỗi tăng dần lớn nhất là: " + result);
    }
}
