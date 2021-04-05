import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        long allProgress = 0;

        for (int i = 1; i < 19; i++) {
            line = scanner.nextLine();
            if (line != null && line.equals("Week " + i)) {
                allProgress = allProgress * 10 + getMinProgress(scanner);
            } else if (line != null && line.equals("42")) {
                break;
            } else {
                System.out.println("IllegalArgument");
                scanner.close();
                System.exit(0);
            }
        }

        scanner.close();
        printAllProgress(allProgress);
    }

    private static int getMinProgress(Scanner scanner) {
        int minProgress = 10;
        int progress;

        for (int i = 0; i < 5; i++) {
            progress = scanner.nextInt();
            if (minProgress > progress) {
                minProgress = progress;
            }
        }

        scanner.nextLine();
        return minProgress;
    }

    private static void printAllProgress(long allProgress) {
        if (allProgress / 10 == 0) {
            printOneWeek(allProgress);
        } else {
            printAllProgress(allProgress / 10);
            printOneWeek(allProgress % 10);
        }
    }

    private static void printOneWeek(long progress) {
        System.out.print("Week " + progress + " ");

        for (; progress > 0; progress--) {
            System.out.print("=");
        }

        System.out.println(">");
    }
}
