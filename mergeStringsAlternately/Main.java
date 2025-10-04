package mergeStringsAlternately;

public class Main {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        String result = MergeStringsAlternately(word1, word2);
        System.out.println("The first string is: " + word1);
        System.out.println("The second string is: " + word2);
        System.out.println("The result is: " + result);

    }

    public static String MergeStringsAlternately(String word1, String word2){
        if(word1.isEmpty() || word1.isBlank() || word2.isEmpty() || word2.isBlank()){
            return null;
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < word1.length() || i < word2.length()){
            if(i < word1.length()){
                result.append(word1.charAt(i));
            }
            if(i <word2.length()){
                result.append(word2.charAt(i));
            }
            i++;
        }

        return result.toString();
    }
}