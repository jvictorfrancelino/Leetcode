package strings.countCharacters;


public class Main {
    public static void main(String[] args) {

        // n = 10_000, 100_000, 1_000_000
        String n = bigString(1_000);
        System.out.printf("%nCount characters with brute force: ");
        long t3 = System.nanoTime();
        System.out.println(countCharactersBruteForce(n));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t3) / 1_000_000.0);
    }

    static String bigString(int n) {
        char[] a = new char[n];
        for (int i = 0; i < n; i++) a[i] = (char) ('a' + (i % 26));
        return new String(a);
    }

    static int countCharactersBruteForce(String s) {
        if (s == null || s.length() <= 1) return 0;
        return s.length();
    }

}