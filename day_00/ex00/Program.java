public class Program {

    static final int NUMBER = 479598;

    public static void main(String[] args) {
        System.out.println(sumNumber(NUMBER));
    }

    private static int sumNumber() {
        return NUMBER / 100_000
                + (NUMBER % 100_000) / 10_000
                + (NUMBER % 10_000) / 1000
                + (NUMBER % 1000) / 100
                + (NUMBER % 100) / 10
                + NUMBER % 10;
    }
}
