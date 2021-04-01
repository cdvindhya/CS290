package Topic9;

import java.io.*;
import java.util.*;

public class Escapee {

    //init global
    static int[][] A = new int[50][50];
    static int[][] dist = new int[50][50];
    static int[][] traps;
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {1, 0, -1, 0};

    static int K;

    public static void main(String[] args) {

        //populate A array
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                A[i][j] = 0;
            }
        }

        //populate dist array
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        //init local
        Scanner in = new Scanner(System.in);
        K = in.nextInt();
        traps = new int[K][5];

        //store trap values
        for (int i = 0; i < K; i++) {
            traps[i][0] = in.nextInt();
            traps[i][1] = in.nextInt();
            traps[i][2] = in.nextInt();
            traps[i][3] = in.nextInt();
            traps[i][4] = in.nextInt();
        }

        //sort trap by first column
        Arrays.sort(traps, Comparator.comparing(o -> o[0]));

        //call helper + print result
        System.out.println(solve());

    }

    //helper functions
    public static int solve() {
        Deque <int[]> q = new ArrayDeque<>();
        int tCur = 0;
        q.addLast(new int[]{0, 0});
        dist[0][0] = 0;
        //added
        A[0][0] = 1;
        //added

        int ti = 0; //row in traps
        int t = traps[0][0];
        int x1 = traps[0][1];
        int y1 = traps[0][2];
        int x2 = traps[0][3];
        int y2 = traps[0][4];

        while (t == 0) {
            for(int P = x1; P <= x2; P++) {
                for (int Q = y1; Q <= y2; Q++) {
                    A[P][Q] = -1;
                }//endfor
            } //endfor
            ti++;
            if (ti < K) {
                t = traps[ti][0];
                x1 = traps[ti][1];
                y1 = traps[ti][2];
                x2 = traps[ti][3];
                y2 = traps[ti][4];
            } else {
                break;
            }//endif
        } //endwhile

        while (!q.isEmpty()) {
            int[] x = q.removeFirst();
            int i = x[0], j = x[1], d = dist[i][j];
            tCur = d + 1;

            while (t == tCur) {
                for(int P = x1; P <= x2; P++) {
                    for (int Q = y1; Q <= y2; Q++) {
                        A[P][Q] = -1;
                    }//endfor
                } //endfor
                ti++;
                if (ti < K) {
                    t = traps[ti][0];
                    x1 = traps[ti][1];
                    y1 = traps[ti][2];
                    x2 = traps[ti][3];
                    y2 = traps[ti][4];
                } else {
                    break;
                }//endif
            } //endwhile

            for (int L = 0; L < 4; L++) {
                int ni = i + dx[L], nj = j + dy[L];
                if (ni == 49 && nj == 49) {
                    return d + 1;
                }//endif
                if (0 <= ni && ni <= 49 && 0 <= nj && nj <= 49 && A[ni][nj] == 0) {
                    if (dist[ni][nj] == Integer.MAX_VALUE) {
                        q.addLast(new int[]{ni, nj});
                        dist[ni][nj] = d + 1;
                        A[ni][nj] = 1;
                        //tCur++;

                        //taken

                    }//endif
                }//endif
            } //endfor
        } //endwhile

        return -1;

    }


}
