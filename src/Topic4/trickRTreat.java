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

        //monotonically decreasing queue
        //monotonic stack

        //reading in the data
        int[][] data = new int[M*N][2];
        for (int i = 0; i < M*N; i++) {
            data[i][0] = in.nextInt(); //taste sore
            data[i][1] = in.nextInt(); //spare plan
        }

        //efficient: sliding window: sliding window of length K

        //logic:
            // find the window of length k of consec 1's
            // with the largest taste sum.
            // calculate total sum, sparing the above houses.

        //if k > m*n, spare all houses, calc total sum

        int sum = 0;
        int max = 0;

        int housesPassed = 0;
        int streetsPassed = 0;

        for (int i = 0; i < data.length; i++) {

            sum = 0;

            if (data[i][1] == 1) {

                for (int j = 0; j < K; j++) {

                    //update sum
                    i = i + j;
                    if (data[i][1] == 1 && i < data.length) {
                        sum += data[i][0];
                    }

                    //check streets
                    housesPassed ++;
                    if (housesPassed == N) {
                        streetsPassed++;
                        i = N*streetsPassed - 1;
                        housesPassed = 0;
                        break;
                    }

                }

                if (sum > max) {
                    max = sum;
                }

            } else {

                //check streets
                housesPassed ++;
                if (housesPassed == N) {
                    streetsPassed++;
                    i = N*streetsPassed - 1;
                    housesPassed = 0;
                    break;
                }

            }

        }

        int totalSum = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i][1] == 0) {
                totalSum += data[i][0];
            }
        }

        totalSum += max;

        System.out.println(totalSum);

    }
}

/*  System.out.println(75+100+30+30);
    int lost = 25 + 70 + 70 + 70;
    int marks = 1000 - lost;
    System.out.println("marks: " + marks);
*/
