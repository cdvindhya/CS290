import java.io.*;
import java.util.*;

public class shift_encrypt {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        //INPUT: cipher text secret word
        //OUTPUT: decrypted og word

        Scanner in = new Scanner(System.in);

        String cipher = in.nextLine();
        String key = in.nextLine();

        /*for(int i = 0; i < alphabet.length(); i++) {
            System.out.print(alphabet.charAt(i) + "=" + i);
            System.out.println();
        }*/

        String message = "";

        if (key.length() > cipher.length()) {
            key = key.substring(0, cipher.length());
        }

        //keep appending when needed
        for(int i = 0; i < cipher.length(); i++) {
            int C = alphabet.indexOf(cipher.charAt(i));
            int K = alphabet.indexOf(key.charAt(i));
            int new_char = C - K;
            new_char = (new_char < 0) ? new_char + 26 : new_char;
            message += alphabet.charAt(new_char);
            key += alphabet.charAt(new_char);
        }

        System.out.println(message);

    }
}
