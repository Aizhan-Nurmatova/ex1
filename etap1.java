import java.util.Random;
import java.util.Scanner;

public class etap1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("---         Start game         ---");
        System.out.println("Predict amount of points (2..12): ");
        int n = in.nextInt();
        if (n > 1 && n < 13) {
            System.out.println("User rolls the dices...");
            int a = rollTheDice();
            int b = rollTheDice();
            printDice(a);
            printDice(b);

            int resultofcalc = a + b;

            System.out.println("On the dice fell " + resultofcalc + " points.");
            calculateNumbers(resultofcalc, n);

        } else {
            System.out.println("Wrong -- Predict amount of points (2..12) ---");
        }
        in.close();
    }

    public static void compairTheDice(int a) {
        if (a > 0) {
            System.out.println("User wins");
        } else if (a < 0) {
            System.out.println("User losts");
        } else {
            System.out.println("User and Random's dices equal");
        }

    }

    public static int calculateNumbers(int a, int b) {
        int result = a - Math.abs(a - b) * 2;
        String frm = "Result is %s-abs(%s - %s) * 2: %s points";
        System.out.println(String.format(frm, a, a, b, result));
        compairTheDice(result);
        return result;
    }

    public static int rollTheDice() {
        Random rnd = new Random();
        int a = rnd.nextInt(6) + 1;
        return a;
    }

    public static void printDice(int a) {
        System.out.println("+-------+");
        switch (a) {
            case (1):
                System.out.println("|       |");
                System.out.println("|   #   |");
                System.out.println("|       |");
                break;
            case (2):
                System.out.println("| #     |");
                System.out.println("|       |");
                System.out.println("|     # |");
                break;
            case (3):
                System.out.println("|   #   |");
                System.out.println("|       |");
                System.out.println("| #   # |");
                break;
            case (4):
                System.out.println("| #   # |");
                System.out.println("|       |");
                System.out.println("| #   # |");
                break;
            case (5):
                System.out.println("| #   # |");
                System.out.println("|   #   |");
                System.out.println("| #   # |");
                break;
            case (6):
                System.out.println("| #   # |");
                System.out.println("| #   # |");
                System.out.println("| #   # |");
                break;
            default:
                break;
        }
        System.out.println("+-------+");
    }

}