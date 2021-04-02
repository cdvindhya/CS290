package Topic9;

import java.io.*;
import java.util.*;

public class FearIsCatching {

    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {1, 0, -1, 0};

    static int[][] grid;
    static int[][] dist;

    static int A;
    static int M;
    static int N;

    //main function call
    public static void main(String[] args) {
        //initializations
        Scanner in = new Scanner(System.in);
        M = in.nextInt(); //rows
        N = in.nextInt(); //cols
        A = in.nextInt(); //critical threshold
        //if A or more soldiers are in fear, the phalanx collapses

        //populate grid
        grid = new int[M][N];
        String soldiers = "";
        for (int i = 0; i < M; i++) {
            soldiers = in.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = Character.getNumericValue(soldiers.charAt(j));
            }
        }

        dist = new int[M][N];

        //call helper
        int result = solve();

        //output result
        if (result == -1) {
            System.out.println("To victory and beyond!");
        } else {
            System.out.println(result);
        }

    }

    //helper functions
    public static int solve() {

        Deque<int[]> q = new ArrayDeque<int[]>();
        int fearCount = 0;
        int t = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    q.addLast(new int[] {i, j, t});
                    grid[i][j] = 6;
                    dist[i][j] = 6;
                    fearCount++;
                    if (fearCount >= A) {
                        return t;
                    }
                }
            }//endfor
        }//endfor

        int adjCount = 0;

        while (!q.isEmpty()) {
            int[] x = q.removeFirst();

            int i = x[0];
            int j = x[1];
            int tCur = x[2];

            t = tCur;

            int F = 0;
            int C = 0;

            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k], nj = j + dy[k];

                if (!(0 <= ni && ni < M && 0 <= nj && nj < N)) {
                    continue;
                }

                if (dist[ni][nj] != 6) {
                    dist[ni][nj]++;
                    F = dist[ni][nj];
                    C = grid[ni][nj];

                    if ((ni == 0 && nj == 0)
                            || (ni == 0 && nj == N - 1)
                            || (ni == M - 1 && nj == 0)
                            || (ni == M - 1 && nj == N - 1)) {
                        adjCount = 2;
                    } else if ((ni == 0 && nj < N - 1)
                            || (nj == 0 && ni < M - 1)
                            || (nj == N - 1 && ni < M - 1)
                            || (ni == M - 1 && nj < N - 1)) {
                        adjCount = 3;
                    } else {
                        adjCount = 4;
                    }

                    //}

                    double ans = (adjCount * (C / 4.0));

                    if (ans <= F) {
                        q.addLast(new int[]{ni, nj, t + 1});
                        dist[ni][nj] = 6;
                        grid[ni][nj] = 6;
                        fearCount++;
                        if (fearCount >= A) {
                            return t + 1;
                        }

                    }
                }

            }//end for
        }//end while

        return -1;
    }

}
