import java.util.Scanner;

public class volleyball_scoring {
    public static void main(String[] args) {
        //INPUT: no of input cases, N lines -> S, S values
        //A always starts serving
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println();
        for (int i = 0; i < N; i++) {
            int S = in.nextInt();
            String[] matches= in.nextLine().split(" ");
            int scoreA = 0;
            int scoreB = 0;

            if (matches[1].equals("A")) {
                scoreA++;
            }

            for (int j = 1; j < S; j++) {
                if(matches[j].equals(matches[j+1]) && matches[j].equals("A")) {
                    scoreA++;
                } else if(matches[j].equals(matches[j+1]) && matches[j].equals("B")) {
                    scoreB++;
                }

                if ((scoreA >= 15 || scoreB >= 15) && (Math.abs(scoreA - scoreB) >= 2)) {
                    break;
                }
            }
            if (scoreA > scoreB && scoreA >= 15 && (scoreA - scoreB >= 2)) {
                System.out.println("Match " + (i+1) + ": Team A has won the match with a score of " + scoreA + "-" + scoreB + ".");
            } else if (scoreB > scoreA && scoreB >= 15 && (scoreB - scoreA >= 2)) {
                System.out.println("Match " + (i+1) + ": Team B has won the match with a score of " + scoreA + "-" + scoreB + ".");
            } else {
                System.out.println("Match " + (i+1) + ": The score is " + scoreA + "-" + scoreB + ".");
            }
        }
    }
}
