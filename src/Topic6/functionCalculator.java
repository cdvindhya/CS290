package Topic6;

import java.util.Scanner;

public class functionCalculator {

    static String exp = "";
    static int index = 0;
    static int m = 1000000007;

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
            index++;
            int ans = eval()%m;
            while (exp.charAt(index++) == ',') {
                ans = (ans + eval())%m;
            }
            return ans;
        } else if (ch == 'm') {
            index++;
            index++;
            index++;
            index++;
            int ans = eval()%m;
            while (exp.charAt(index++) == ',') {
                ans = (ans * eval())%m;
            }
            return ans;
        } else {
            //no invalid expressions
            int x = 0;
            while (index <= exp.length()
                    && '0' <= ch &&
                    ch <= '9') {
                x = x * 10;
                x += ch - '0';
                if (index <= exp.length()) {
                    ch = exp.charAt(index);
                } else {
                    break;
                }
                index++;
            }
            return x%m;
        }
    }

}
