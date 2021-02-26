package Topic4;

import java.io.*;
import java.util.*;

public class trickRTreat {
    public static void main(String[] args) {

        //init values
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(); //number of streets
        int N = in.nextInt(); //number of houses
        int K = in.nextInt(); //number of consec houses willing to spare

        //moving to next line
        in.nextLine();

        int[][] data = new int[M][N+2];
        int taste = 0;
        int plan = -1;
        int sum = 0;

        for (int i = 0; i < M; i++) {
            sum = 0;
            for (int j = 0; j <= N - 1; j++) {
                taste = in.nextInt();
                plan = in.nextInt();
                if (plan == 0) {
                    sum = sum + taste;
                    data[i][j] = 0;
                } else {
                    data[i][j] = taste;
                }
            } //inner loop
            data[i][N] = sum;
        } //outer loop

        int kSum = 0;
        int newKSum = 0;

        int maxSum = 0;
        int maxKSum = 0;

        for (int i = 0; i < M; i++) {

            kSum = 0;

            for (int j = 0; j <= K - 1; j++) {
                kSum += data[i][j];
            } //inner loop
            for (int j = K; j <= N - 1; j++) {
                kSum = kSum - data[i][j - K] + data[i][j];
                if (newKSum < kSum) {
                    newKSum = kSum;
                }
            } // inner loop
            data[i][N + 1] = newKSum;
            maxSum = maxSum + data[i][N];
            if (maxKSum < data[i][N+1]){
                maxKSum = data[i][N+1];
            }
        } //outerloop

        System.out.println(maxSum + maxKSum);

    }
}
