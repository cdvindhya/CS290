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

        TreeMap<Integer, Character> treeMap = new TreeMap<>();

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
        int lastRemoved = 0;

        if (n == 1) { //what if k > 1?
            System.out.println(1);
            return;
        }

        //populate hash map
        for (int i = 0; i < n; i++) {

            char c = charList.charAt(i);

            if (hash.get(c) == null) { // element not found

                hash.put(c, i);


                treeMap.put(i, c);
                finalPoint = i;

                if (treeMap.size() <= k ) {
                    //size
                    seqSize = finalPoint - initPoint + 1;
                    if (seqSize > maxSize) {
                        maxSize = seqSize;
                    }
                }

            } else { //element found
                int x = hash.get(c);
                hash.replace(c, hash.get(c), i);
                treeMap.remove(x);
                treeMap.put(i, c);
                finalPoint = i;

                //size
                seqSize = finalPoint - initPoint + 1;
                if (seqSize > maxSize) {
                    maxSize = seqSize;
                }

            }

            if (treeMap.size() > k)  { //
                //dq
                rmvd = treeMap.firstEntry().getValue();
                initPoint = treeMap.firstEntry().getKey();
                treeMap.remove(initPoint);
                initPoint++;
                hash.remove(rmvd);
            }

        } //for


        if (finalPoint == n - 1 && treeMap.size() < k) {
            System.out.println(n);
        } else {
            System.out.println(maxSize);
        }

    }
}
