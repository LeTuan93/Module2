package practise.split_variable;

public class FizzBuzzGame {
    public static String getFizzBuzzResult(int number) {
        boolean divisibleBy3 = isDivisibleBy(number, 3);
        boolean divisibleBy5 = isDivisibleBy(number, 5);

        if (divisibleBy3 && divisibleBy5) return "FizzBuzz";
        if (divisibleBy3) return "Fizz";
        if (divisibleBy5) return "Buzz";

        return String.valueOf(number);
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getFizzBuzzResult(i));
        }
    }
}
