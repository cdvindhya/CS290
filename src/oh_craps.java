import java.io.*;
import java.util.*;

public class oh_craps {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int line_count = 1;

        ArrayList<Integer> P = new ArrayList<>();
        P.add(4);
        P.add(5);
        P.add(6);
        P.add(8);
        P.add(9);
        P.add(10);

        while (in.hasNextLine()) {
            int bankroll = 0;
            String[] sequence = in.nextLine().split(" ");
            int[] roll = new int[sequence.length];
            for (int i = 0; i < sequence.length; i++) {
                roll[i] = Integer.parseInt(sequence[i]);
            }

            ArrayList<Integer> bets = new ArrayList<>();

            for (int j = 0; j < roll.length - 1; j++) {
                if (roll[j] == 2 || roll[j] == 3 || roll[j] == 12) {
                    bankroll--;
                } else if (P.contains(roll[j])) {
                    if (bets.contains(roll[j])) {
                        bets.remove(bets.indexOf(roll[j]));
                        bankroll++;
                    }
                    bets.add(roll[j]);
                } else if (roll[j] == 11) {
                    bankroll++;
                } else if (roll[j] == 7) {
                    bankroll++;
                    for (int k = 0; k < bets.size(); k++) {
                        bankroll--;
                    }
                    bets.clear();
                }
            }
            if (bankroll == 0) {
                System.out.println("Sequence " + line_count + ": Break even.");
            } else if (bankroll < 0) {
                System.out.println("Sequence " + line_count + ": Loss of $" + bankroll + ".");
            } else {
                System.out.println("Sequence " + line_count + ": Win of $" + bankroll + ".");
            }
            line_count++;
        }

        in.close();

    }
}
