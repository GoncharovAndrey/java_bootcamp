import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int index;

        if (number <= 1) {
            System.out.println("IllegalArgument");
            exit(scanner);
        }

        for (index = 2; index * index <= number; index++) {
            if (number % index == 0) {
                System.out.println("false " + (index - 1));
                exit(scanner);
            }
        }

        scanner.close;
        System.out.println("true " + (index - 1));
    }

    private static void exit(Scanner scanner) {
        scanner.close;
        System.exit(0);
    }
}
