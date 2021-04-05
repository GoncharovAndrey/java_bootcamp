import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        long countOfRequest = 0;
        long coffeeRequest;
        Scanner scanner = new Scanner(System.in);

        while ((coffeeRequest = scanner.nextInt()) != 42) {
            if (isPrime(getSumNumber(coffeeRequest))) {
                countOfRequest++;
            }
        }

        scanner.close;
        System.out.println("Count of coffee - request - " + countOfRequest);
    }

    private static boolean isPrime(long number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long getSumNumber(long number) {
        if (number / 10 == 0) {
            return number;
        }
        return number % 10 + getSumNumber(number / 10);
    }
}
