package strings.stringTokens;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String[] words = s.trim().split("[^a-zA-Z]+");

        if(s.isEmpty() || s.isBlank()){
            System.out.println("0");
            return;
        }

        System.out.println(words.length);

        for(String word : words){
            System.out.println(word);
        }


    }
}