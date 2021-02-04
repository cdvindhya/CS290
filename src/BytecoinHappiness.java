import java.io.*;
import java.util.*;

public class BytecoinHappiness {
    public static void main(String[] args) {
      //if the price is X unit more than prev price, he gains x^2 happy
      //if the price is Y unit less than prev price, he loses y^3 happy
        /*
       - At a higher level, the idea is similar to the first two example problems: You don't want to recompute sums for one change.
       - You can use prefix-sum array or postfix-sum array to help.
        */

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int max_diff = 0;
        int index = 0;
        //read into an array
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        //should not remove first or last number in seq
        for (int i = 1; i < N-1; i++) { //removing digit with max difference
            int diff = 0;
            diff += Math.abs(arr[i] - arr[i-1]);
            diff += Math.abs(arr[i] - arr[i+1]);
            if (diff > max_diff) {
                max_diff = diff;
                index = i;
            }
        }
        //calculating happiness value
        long sum = 0;
        //System.out.println("index: " + index);
        for (int i = 1; i < N; i++) {
            if (i == index) {
                continue;
            }
            if ((i-1) == index) {
                if (arr[i] > arr[i-2]) {
                    sum += (arr[i] - arr[i-2])*(arr[i] - arr[i-2]);
                } else {
                    sum -= (arr[i-2] - arr[i])*(arr[i-2] - arr[i])*(arr[i-2] - arr[i]);
                }
            } else {
                if (arr[i] > arr[i-1]) {
                    sum += (arr[i] - arr[i-1])*(arr[i] - arr[i-1]);
                } else {
                    sum -= (arr[i-1] - arr[i])*(arr[i-1] - arr[i])*(arr[i-1] - arr[i]);
                }
            }
        }
        System.out.println(sum);
    }
}
