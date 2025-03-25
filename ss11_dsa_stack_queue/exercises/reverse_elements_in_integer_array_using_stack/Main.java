import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc  = new Scanner(System.in);
        String str= sc.nextLine();
        for (int i =0 ; i <str.length();i++){
            stack.push(str.charAt(i));
        }
        for ( int i = 0 ; i < str.length() ; i++){
            System.out.printf("%s",stack.pop());
        }
    }
}