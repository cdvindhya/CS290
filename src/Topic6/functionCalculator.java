package Topic6;

import java.util.Scanner;

public class functionCalculator {

    static String exp;
    static int index;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exp = in.nextLine();
        System.out.println(eval());
    }

    public static int eval() {
        char ch = exp.charAt(index++);
        if (ch == 'a') {
            index++;
            index++;
            index++;
            int ans = eval();
            while (exp.charAt(index++) == ',') {
                ans = ans + eval();
            }
            return ans;
        } else if (ch == 'm') {
            index++;
            index++;
            index++;
            int ans = eval();
            while (exp.charAt(index++) == ',') {
                ans = ans * eval();
            }
            return ans;
        } else {
            //no invalid expressions
            int x = 0;
            while (index < exp.length()
                    && '0' <= exp.charAt(index) &
                    exp.charAt(index) <= '9') {
                x = x * 10;
                x += exp.charAt(index++) - '0';
            }
            return x;
        }
    }

}
