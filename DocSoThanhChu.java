import java.util.Scanner;

public class DocSoThanhChu {

    public String Loop(int num){
        switch (num){
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: case 17: case 18: case 19:
                return Loop(num % 10) + "teen";
            case 20: return "twenty";
            case 30: return "thirty";
            case 40: return "forty";
            case 50: return "fifty";
            case 60: return "sixty";
            case 70: return "seventy";
            case 80: return "eighty";
            case 90: return "ninety";
            default:
                if (num > 20 && num < 100) {
                    return Loop(num - num % 10) + " " + Loop(num % 10);
                } else if (num >= 100 && num <= 999) {
                    int hundreds = num / 100;
                    int remainder = num % 100;
                    String result = Loop(hundreds) + " hundred";
                    if (remainder > 0) {
                        result += " and " + Loop(remainder);
                    }
                    return result;
                }
                return "error";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (1-999): ");
        int num = sc.nextInt();

        DocSoThanhChu converter = new DocSoThanhChu();
        String result = converter.Loop(num);
        System.out.println("Result: " + result);
    }
}
