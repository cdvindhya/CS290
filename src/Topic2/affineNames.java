package Topic2;

import java.util.*;

public class affineNames {
    public static void main(String[] args) {

        //FIXME: Input 2 & Input 4

       Scanner in = new Scanner(System.in);
       int N = in.nextInt();

       int count = 0;

       String[] name = new String[3];
       String[] elements = new String[3];
       String initials = "";

        Set<String> set = new HashSet<>();
        Set<String> rev = new HashSet<>();
        HashMap<String, Integer> triplesCount = new HashMap<>();

       for (int i = 0; i < N; i++) {

           name = new String[3];
           name[0] = in.next();
           name[1] = in.next();
           name[2] = in.next();

           initials = "" + name[0].charAt(0) + name[1].charAt(0) + name[2].charAt(0);

           for (int j = 0; j < 3; j++) { //AAA AAA, AAA ALI
               elements[j] = initials + " " + name[j].charAt(0) + name[j].charAt(1) + name[j].charAt(2);
           }

           for (int j = 0; j < 3; j++) { //AAA AAA, AAA AAA, ATH ALI
               String reverse = elements[j].substring(4, 7) + " " + elements[j].substring(0, 3);
               reverse = reverse.toUpperCase();
               rev.add(reverse);
           } //AAA AAA

           for (String s : rev) {
               if (set.contains(s)) {
                    count++;
               }
           }

           for (int j = 0; j < 3; j++){
               set.add(elements[j].toUpperCase());
               //CHECK IF IT ALREADY EXISTS, AND INCEREMENT ELEMENT COUNT
               //seperate hasmap, maps triples to counts
           }

       }

       /*
       for (String s : rev) {
               if (set.contains(s)) {
                   if (triplesCount.get(s) != null) {
                       count += triplesCount.get(s);
                   } else {
                       count++;
                   }
               }
           }

           for (int j = 0; j < 3; j++){
               if (set.contains(elements[j].toUpperCase())) {
                   if (triplesCount.get(elements[j].toUpperCase()) != null) {
                       triplesCount.replace(elements[j].toUpperCase(), triplesCount.get(elements[j].toUpperCase()) + 1);
                   } else {
                       triplesCount.put(elements[j].toUpperCase(), 2);
                   }
               }
               set.add(elements[j].toUpperCase());
               //CHECK IF IT ALREADY EXISTS, AND INCEREMENT ELEMENT COUNT
               //seperate hasmap, maps triples to counts
           }
        */



       /*name = new String[3];
           name[0] = in.next();
           name[1] = in.next();
           name[2] = in.next();

           String revEntry = "";
           String entry = "";

           initials = "" + name[0].charAt(0) + name[1].charAt(0) + name[2].charAt(0);

           for(int j = 0; j < 3; j++) {
               entry = initials.toUpperCase() + " " + name[j].substring(0, 3).toUpperCase();
               set.add(entry);
           }

           for (int k = 0; k < 3; k++) {
               revEntry = name[k].substring(0, 3).toUpperCase() + " " + initials.toUpperCase();
               if (set.contains(revEntry)) {
                   count++;
               }
           }*/

       /*String revEntry = "";
       for(String entry : set) {
           revEntry = entry.substring(4, 7) + " " + entry.substring(0, 3);
           if (set.contains(revEntry)) {
               count++;
           }
       }*/

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

    /*
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

     */

    /*
    if (map.containsKey(name[0].substring(0, 3).toUpperCase())) {
               Set<String> matchSet = map.get(name[0].substring(0, 3).toUpperCase());
               if (matchSet.contains(initials)) {
                   count++;
               }
           }

           if (!name[0].substring(0, 3).toUpperCase().equals(name[1].substring(0, 3).toUpperCase())) {
               if (map.containsKey(name[1].substring(0, 3).toUpperCase())) {
                   Set<String> matchSet = map.get(name[1].substring(0, 3).toUpperCase());
                   if (matchSet.contains(initials)) {
                       count++;
                   }
               }
           }

           if (!name[2].substring(0, 3).toUpperCase().equals(name[1].substring(0, 3).toUpperCase())
                && !name[2].substring(0, 3).toUpperCase().equals(name[0].substring(0, 3).toUpperCase())) {
               if (map.containsKey(name[2].substring(0, 3).toUpperCase())) {
                   Set<String> matchSet = map.get(name[2].substring(0, 3).toUpperCase());
                   if (matchSet.contains(initials)) {
                       count++;
                   }
               }
           }
     */

}
