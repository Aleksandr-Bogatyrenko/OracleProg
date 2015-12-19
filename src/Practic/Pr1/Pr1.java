package Practic.Pr1;


import java.util.ArrayList;

/**
 * Created by Александр on 13.11.2015.
 */
public class Pr1 {
    public static void main(String[]args){

        String vowels = "аяоёыиэеую";
        String text = "кабриолет.";

        ArrayList<String> parts = new ArrayList<String>();

        int p = 0;

        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) > -1) {
                parts.add(text.substring(p, i+1));
                p = i+1;
            }
        }

        if (p < vowels.length()) {
            parts.add(text.substring(p, vowels.length()));
        }

        for(String part: parts) {
            System.out.print("'" + part + "', ");
        }
        System.out.println();

    }
}
