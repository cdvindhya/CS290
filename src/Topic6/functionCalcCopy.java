package Topic6;

import java.util.Scanner;
import java.util.Stack;

public class functionCalcCopy {

    static String exp = "";
    static int index = 0;
    static int m = 1000000007;
    String s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exp = in.nextLine();
        System.out.println(eval());
    }

    private int nextInt() {
        int x = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        while (index < s.length() && '0' <= s.charAt(index) && s.charAt(index) <= '9') {
            x *= 10;
            x += s.charAt(index++) - '0';
        }
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        return x;
    }

    public int calculate(String s) {
        this.s = s;
        index = 0;
        Stack<Integer> ex = new Stack<Integer>();
        ex.push(nextInt());
        while (index < s.length()) {
            char op = s.charAt(index++);
            if (op == '+') {
                ex.push(nextInt());
            } else if (op == '-') {
                ex.push(-nextInt());
            } else if (op == '*') {
                ex.push(ex.pop() * nextInt());
            } else if (op == '/') {
                ex.push(ex.pop() / nextInt());
            }
        }
        int ans = ex.pop();
        while (!ex.empty()) {
            ans += ex.pop();
        }
        return ans;
    }

    public static int eval() {
        char ch = exp.charAt(index);
        if (ch == 'a') {
            index++;
            index++;
            index++;
            int ans = eval()%m;
            while (exp.charAt(index++) == ',') {
                ans = (ans + eval())%m;
            }
            index++;
            if (ch == ')' || ch == '(' || ch == ',') {
                index++;
            }
            return ans;
        } else if (ch == 'm') {
            index++;
            index++;
            index++;
            int ans = eval()%m;
            while (exp.charAt(index++) == ',') {
                ans = (ans * eval())%m;
            }
            index++;
            if (ch == ')' || ch == '(' || ch == ',') {
                index++;
            }
            return ans;
        } else {
            //no invalid expressions
            int x = 0;
            while (index < exp.length()
                    && '0' <= exp.charAt(index) &&
                    exp.charAt(index) <= '9') {
                x = x * 10;
                x += exp.charAt(index) - '0';
            }
            index++;
            if (ch == ')' || ch == '(' || ch == ',') {
                index++;
            }
            return x%m;
        }
    }

}
