package strings.stringPalindrome;


public class Main {

    public static void main(String[] args) {
        long t0 = System.nanoTime();
        System.out.println(isPalindromeBruteForce("saippuakivikauppias"));
        System.out.printf("Palindrome Brute Force: %.3f ms%n", (System.nanoTime() - t0) / 1_000_000.0);

        long t1 = System.nanoTime();
        System.out.println(isPalindromeStringBuilder("saippuakivikauppias"));
        System.out.printf("Palindrome String Builder: %.3f ms%n", (System.nanoTime() - t1) / 1_000_000.0);

        long t2 = System.nanoTime();
        System.out.println(isPalindromeTwoPointers("saippuakivikauppias"));
        System.out.printf("Palindrome Two Pointers: %.3f ms%n", (System.nanoTime() - t2) / 1_000_000.0);

        long t3 = System.nanoTime();
        System.out.println(isPalindromeRecursive("saippuakivikauppias"));
        System.out.printf("Palindrome Recursive: %.3f ms%n", (System.nanoTime() - t3) / 1_000_000.0);

    }

    public static boolean isPalindromeBruteForce(String word) {
        String invertedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            invertedWord += word.charAt(i);
        }
        return word.equalsIgnoreCase(invertedWord);

    }

    public static boolean isPalindromeStringBuilder(String word) {
        String invertedWord = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(invertedWord);
    }

    public static boolean isPalindromeTwoPointers(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (Character.toLowerCase(word.charAt(i)) !=
                    Character.toLowerCase(word.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String word){
        if (word.length() <= 1 ) return true;
        if (Character.toLowerCase(word.charAt(0)) !=
        Character.toLowerCase(word.charAt(word.length() - 1 ))){
            return false;
        }
        return isPalindromeRecursive(word.substring(1, word.length() - 1));
    }
}