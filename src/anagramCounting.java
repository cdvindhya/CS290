import java.util.*;
import java.io.*;

//histogram to count the arrows travelling
//at each height

//map
//different keys can be mapped to same value
//each key is mapped to one value
//array: map from set of int indices to a set of values
//map -> used when you want to count the number of times something appears
//java8 includes the merge function, if the key exists, add another value v
//merge helpful for counting

//set
//not used for multiple instance count

//map: hashmap -> better, treemap

//We say that strings that are anagrams of each other are in the same group.
// Output information of the group with the most strings.

public class anagramCounting {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> max = new ArrayList<>();

        String line = "";

        for (int i = 0; i < N; i++) {
            line = in.next();
            if (!map.containsKey(sortString(line))) {
                ArrayList<String> matched = new ArrayList<>();
                matched.add(line);
                map.put(sortString(line), matched);
            } else {
                map.get(sortString(line)).add(line);
                if (max.size() < map.get(sortString(line)).size()) {
                    max.clear();
                    max = map.get(sortString(line));
                }
            }
        }

        System.out.println(max.size());
        Collections.sort(max);
        for (int k = 0; k < max.size(); k++) {
            System.out.println(max.get(k));
        }

    }

    public static String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static boolean isAnagram(String word, String pattern) {
        char[] str1 = word.toCharArray();
        char[] str2 = pattern.toCharArray();
        //input guaranteed to have same length
        for (int i = 0; i < word.length(); i++)
            if (str1[i] != str2[i])
                return false;
        return true;

    }

}
