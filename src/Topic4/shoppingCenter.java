package Topic4;

import java.io.*;
import java.util.*;

public class shoppingCenter {
    public static void main(String[] args) {

        // n stores in a row
        // l, r range of stores
            //boring if number of unq products in range <= k
        // output: longest boring range

        Scanner in = new Scanner(System.in);

        //init data structure, variables

        Queue<Character> queue = new LinkedList<>();

        HashMap<Character, Integer> hash = new HashMap<>();

        int n = in.nextInt();
        int k = in.nextInt();

        //read in extra space
        in.nextLine();

        //read in query
        String charList = in.next();

        int initPoint = 0;
        int finalPoint = 0;

        int seqSize = 0;
        int maxSize = 0;

        char rmvd;

        if (n == 1) { //what if k > 1?
            System.out.println(1);
            return;
        }

        //populate hash map
        for (int i = 0; i < 70; i++) {

            char c = charList.charAt(i);

            if (hash.get(c) == null) { // element not found

                hash.put(c, i);

                queue.add(c);
                finalPoint = i;

                if (queue.size() <= k ) {
                    //size
                    seqSize = finalPoint - initPoint + 1;
                    if (seqSize > maxSize) {
                        maxSize = seqSize;
                    }
                }

            } else { //element found
                hash.replace(c, hash.get(c), i);
                finalPoint = i;

                //size
                seqSize = finalPoint - initPoint + 1;
                if (seqSize > maxSize) {
                    maxSize = seqSize;
                }

            }

            if (queue.size() > k)  { //
                //dq
                rmvd = queue.remove();
                int temp = hash.get(rmvd) + 1;
                //if (initPoint < temp) {
                    initPoint = temp;
                //}
                hash.remove(rmvd);
            }

        } //for

        for (int i = 70; i < n; i++) {

            char c = charList.charAt(i);

            if (hash.get(c) == null) { // element not found

                hash.put(c, i);

                queue.add(c);
                finalPoint = i;

                if (queue.size() <= k ) {
                    //size
                    seqSize = finalPoint - initPoint + 1;
                    if (seqSize > maxSize) {
                        maxSize = seqSize;
                    }
                }

            } else { //element found
                hash.replace(c, hash.get(c), i);
                finalPoint = i;

                //size
                seqSize = finalPoint - initPoint + 1;
                if (seqSize > maxSize) {
                    maxSize = seqSize;
                }

            }

            if (queue.size() > k)  { //
                //dq
                rmvd = queue.remove();
                int temp = hash.get(rmvd) + 1;
                //if (initPoint < temp) {
                initPoint = temp;
                //}
                hash.remove(rmvd);
            }

        } //for

        if (finalPoint == n - 1 && queue.size() < k) {
            System.out.println(n);
        } else {
            System.out.println(maxSize);
        }

    }
}
