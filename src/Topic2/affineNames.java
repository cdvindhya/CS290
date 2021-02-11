package Topic2;

import java.util.*;

public class affineNames {
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       int N = in.nextInt();

       HashMap<String, String> map = new HashMap<>();

       int count = 0;

       for (int i = 0; i < N; i++) {
           //read in value
           String[] name = new String[3];
           name[0] = in.next();
           name[1] = in.next();
           name[2] = in.next();

           String line = name[0] + " " + name[1]  + " " + name[2];
           String initials = getInitials(line);

           //check if anything matches
           if (map.containsKey(name[0].substring(0, 3).toUpperCase())) {
               String check = map.get(name[0].substring(0, 3).toUpperCase());
               if(searchName(getInitials(line), check)) {//getInitials(check), line)) {
                   count++;
               }
           } else if (map.containsKey(name[1].substring(0, 3).toUpperCase())) {
               String check = map.get(name[1].substring(0, 3).toUpperCase());
               if(searchName(getInitials(line), check)) {//getInitials(check), line)) {
                   count++;
               }
           } else if(map.containsKey(name[2].substring(0, 3).toUpperCase())) {
               String check = map.get(name[2].substring(0, 3).toUpperCase());
               if(searchName(getInitials(line), check)) {//getInitials(check), line)) {
                   count++;
               }
           }

           //put an entry in the hashmap
           map.put(initials, line);

       }

       //return count
       System.out.println("Count: " + count);

    }

    public static String getInitials(String line) {
        String[] name = line.split(" ");
        String initials = "" + name[0].charAt(0)
                + name[1].charAt(0) + name[2].charAt(0);
        return initials;
    }

    public static boolean searchName(String initials, String name2) {
        String[] splitName = name2.split(" ");
        if (splitName[0].substring(0, 3).toUpperCase().equals(initials)) {
            return true;
        } else if (splitName[1].substring(0, 3).toUpperCase().equals(initials)) {
            return true;
        } else if (splitName[2].substring(0, 3).toUpperCase().equals(initials)) {
            return true;
        }
        return false;
    }

}
