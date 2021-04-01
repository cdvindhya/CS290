package Topic9;

import java.util.*;
public class KnightCapture {

    static final int[] dx = {-2, -2, -1, 1, -1, 1, 2, 2};
    static final int[] dy = {-1, 1, -2, -2, 2, 2, -1, 1};

    static int r1, c1;
    static int r2, c2;

    static int[][] dist;

    //main function call
    public static void main(String[] args) {
        //initializations
        Scanner in = new Scanner(System.in);

        String pos = in.nextLine();
        int[][] knight_pos = new int[1][2];
        knight_pos[0][0] = 8 - Character.getNumericValue(pos.charAt(1));
        knight_pos[0][1] = Character.getNumericValue(pos.charAt(0)) - 10;

        pos = in.nextLine();
        int[][] pawn_pos = new int[1][2];
        pawn_pos[0][0] = 8 - Character.getNumericValue(pos.charAt(1));
        pawn_pos[0][1] = Character.getNumericValue(pos.charAt(0)) - 10;

        //test input
        //System.out.println("KNIGHT = " + "X:" + knight_pos[0][0] + " Y:" + knight_pos[0][1]);
        //System.out.println("PAWN = " + "X:" + pawn_pos[0][0] + " Y:" + pawn_pos[0][1]);

        //method
        r1 = knight_pos[0][0];
        c1 = knight_pos[0][1];
        r2 = pawn_pos[0][0];
        c2 = pawn_pos[0][1];

        dist = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        //output
        System.out.println(solve());
    }

    //helper functions
    public static int solve() {
        Deque <int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {r1, c1});
        dist[r1][c1] = 0;
        while (!q.isEmpty()) {
            int[] x = q.removeFirst();
            int i = x[0], j = x[1], d = dist[i][j];

            for (int k = 0; k < 8; k++) {
                int ni = i + dx[k], nj = j + dy[k];
                if (ni == r2 && nj == c2) {
                    return d + 1;
                }
                if (0 <= ni && ni < 7 && 0 < nj && nj < 7) {
                    q.addLast(new int[] {ni, nj});
                    dist[ni][nj] = d + 1;
                }
            }

        }

        return -1;
    }
}
