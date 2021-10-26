import java.util.Scanner;

public class VersPro {
    public static void calcPro() {
        System.out.println("You run PRO calc");
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        char nextOperation = 'n';
        String inputStr;
        while (true) {
            System.out.println(result);
            inputStr = scanner.next();
            if (isAllNumeric(inputStr)) {
                if(nextOperation == 'n') {
                    result = Integer.parseInt(inputStr);
                }
                else {
                    switch (nextOperation) {
                        case '+':
                            result += Integer.parseInt(inputStr);
                            break;
                        case '-':
                            result -= Integer.parseInt(inputStr);
                            break;
                        case '*':
                            result *= Integer.parseInt(inputStr);
                            break;
                        case '/':
                            if(Integer.parseInt(inputStr) == 0)
                                System.out.println("ERROR");
                            else {
                                result /= Integer.parseInt(inputStr);
                            }
                            break;
                    }
                    nextOperation = 'n';
                }
            }
            else if (inputStr.length() == 1) {
                if(isEscape(inputStr.charAt(0) )) {
                    break;
                }
                else if(isReset(inputStr.charAt(0) )) {
                    result = 0;
                }
                else if(isOperation(inputStr.charAt(0) )) {
                    nextOperation = inputStr.charAt(0) ;
                }
                else
                    System.out.println("Unknown operation");
            }
            else
                System.out.println("Unknown operation");
        }
        System.out.println(result);
    }

    private static boolean isAllNumeric(String inputStr) {
        for (int i = 0; i < inputStr.length(); i++) {
            int chekInt = inputStr.charAt(i);
            if (48 > chekInt || chekInt > 57) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEscape(char nextSymb) {
        return nextSymb == 's';
    }

    private static boolean isReset(char nextSymb) {
        return nextSymb == 'c';
    }

    private static boolean isOperation(char nextSymb) {
        return (nextSymb == '+' || nextSymb == '-' || nextSymb == '*' || nextSymb == '/');
    }

}
