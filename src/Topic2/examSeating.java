package Topic2;

import java.util.*;

public class examSeating {
    public static void main(String[] args) {
        //distance value: smallest number of empty seats
        // between this seat and any other occupied seat
        //same distance value = choose seat with smaller no
        //When there is no seat that has Distance Value 2
        // or higher, the person is turned away and not seated.

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        ArrayList<int[]> set = new ArrayList<>();
        String[] names = new String[N];

        set.add(new int[]{0, N-1});

        String line = "";
        int prev_id = 0;
        int id = 0;

        for (int i = 0; i < N; i++) {

            int[] pair = set.remove(0);

            line = in.next();
            line = line + " " + in.next();

            if (i == 1) {
                names[N - 1] = line;
                set.add(new int[]{prev_id + 1, pair[1]-1});
            } else if (i == 2) {
                names[0] = line;
                set.add(new int[]{1, prev_id - 1}); //
            } else {
                id = (pair[1] - pair[0])/2;
                prev_id = id;
                names[id] = line;
                if (pair[0] < id && id - pair[0] > 2) {
                    set.add(new int[]{pair[0], id - 1});
                } else {
                    break;
                }
                if (id < pair[1] && pair[1] - id > 2) {
                    set.add(new int[]{id + 1, pair[1]});
                } else {
                    break;
                }
            }

            set.sort(new Comparator<int[]>() {
                public int compare(int[] o2, int[] o1) {
                    return ((o2[1] - o2[0])-(o1[1]-o1[0]));
                }
            });

            line = "";

        }

        System.out.println();

        for (int k = 0; k < names.length; k++) {
            if (names[k] != null) {
                System.out.println(k+1 + ": " + names[k]);
            }
        }

    }

}
