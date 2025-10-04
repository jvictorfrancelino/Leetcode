package strings.reverseString;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // n = 10_000, 100_000, 1_000_000
        String n = bigString(100_000);

//        System.out.printf("%nReverse String with recursive substring: ");
//        long t1 = System.nanoTime();
//        System.out.println(reverseRecursiveSubstring(n));
//        System.out.printf("%.3f ms%n", (System.nanoTime() - t1) / 1_000_000.0);

//        System.out.printf("%nReverse String with concat: ");
//        long t2 = System.nanoTime();
//        System.out.println(reverseConcat(n));
//        System.out.printf("%.3f ms%n", (System.nanoTime() - t2) / 1_000_000.0);

        System.out.printf("%nReverse String with streams reduce: ");
        long t3 = System.nanoTime();
        reverseStreamsReduce(n);
        System.out.printf("%.3f ms%n", (System.nanoTime() - t3) / 1_000_000.0);

//        System.out.printf("%nReverse String with collections: ");
//        long t4 = System.nanoTime();
//        System.out.println(reverseWithCollections(n));
//        System.out.printf("%.3f ms%n", (System.nanoTime() - t4) / 1_000_000.0);

        System.out.printf("%nReverse String with string buffer: ");
        long t5 = System.nanoTime();
        reverseStringBuffer(n);
        System.out.printf("%.3f ms%n", (System.nanoTime() - t5) / 1_000_000.0);

        System.out.printf("%nReverse String with two pointers: ");
        long t6 = System.nanoTime();
        reverseTwoPointers(n);
        System.out.printf("%.3f ms%n", (System.nanoTime() - t6) / 1_000_000.0);

        System.out.printf("%nReverse String with string builder: ");
        long t7 = System.nanoTime();
        reverseStringBuilder(n);
        System.out.printf("%.3f ms%n", (System.nanoTime() - t7) / 1_000_000.0);

    }

    static String bigString(int n) {
        char[] a = new char[n];
        for (int i = 0; i < n; i++) a[i] = (char) ('a' + (i % 26));
        return new String(a);
    }

    static String reverseRecursiveSubstring(String s) {
        if (s == null || s.length() <= 1) return s;
        return reverseRecursiveSubstring(s.substring(1)) + s.charAt(0);
    }

    static void reverseConcat(String s) {
        String r = "";
        for (int i = s.length() -1; i >= 0; i--){
            r = r + s.charAt(i);
        }
    }

    static void reverseStreamsReduce(String s) {
        s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (acc, ch) -> ch + acc);
    }

    static void reverseWithCollections(String s) {
        List<Character> list = new ArrayList<>(s.length());
        for (char c : s.toCharArray()) list.add(c);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : list) sb.append(c);
    }

    static void reverseStringBuffer(String s){
        new StringBuffer(s).reverse().toString();
    }

    static void reverseTwoPointers(String s) {
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }
        new String(a);
    }

    static void reverseStringBuilder(String s) {
        new StringBuilder(s).reverse().toString();
    }
}