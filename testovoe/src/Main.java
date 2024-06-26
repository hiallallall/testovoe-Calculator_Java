import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int x;
    static int y;
    static final String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isArabic(String[] strArray) {
        int xRoman = 0;
        for (int i = 0; i < roman.length; i++) {
            if (strArray[0].equals(roman[i])) {
                xRoman = i;
            }
        }
        int yRoman = 0;
        for (int i = 0; i < roman.length; i++) {
            if (strArray[2].equals(roman[i])) {
                yRoman = i;
            }
        }
        if (xRoman > 0 && yRoman > 0) {
            x = xRoman;
            y = yRoman;
            return false;
        }
        return true;
    }

    public static int calculate(String operand, int x, int y) {
        if (operand.equals("+")) { //start operandCheck
            return x + y;
        }
        if (operand.equals("-")) {
            return x - y;
        }
        if (operand.equals("*")) {
            return x * y;
        }
        if (operand.equals("/")) {
            return x / y;
        }
        throw new Error("wrong operand");

//        switch (operand) {
//            case "-": {
//                return x - y;
//            }
//            case "+": {
//                return x + y;
//            }
//            case "/": {
//                return x / y;
//            }
//            case "*": {
//                return x * y;
//            }
//            default: {
//                throw new Error("wrong operand");
//            }
//        }
    }

    public static String calculateRoman(int answer) {
        StringBuilder axe = new StringBuilder();
        if (answer == 100) {
            System.out.println("C");
        } else if (answer > 10) {
            if (answer >= 50) {
                answer = answer - 50;
                axe.append("L");
            }
            while (answer >= 10) {
                answer = answer - 10;
                axe.append("X");
            }
            axe.append(roman[answer]);
//                        String romanAnswer = roman[answer] + axe;
//                        char[] toCharArr = romanAnswer.toCharArray();
//                        String result = "";
//                        for (int i = toCharArr.length - 1; i >= 0; i--) {
//                            result = result + toCharArr[i];
//                        }

        } else {
            axe.append(roman[answer]);
        }
        return axe.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ввести:");
        String string = s.nextLine();
        String[] strArray = string.split(" ");
        System.out.println(Arrays.toString(strArray));


        if (strArray.length != 3) {
            throw new Error("");
        }
        boolean arabic = isArabic(strArray);
        if (arabic) {
            x = Integer.parseInt(strArray[0]);
            y = Integer.parseInt(strArray[2]);
        }
        int answer;
        System.out.println("x= " + x);
        System.out.println("y= " + y);

        if (x < 0 || x > 10) {
            throw new Error("x >< 10");
        } // check for number
        if (y < 0 || y > 10) {
            throw new Error("y >< 10");
        } // check for number

        answer = calculate(strArray[1], x, y);


        if (answer < 0 && !arabic) {
            throw new Error("Roman answer cant be negative");
        }

        if (arabic) {

            System.out.println(answer);
        } else {
            System.out.println(calculateRoman(answer));
        }
    }

}