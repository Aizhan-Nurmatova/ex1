import java.util.Random;
import java.util.Scanner;

public class etap2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("---         Start game         ---");
        System.out.println("Predict amount of points (2..12): ");
        int n = in.nextInt();
        int computerN = rollTheDice();
        if (n > 1 && n < 13) {
            System.out.println("User rolls the dices...");
            int a = rollTheDice();
            int b = rollTheDice();
            printDice(a);
            printDice(b);
            int resultofcalc = a + b;

            System.out.println("On the dice fell " + resultofcalc + " points.");
            int resultofuser = calculateNumbers(resultofcalc, n);

            System.out.println("Computer predicted " + computerN + " points.");
            System.out.println("Computer rolls the dices...");
            int aa = rollTheDice();
            int bb = rollTheDice();
            printDice(aa);
            printDice(bb);
            int resultofcalcComp = aa + bb;

            System.out.println("On the dice fell " + resultofcalcComp + " points.");
            int resultofComp = calculateNumbers(resultofcalc, computerN);

            compairTheDice(resultofuser, resultofComp);

        } else {
            System.out.println("Wrong -- Predict amount of points (2..12) ---");
        }
        in.close();
    }

    public static void compairTheDice(int a, int b) {
        if (a > b) {
            System.out.println("User win " + (a - b) + " points more.");
            System.out.println("Congratulations!");
        } else if (a < b) {
            System.out.println("Computer win " + (b - a) + " points more.");
            System.out.println("Lucky next time!");
        } else {
            System.out.println("User and Computer's " + a + " points equal");
            System.out.println("It is better than lost!");
        }

    }

    public static int calculateNumbers(int a, int b) {
        int result = a - Math.abs(a - b) * 2;
        String frm = "Result is %s-abs(%s - %s) * 2: %s points";
        System.out.println(String.format(frm, a, a, b, result));
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