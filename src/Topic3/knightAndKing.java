package Topic3;

import java.util.*;
import java.io.*;

public class knightAndKing {

    //MINIMAL PATH SUM
    /*
    - minimize the sum of all the numbers along its path
    - can only move down or right at any point in time
    - setting up the DP table
        -
     */

    public static void main(String[] args) {
        //reading in the input
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();

        int[][] grid = new int[rows][cols];

        in.nextLine();

        String line = "";
        for (int i = 0; i < rows; i++) {
            line = in.nextLine();
            String[] colVal = line.split(" ");
            for (int k = 0; k < cols; k++) {
                grid[i][k] = Integer.parseInt(colVal[k]);
            }
        }

        //call helper
        System.out.println(maxPathSum(grid));

    }

    public static int maxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+2][n+4];
        for (int i = 0; i < m + 2; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int j = 2; j < n + 4; j++) {
            dp[0][j] = Integer.MIN_VALUE;
            dp[1][j] = 0;
        }

        for (int i = 0; i < m + 2; i++) {
            dp[i][n+2] = Integer.MIN_VALUE;
            dp[i][n+3] = Integer.MIN_VALUE;
        }

        for (int i = 2; i < m + 2; i++) {
            for (int j = 2; j < n + 2; j++) {

                int sum = getMax(dp[i - 1][j - 2], dp[i - 1][j + 2],
                            dp[i - 2][j - 1], dp[i - 2][j + 1],
                            dp[i - 1][j - 1], dp[i - 1][j], dp[i-1][j+1]) + grid[i-2][j-2];
                dp[i][j] = sum;

            }
        }

        return getMax(dp[m+1]);
    }

    public static int getMax(int ... args) {
        int max = Integer.MIN_VALUE;
        for (int i : args) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
