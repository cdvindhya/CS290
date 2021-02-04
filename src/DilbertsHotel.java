import java.util.*;
import java.io.*;

public class DilbertsHotel {

    //Professor's Sorting Method
    static void sort2DInt(int[][] array) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                for (int i=0; i<a.length; i++) {
                    if (a[i] < b[i])       return -1;
                    else if (a[i] > b[i])  return 1;
                }
                return 0;
            }
        };
        Arrays.sort(array, comp);
    }

    public static void main(String[] args) {

        //Input:
        //N=number of groups
        //A = number of rooms needed B = day C = number of nights

        //Output:
        //R = minimum number of rooms

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int j = 0;
        int[][] t = new int[2*N][2];

        for (int i = 0; i < N; i++) { //O(N)
            int diff = in.nextInt();
            int day = in.nextInt();
            int nights = in.nextInt();
            t[j][0] = day;
            t[j][1] = diff;
            j++;
            t[j][0] = day + nights;
            t[j][1] = (-1)*diff;
            j++;
        }

        sort2DInt(t);
        int sum = 0;
        int R = 0;
        for (int i = 0; i < 2*N; i++) { //O(2N)
            sum += t[i][1];
            if (sum > R) {
                R = sum;
            }
        }

        System.out.println(R);

    }
}
