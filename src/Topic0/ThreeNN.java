import java.io.*;
import java.util.*;

public class ThreeNN {

    public static long binarySearch(ArrayList<Long> listFeatures, HashMap<Long, Integer> classValues, long target, int l, int r) {

        long sum = 0;
        int mid = l + (r-l)/2;

        if (target >= listFeatures.get(listFeatures.size() - 1) || listFeatures.size() == 3) {
            sum = classValues.get(listFeatures.get(listFeatures.size() - 1))
                    + classValues.get(listFeatures.get(listFeatures.size() - 2))
                    + classValues.get(listFeatures.get(listFeatures.size() - 3));
            return sum;
        } else if (target <= listFeatures.get(0)) {
            sum = classValues.get(listFeatures.get(0))
                    + classValues.get(listFeatures.get(1))
                    + classValues.get(listFeatures.get(2));
            return sum;
        }

        long val1 = 0;
        long val2 = 0;
        long val3 = 0;
        long val4 = 0;
        long val5 = 0;
        long val6 = 0;

        if (listFeatures.get(mid) == target) {

            if (mid - 2 >= 0) {
                val1 = Math.abs(target - listFeatures.get(mid - 2));
            }

            val2 = Math.abs(target - listFeatures.get(mid - 1));
            val3 = Math.abs(target - listFeatures.get(mid + 1));

            if (mid + 2 < listFeatures.size()) {
                val4 = Math.abs(target - listFeatures.get(mid + 2));
            }

            if (val1 < val3 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 1));
            } else if (val1 == val3 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid + 1));
            } else if (val1 > val3 && val4 > val2 && (mid + 2 < listFeatures.size()) && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid + 1));
            } else if (val4 < val2 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2));
            } else if (val4 == val2 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2)) + classValues.get(listFeatures.get(mid - 1));
            } else {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid - 1));
            }

            /*sum = classValues.get(listFeatures.get(mid))
                    + classValues.get(listFeatures.get(mid + 1))
                    + classValues.get(listFeatures.get(mid - 1));*/

        } else if (listFeatures.get(mid-1) < target && target < listFeatures.get(mid)) {

            val3 = Math.abs(target - listFeatures.get(mid - 1));
            if (mid - 3 >= 0) {
                val1 = Math.abs(target - listFeatures.get(mid - 3));
            }

            if (mid - 2 >= 0) {
                val2 = Math.abs(target - listFeatures.get(mid - 2));
            }

            val4 = Math.abs(target - listFeatures.get(mid));
            val5 = Math.abs(target - listFeatures.get(mid + 1));

            if (mid + 2 < listFeatures.size()) {
                val6 = Math.abs(target - listFeatures.get(mid + 2));
            }

            if (val1 < val4 && (mid - 3 >= 0)) {
                sum = classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 3));
            } else if (val1 == val4 && (mid - 3 >= 0)) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 3));
            } else if (val2 < val5 && (mid - 2 >= 0) && (val6 == 0 || (val3 < val6 && (mid + 2 < listFeatures.size())))) {
                sum = classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid));
            } else if (val2 == val5 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1));
            } else if (val5 < val2 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1));
            } else if (val6 < val3 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2));
            } else if (val6 == val3 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2));
            } else {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid - 1));
            }

            /*if (Math.abs(target - listFeatures.get(mid-2)) < Math.abs(target - listFeatures.get(mid + 1))) {
                sum = classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid - 1))
                        + classValues.get(listFeatures.get(mid - 2));
            } else if(Math.abs(target - listFeatures.get(mid-2)) > Math.abs(target - listFeatures.get(mid + 1))) {
                sum = classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid - 1))
                        + classValues.get(listFeatures.get(mid + 1));
            } else {
                sum = classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid - 1))
                        + classValues.get(listFeatures.get(mid + 1))
                        + classValues.get(listFeatures.get(mid - 2));
            }*/

        } else if(listFeatures.get(mid) < target && target < listFeatures.get(mid+1)) {

            val2 = Math.abs(target - listFeatures.get(mid - 1));
            val3 = Math.abs(target - listFeatures.get(mid));
            val4 = Math.abs(target - listFeatures.get(mid + 1));

            if (mid - 2 >= 0) {
                val1 = Math.abs(target - listFeatures.get(mid - 2));
            }

            if (mid + 2 < listFeatures.size()) {
                val5 = Math.abs(target - listFeatures.get(mid + 2));
            }

            if (mid + 3 < listFeatures.size()) {
                val6 = Math.abs(target - listFeatures.get(mid + 3));
            }

            if (val1 < val4 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid - 2));
            } else if (val1 == val4 && (mid - 2 >= 0)) {
                sum = classValues.get(listFeatures.get(mid - 2)) + classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid) + classValues.get(listFeatures.get(mid + 1)));
            } else if (val2 < val5 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1));
            } else if (val2 == val5 && (mid + 2 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid - 1)) + classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2));
            } else if (val5 < val2 && (mid + 2 < listFeatures.size()) && (val6 == 0 || (val6 > val3 && (mid + 3 < listFeatures.size())))) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2));
            } else if (val6 < val3 && (mid + 3 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2)) + classValues.get(listFeatures.get(mid + 3));
            } else if (val6 == val3 && (mid + 3 < listFeatures.size())) {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid + 2)) + classValues.get(listFeatures.get(mid + 3));
            } else {
                sum = classValues.get(listFeatures.get(mid)) + classValues.get(listFeatures.get(mid + 1)) + classValues.get(listFeatures.get(mid - 1));
            }

            /*if (Math.abs(target - listFeatures.get(mid-1)) < Math.abs(target - listFeatures.get(mid + 2))) {
                sum = classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid + 1))
                        + classValues.get(listFeatures.get(mid - 1));
            } else if(Math.abs(target - listFeatures.get(mid+2)) < Math.abs(target - listFeatures.get(mid - 1))) {
                sum = classValues.get(listFeatures.get(mid + 1))
                        + classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid + 2));
            } else {
                sum = classValues.get(listFeatures.get(mid))
                        + classValues.get(listFeatures.get(mid + 1))
                        + classValues.get(listFeatures.get(mid + 2))
                        + classValues.get(listFeatures.get(mid - 1));
            }*/

        } else if (target < listFeatures.get(mid)){
            return binarySearch(listFeatures, classValues, target, l, mid);
        } else {
            return binarySearch(listFeatures, classValues, target, mid, r);
        }

        return sum;

    } //binarySearch

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int Q = in.nextInt();

        if(N < 3 || N > 10000) {
            return;
        }

        if(Q < 1 || Q > 10000) {
            return;
        }

        HashMap<Long, Integer> classValues = new HashMap<>(N - 1);
        ArrayList<Long> listFeatures = new ArrayList<>(N - 1);

        long feature = 0;

        for(int i = 0; i < N; i++) {
            feature = in.nextLong();
            listFeatures.add(feature);
            classValues.put(feature, in.nextInt());
        }

        long[] queries = new long[Q];
        for (int k = 0; k < Q; k++) {
            queries[k] = in.nextLong();
        }

        long sum = 0;
        Collections.sort(listFeatures);

        for(int j = 0; j < Q; j++) {
            sum = (binarySearch(listFeatures, classValues, queries[j], 0, listFeatures.size()));
            if(sum >= 1) {
                System.out.print(1);
            } else if(sum == 0) {
                System.out.print(0);
            } else {
                System.out.print(-1);
            }
            if (j != Q - 1) {
                System.out.print(" ");
            }
        }

    } //main
}
