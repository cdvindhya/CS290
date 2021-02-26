package Topic3;

import java.util.*;
import java.io.*;

//l = i, j //r = i2, j2 //r+1 = i2,

//each rectangle, += its weight to blocks in range
//refer to matrix block sum to do this
//updating a difference matrix
//update only the boundaries
                    /*
                    +2          -2
                    -2          +2
                     */
//then loop through the entire 2d array
//count blocks whose weight == K

//compute prefix sum of diff array

public class rectanglesCounting {
    public static void main(String[] args) {

        /*
        You are asked to find out the total
        amount of area that has a total weight
        K. Each unit area could be covered
        by multiple rectangles and the weight
        for each unit area equals the sum
        of weights of rectangles that
        cover this unit area.
         */

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //number of rows
        int K = in.nextInt(); //value

        in.nextLine();

        //create a 2D array coordinate plane
        int[][] grid = new int[1000][5];

        //diff array = 1 + size of initial matrix
        int[][] diff = new int[1000][1000];

        //initDiff(diff, N, grid);

        for (int i = 0; i < N; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int W = in.nextInt();

            updateDiff(diff, x1, y1, x2, y2, W);
        }

        int areaCount = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (diff[i][j] == K) {
                    areaCount++;
                }
            }
        }

        System.out.println("Area Covered = " + areaCount);

    }

    public static void updateDiff(int[][] diff, int x1, int y1, int x2, int y2, int W) {

        //Y ARE THE ROWS, X ARE THE COLUMNS

        diff[x1][y2 - 1] += W;
        if (y1 - 1 >= 0 && x2 < 1000) {
            diff[x2][y1 - 1] += W;
        }
        if (y1 - 1 >= 0) {
            diff[x1][y1 - 1] -= W;
        }
        if (x2 < 1000) {
            diff[x2][y2 - 1] -= W;
        }

        diff = computePrefix(diff);

        /*for(int i = x1; i < x2; i++) //<=
        {
            diff[i][y1] += W;
            diff[i][y2] -= W;
        }

        for (int i = 0; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length - 2; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }*/

    }

    public static int[][] computePrefix(int[][] diff) {

        int psa[][] = new int[diff.length][diff[0].length];
        // Filling first row and first column

        for (int i = 1; i < diff[0].length; i++)
            psa[0][i] = psa[0][i - 1] + diff[0][i];

        for (int i = 1; i < diff.length; i++)
            psa[i][0] = psa[i - 1][0] + diff[i][0];

        // updating the values in the
        // cells as per the general formula.
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[0].length; j++) {

                // values in the cells of new array
                // are updated
                psa[i][j] = psa[i - 1][j] + psa[i][j - 1]
                        - psa[i - 1][j - 1] + diff[i][j];
            }
        }

        return psa;

    }

    public static void initDiff(int[][] diff, int N, int[][] grid) {
        //initialize diff
        for (int i = 0; i < N; i++) {
            diff[i][0] = grid[i][0];
            diff[i][5] = 0;
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 1; j < 5; j++)
                diff[i][j] = grid[i][j] - grid[i][j - 1];
        }
    }

}
