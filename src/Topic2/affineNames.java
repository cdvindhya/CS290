package Topic2;

import java.util.*;

public class affineNames {
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       int N = in.nextInt();

       HashMap<String, ArrayList<String>> map = new HashMap<>();

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
           //String prev_string = "";
           ArrayList<String> allMatches = new ArrayList<>();
           String check = "";


           if (map.containsKey(name[0].substring(0, 3).toUpperCase())) {
               for (int j = 0; j < map.get(name[0].substring(0, 3).toUpperCase()).size(); j++) {
                   check = map.get(name[0].substring(0, 3).toUpperCase()).get(j);
                   if(searchName(getInitials(line), check)) {//getInitials(check), line)) {
                       count++;
                       allMatches.add(check);
                   }
               }
           }

           if (map.containsKey(name[1].substring(0, 3).toUpperCase())) {
               for (int j = 0; j < map.get(name[1].substring(0, 3).toUpperCase()).size(); j++) {
                   check = map.get(name[1].substring(0, 3).toUpperCase()).get(j);
                   if(searchName(getInitials(line), check) && !allMatches.contains(check)) {//getInitials(check), line)) {
                       count++;
                       allMatches.add(check);
                   }
               }
           }

           if(map.containsKey(name[2].substring(0, 3).toUpperCase())) {
               for (int j = 0; j < map.get(name[2].substring(0, 3).toUpperCase()).size(); j++) {
                   check = map.get(name[2].substring(0, 3).toUpperCase()).get(j);
                   if(searchName(getInitials(line), check) && !allMatches.contains(check)) {//getInitials(check), line)) {
                       count++;
                       allMatches.add(check);
                   }
               }
           }

           //put an entry in the hashmap
           if (map.containsKey(initials.toUpperCase())) {
               map.get(initials.toUpperCase()).add(line);
           } else {
               ArrayList<String> list = new ArrayList<>();
               list.add(line);
               map.put(initials.toUpperCase(), list);
           }

       }

       //return count
       System.out.println(count);

    }

    public static String getInitials(String line) {
        String[] name = line.split(" ");
        String initials = "" + name[0].charAt(0)
                + name[1].charAt(0) + name[2].charAt(0);
        return initials.toUpperCase();
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
