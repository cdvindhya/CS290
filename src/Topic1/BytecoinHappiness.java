import java.io.*;
import java.util.*;

public class BytecoinHappiness {
    public static void main(String[] args) { //Time complexity: O(N)

      //if the price is X unit more than prev price, he gains x^2 happy
      //if the price is Y unit less than prev price, he loses y^3 happy

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        //read into an array
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        //calculate total happiness
        long sum = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i-1]) {
                long x = (arr[i] - arr[i-1]);
                sum += x*x;
            } else {
                long y = (arr[i] - arr[i-1]);
                sum += y*y*y;
            }
        }

        long minimum = Integer.MAX_VALUE;

        for(int i = 1; i < N-1; i++) {
            long diff = 0;
            long diff_present = 0;
            long diff_absent = 0;

            //when present
            long a1 = (arr[i] - arr[i-1]);
            if (arr[i] > arr[i - 1]) {
                diff_present = a1*a1;
            } else {
                diff_present = a1*a1*a1;//(arr[i] - arr[i-1])*(arr[i-1] - arr[i])*(arr[i-1] - arr[i]);
            }

            long a2 = (arr[i+1] - arr[i]);
            if (arr[i + 1] > arr[i]) {
                diff_present += a2*a2;
            } else {
                diff_present += a2*a2*a2;//(arr[i] - arr[i+1])*(arr[i] - arr[i+1])*(arr[i] - arr[i+1]);
            }

            //when absent
            long a3 = (arr[i+1] - arr[i-1]);
            if (arr[i+1] > arr[i-1]) {
                diff_absent = a3*a3;
            } else {
                diff_absent = a3*a3*a3;//(arr[i-1] - arr[i+1])*(arr[i-1] - arr[i+1])*(arr[i-1] - arr[i+1]);
            }

            //compare
            diff = diff_present - diff_absent;
            if (diff < minimum) {
                minimum = diff;
            }

        }

        if (minimum > 0) {
            System.out.println(sum);
        } else {
            System.out.println(sum - minimum);
        }

    }
}
