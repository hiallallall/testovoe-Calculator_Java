import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main (String [] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ввести:");
        String string =s.nextLine();
        String[] strArray = string.split(" ");
        System.out.println(Arrays.toString(strArray));
        String[] roman = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};

        int x;
        int y;
        boolean arabic = true;

        if (strArray.length > 3 || strArray.length < 1) {
            throw new Error("");
        }

        int xRoman = 0;
         for (int i = 0; i < roman.length;i++) {
             if (strArray[0].equals(roman[i])){
                 xRoman = i;
             }
         }
        int yRoman = 0;
        for (int i = 0; i < roman.length;i++) {
            if (strArray[2].equals(roman[i])){
                yRoman = i;
            }
        }
        if (xRoman > 0 && yRoman > 0)  {//!!!!!
             x = xRoman;
             y = yRoman;
             arabic = false;
        }else {
            x = Integer.parseInt(strArray[0]); // arabic
            y = Integer.parseInt(strArray[2]);
        }
        int answer;
System.out.println("x= " + x);
System.out.println("y= " + y);
        String axe = "";
        if (x < 0 || x > 10) {
            throw new Error("x >< 10");
        } // check for number
        if (y < 0 || y > 10){
            throw new Error("y >< 10 o");
        } // check for number
                if (strArray[1].equals("+")) { //start operandCheck
                    answer = x+y;
                }else if (strArray[1].equals("-")) {
                    answer = x-y;
                }else if (strArray[1].equals("*")) {
                    answer = x*y;
                }else if (strArray[1].equals("/")) {
                    answer = x/y;
                }else {
                    throw new Error("wrong operand");
                }

                if (answer < 0 && xRoman == x) {
                    throw new Error("Roman answer cant be negative");
                }

                if (arabic) {
                    Integer answerArabic = answer;
                    System.out.println(answerArabic.toString());
                }else {
                    if (answer == 100) {
                        System.out.println("C");
                    } else if (answer > 10) {
                        while (answer > 10) {
                            answer = answer - 10;
                            axe = "X" + axe;
                        }
                        System.out.println(axe+roman[answer]);
                    } else {
                        System.out.println(roman[answer]);
                    }
                }

    }

}