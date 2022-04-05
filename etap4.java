import java.util.Random;
import java.util.Scanner;

public class etap4 {

    public static int[] arrayCR = new int[3];
    public static int[] arrayUserP = new int[3];
    public static int[] arrayUserD = new int[3];
    public static int[] arrayCompP = new int[3];
    public static int[] arrayCompD = new int[3];
    public static int sumOFUser = 0;
    public static int sumOFComp = 0;
    public static int counter = 0;

    public static void main(String[] args) {
        start();

        System.out.println("“Do you want to play one more time (Y/N)”");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        switch (a) {
            case "Y":
                start();
                break;
            case "y":
                start();
                break;
            default:
                System.out.println("Thanks for game ");
        }

    }

    public static void startProgramWithFor() {
        for (int i = 1; i <= 3; i = i + 1) {
            System.out.println("---------------" + i + "------------------");
            System.out.println();
            startProgram(i - 1);
            System.out.println();
            System.out.println("---------- Current score ---------");
            System.out.println("User: " + arrayUserP[i - 1] + " points");
            System.out.println("Computer: " + arrayCompP[i - 1] + " points");
            compairTheDice(etap3.arrayUR[i - 1], arrayCR[i - 1]);
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("-------------- Finish game --------------");
        System.out.println();
        for (int i = 0; i <= 4; i = i + 1) {
            if (i == 0) {
                System.out.println(" Round |           User |      Computer  ");
            } else if (i == 4) {
                System.out.println("-------+----------------+----------------");
                String frm = "Total  | Points: %6s | Points: %6s";
                sumOFUser = etap3.arrayUR[0] + etap3.arrayUR[1] + etap3.arrayUR[2];
                sumOFComp = arrayCR[0] + arrayCR[1] + arrayCR[2];
                System.out.println(String.format(frm, sumOFUser, sumOFComp));
                System.out.println();
                compairSum(sumOFUser, sumOFComp);

            } else {
                printFinish(i);
            }
        }
        System.out.println("Penalty " + counter + " times" +"-"+counter*10);
    }

    public static void compairSum(int a, int b) {
        if (a > b) {
            System.out.println("Users win " + (a - b) + " points more.");
            System.out.println("Congratulations!");
        } else if (a < b) {
            System.out.println("Computers win " + (b - a) + " points more.");
            System.out.println("Lucky next time!");
        } else {
            System.out.println("User and Computer's " + a + " points equal");
            System.out.println("It is better than lost!");
        }
    }

    public static void printFinish(int a) {
        System.out.println("-------+----------------+----------------");
        String frm = "       | Predicted: %3s | Predicted: %3s ";
        String frm1 = "  -%s-  | Dice: %8s | Dice: %8s ";
        String frm2 = "       | Result: %6s | Result: %6s ";
        System.out.println(String.format(frm, arrayUserP[a - 1], arrayCompP[a - 1]));
        System.out.println(String.format(frm1, a, arrayUserD[a - 1], arrayCompD[a - 1]));
        System.out.println(String.format(frm2, etap3.arrayUR[a - 1], arrayCR[a - 1]));
    }

    public static void printOnTheDice(int a) {
        System.out.println("On the dice fell " + a + " points.");
    }

    public static int usernumber() {
        Scanner in = new Scanner(System.in);
        int n5 = 0;
        boolean bln = true;

        while (bln) {
            System.out.print("Predict amount of points (2..12): ");
            int n = in.nextInt();
            if (n < 2 || n > 12) {
                bln = true;
            } else {
                bln = false;
                return n;
            }
        }
        return n5;

    }

    public static void start() {
        System.out.println("---         Start game         ---");
        startProgramWithFor();

    }

    public static int getChance(int max1, int max2) {
        Random rnd = new Random();
        int n = rnd.nextInt(max2) + 1;
        if (n > max1) {
            return max2;
        } else {
            return max1;
        }
    }

    public static void startProgram(int b) {
        int userN = usernumber();
        arrayUserP[b] = userN;
        int computerN = rollTheDice();
        arrayCompP[b] = computerN;
        // int firstUserDice = rollTheDice();
        // int secondUserDice = rollTheDice();
        int firstCompDice = rollTheDice();
        int secondCompDice = rollTheDice();
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to cheat?(Y/N): ");
        String a = in.nextLine();

        if (b == 0) {

            switch (a) {
                case "Y":
                    int s = getChance(1, 2);
                    if (s == 1) {
                        printNameRollsDices("User");
                        printDice(userN / 2);
                        printDice(userN - (userN / 2));
                        int resultofUser = userN;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                    } else {
                        printNameRollsDices("User");
                        int firstUserDice = rollTheDice();
                        int secondUserDice = rollTheDice();
                        printDice(firstUserDice);
                        printDice(secondUserDice);
                        int resultofUser = firstUserDice + secondUserDice;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                        counter = counter + 1;
                        break;
                    }
                    break;

                default:
                    printNameRollsDices("User");
                    int firstUserDice = rollTheDice();
                    int secondUserDice = rollTheDice();
                    printDice(firstUserDice);
                    printDice(secondUserDice);
                    int resultofUser = firstUserDice + secondUserDice;
                    arrayUserD[b] = resultofUser;
                    printOnTheDice(resultofUser);
                    int calcUserPoints = calculateNumbers(resultofUser, userN);
                    System.out.println("Computer predicted " + computerN + " points.");
                    printNameRollsDices("Computer");
                    printDice(firstCompDice);
                    printDice(secondCompDice);
                    int resultofComp = firstCompDice + secondCompDice;
                    arrayCompD[b] = resultofComp;
                    printOnTheDice(resultofComp);
                    int calcCompPoints = calculateNumbers(resultofComp, computerN);

                    arrayCR[b] = calcCompPoints;
                    etap3.arrayUR[b] = calcUserPoints;
                    break;
            }

        }

        if (b == 1) {
            switch (a) {
                case "Y":
                    int s = getChance(1, 4);
                    if (s == 1) {
                        printNameRollsDices("User");
                        printDice(userN / 2);
                        printDice(userN - (userN / 2));
                        int resultofUser = userN;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                    } else {
                        printNameRollsDices("User");
                        int firstUserDice = rollTheDice();
                        int secondUserDice = rollTheDice();
                        printDice(firstUserDice);
                        printDice(secondUserDice);
                        int resultofUser = firstUserDice + secondUserDice;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                        counter = counter + 1;
                        break;
                    }
                    break;

                default:
                    printNameRollsDices("User");
                    int firstUserDice = rollTheDice();
                    int secondUserDice = rollTheDice();
                    printDice(firstUserDice);
                    printDice(secondUserDice);
                    int resultofUser = firstUserDice + secondUserDice;
                    arrayUserD[b] = resultofUser;
                    printOnTheDice(resultofUser);
                    int calcUserPoints = calculateNumbers(resultofUser, userN);
                    System.out.println("Computer predicted " + computerN + " points.");
                    printNameRollsDices("Computer");
                    printDice(firstCompDice);
                    printDice(secondCompDice);
                    int resultofComp = firstCompDice + secondCompDice;
                    arrayCompD[b] = resultofComp;
                    printOnTheDice(resultofComp);
                    int calcCompPoints = calculateNumbers(resultofComp, computerN);

                    arrayCR[b] = calcCompPoints;
                    etap3.arrayUR[b] = calcUserPoints;
                    break;
            }

        }

        if (b == 2) {

            switch (a) {
                case "Y":
                    int s = getChance(1, 6);
                    if (s == 1) {
                        printNameRollsDices("User");
                        printDice(userN / 2);
                        printDice(userN - (userN / 2));
                        int resultofUser = userN;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                    } else {
                        printNameRollsDices("User");
                        int firstUserDice = rollTheDice();
                        int secondUserDice = rollTheDice();
                        printDice(firstUserDice);
                        printDice(secondUserDice);
                        int resultofUser = firstUserDice + secondUserDice;
                        arrayUserD[b] = resultofUser;
                        printOnTheDice(resultofUser);
                        int calcUserPoints = calculateNumbers(resultofUser, userN);
                        System.out.println("Computer predicted " + computerN + " points.");
                        printNameRollsDices("Computer");
                        printDice(firstCompDice);
                        printDice(secondCompDice);
                        int resultofComp = firstCompDice + secondCompDice;
                        arrayCompD[b] = resultofComp;
                        printOnTheDice(resultofComp);
                        int calcCompPoints = calculateNumbers(resultofComp, computerN);

                        arrayCR[b] = calcCompPoints;
                        etap3.arrayUR[b] = calcUserPoints;
                        counter = counter + 1;
                        break;
                    }
                    break;

                default:
                    printNameRollsDices("User");
                    int firstUserDice = rollTheDice();
                    int secondUserDice = rollTheDice();
                    printDice(firstUserDice);
                    printDice(secondUserDice);
                    int resultofUser = firstUserDice + secondUserDice;
                    arrayUserD[b] = resultofUser;
                    printOnTheDice(resultofUser);
                    int calcUserPoints = calculateNumbers(resultofUser, userN);
                    System.out.println("Computer predicted " + computerN + " points.");
                    printNameRollsDices("Computer");
                    printDice(firstCompDice);
                    printDice(secondCompDice);
                    int resultofComp = firstCompDice + secondCompDice;
                    arrayCompD[b] = resultofComp;
                    printOnTheDice(resultofComp);
                    int calcCompPoints = calculateNumbers(resultofComp, computerN);

                    arrayCR[b] = calcCompPoints;
                    etap3.arrayUR[b] = calcUserPoints;
                    break;
            }

        }

    }

    public static void printNameRollsDices(String gamer) {
        System.out.println(gamer + " rolls the dices...");
    }

    public static void compairTheDice(int a, int b) {
        if (a > b) {
            System.out.println("User is ahead by " + (a - b) + " points!.");
        } else if (a < b) {
            System.out.println("Computer is ahead by " + (b - a) + " points!");
        } else {
            System.out.println("User and Computer's " + a + " points equal");
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