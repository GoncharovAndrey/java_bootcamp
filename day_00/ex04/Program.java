import java.util.Scanner;

public class Program {

    private static final int MAX_SYMBOLS = 999;
    private static char[] chars = new char[MAX_SYMBOLS + 1];
    private static int[] charsFrequency = new int[MAX_SYMBOLS + 1];
    private static char[][] histogram = new char[11][13];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        scanner.close();

        if (line.length() > MAX_SYMBOLS) {
            System.exit(0);
        }

        for (int i = 0; i < line.length(); i++) {
            setSymbolInChars(line.charAt(i));
        }

        sort();
        fillHistogram();
        printHistogram();
    }

    private static void setSymbolInChars(char symbol) {
        for (int i = 0; i < MAX_SYMBOLS; i++) {
            if (chars[i] == symbol) {
                charsFrequency[i] += 1;
                break;
            } else if (chars[i] == 0) {
                chars[i] = symbol;
                charsFrequency[i] += 1;
                break;
            }
        }
    }

    private static void sort() {
        for (int y = 0; y < MAX_SYMBOLS; y++) {
            for (int i = 0; chars[i] != 0; i++) {
                if (charsFrequency[i] < charsFrequency[i + 1]) {
                    swapElement(i, i + 1);
                } else if (charsFrequency[i] == charsFrequency[i + 1]) {
                    if (chars[i] > chars[i + 1]) {
                        swapElement(i, i + 1);
                    }
                }
            }
        }
    }

    private static void swapElement(int index, int secondIndex) {
        int tmp = charsFrequency[index];
        charsFrequency[index] = charsFrequency[secondIndex];
        charsFrequency[secondIndex] = tmp;

        char tmpChar = chars[index];
        chars[index] = chars[secondIndex];
        chars[secondIndex] = tmpChar;
    }

    private static void fillHistogram() {
        for (int i = 0; i < 10; i++) {
            if (chars[i] == 0) {
                break;
            }
            histogram[i][12] = chars[i];
        }

        if (chars[0] == 0) {
            return;
        }

        double coefficient = charsFrequency[0] / 10.0 > 1.0 ? charsFrequency[0] / 10.0 : 1.0;

        fillMarketHistograms(coefficient);
    }

    private static void fillMarketHistograms(double coefficient) {
        int y;
        int i;

        for (i = 0; i < 10; i++) {
            if (chars[i] == 0) {
                break;
            }
            for (y = 11; y >= 12 - charsFrequency[i] / coefficient && y != 1; y--) {
                histogram[i][y] = '#';
            }
            histogram[i][y] = (char) charsFrequency[i];
        }
    }

    private static void printHistogram() {
        int i;

        int y;

        String whiteSpace = charsFrequency[0] / 100 > 0 ? "  " : " ";

        for (y = 0; y < 13; y++) {
            i = 0;

            if (histogram[i][y] == 0) {

                continue;
            }

            for (i = 0; histogram[i][y] != 0; i++) {
                if (histogram[i][y - 1] == 0) {
                    if (histogram[i][y] / 10 == 0 || (charsFrequency[0] / 100 > 0 && histogram[i][y] / 100 == 0)) {
                        System.out.print(" ");
                    }
                    System.out.print((int) histogram[i][y]);
                } else {
                    System.out.print(" " + histogram[i][y]);
                }
                if (histogram[i + 1][y] == 0) {
                    System.out.println();
                } else if (histogram[i][y - 1] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(whiteSpace);
                }
            }
        }
    }
}
