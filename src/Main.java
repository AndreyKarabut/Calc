import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char answer = '0';
        while (answer != 'y' && answer != 'n') {
            System.out.println("Launch version PRO? y/n");
            answer = sc.next().charAt(0);
        }
        if (answer == 'y') {
            VersPro.calcPro();
        } else runCalc();
    }

    public static void runCalc() {
        System.out.println("You run calc");
        double result = 0;
        char nextSymb;
        int nextInt = inputInt(result);
        boolean flag = true;
        result = nextInt;

        while(flag) {
            nextSymb = inputChar(result);
            if(nextSymb == '=') {
                flag = false;
                continue;
            }
            else if(nextSymb != '+' && nextSymb != '-' && nextSymb != '*' && nextSymb != '/') {
                System.out.println("Unknown operation");
                continue;
            }
            nextInt = inputInt(result);
            switch (nextSymb) {
                case '+' -> result += nextInt;
                case '-' -> result -= nextInt;
                case '*' -> result *= nextInt;
                case '/' -> {
                    if (nextInt == 0) {
                        System.out.println("ERROR");
                        flag = false;
                        break;
                    }
                    result /= nextInt;
                }
            }
            nextInt = 0;
        }
        System.out.println(result);
    }

    private static char inputChar(double result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(result);
        return scanner.next().charAt(0);
    }

    private static int inputInt(double result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(result);
        return scanner.nextInt();
    }
}