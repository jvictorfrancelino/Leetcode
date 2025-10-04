package strings.stringAnagram;


import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        System.out.printf("%nAnagram time with Streams: ");
        System.out.println(isAnagramStreams("I am Lord Voldemort", "Tom Marvolo Riddle"));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t0) / 1_000_000.0);

        long t1 = System.nanoTime();
        System.out.printf("%nAnagram time with sort: ");
        System.out.println(isAnagramSort("I am Lord Voldemort", "Tom Marvolo Riddle"));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t1) / 1_000_000.0);

        long t2 = System.nanoTime();
        System.out.printf("%nAnagram time with hash map: ");
        System.out.println(isAnagramHashMap("I am Lord Voldemort", "Tom Marvolo Riddle"));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t2) / 1_000_000.0);

        long t3 = System.nanoTime();
        System.out.printf("%nAnagram time with count 26: ");
        System.out.println(isAnagramCount26("I am Lord Voldemort", "Tom Marvolo Riddle"));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t3) / 1_000_000.0);

        long t4 = System.nanoTime();
        System.out.printf("%nAnagram time with count 26 and double loop: ");
        System.out.println(isAnagramCount26DoubleLoop("I am Lord Voldemort", "Tom Marvolo Riddle"));
        System.out.printf("%.3f ms%n", (System.nanoTime() - t4) / 1_000_000.0);
    }

    static String normalizeUnicodeLetters(String s) {
        // remove tudo que NÃO é letra (\p{L})
        String onlyLetters = s.replaceAll("[^\\p{L}]", "");
        // opcional: remover acentos (se quiser tratar “á” == “a”)
        String deAccented = Normalizer.normalize(onlyLetters, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
        return deAccented.toLowerCase(Locale.ROOT);
    }

    public static boolean isAnagramStreams(String a, String b) {
        Function<String, Map<Integer, Long>> freq = s ->
                s.codePoints()
                        .filter(Character::isLetter)
                        .map(Character::toLowerCase)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return freq.apply(a).equals(freq.apply(b));
    }

    public static boolean isAnagramSort(String a, String b){
        a = normalizeUnicodeLetters(a);
        b = normalizeUnicodeLetters(b);
        if (a.length() != b.length()) return false;

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);

    }

    public static boolean isAnagramHashMap(String a, String b){
        Map<Integer, Integer> freq = new HashMap<>();
        a.codePoints().filter(Character::isLetter)
                .map(Character::toLowerCase)
                .forEach(cp -> freq.merge(cp, 1, Integer::sum));

        for (int cp : b.codePoints().filter(Character::isLetter).map(Character::toLowerCase).toArray()) {
            Integer v = freq.get(cp);
            if (v == null) return false;
            if (v == 1) freq.remove(cp); else freq.put(cp, v - 1);
        }
        return freq.isEmpty();
    }

    public static boolean isAnagramCount26(String firstWord, String secondWord){
        firstWord = normalizeUnicodeLetters(firstWord);
        secondWord = normalizeUnicodeLetters(secondWord);

        if(firstWord.length() != secondWord.length()) return false;

        int[] cnt = new int[26];

        for (int i = 0; i < firstWord.length(); i++) {
            cnt[firstWord.charAt(i) - 'a']++;
            cnt[secondWord.charAt(i) - 'a']--;
        }

        for (int x : cnt) if (x != 0) return false;
        return true;
    }

    public static boolean isAnagramCount26DoubleLoop(String a, String b) {
        a = normalizeUnicodeLetters(a);
        b = normalizeUnicodeLetters(b);

        if (a.length() != b.length()) return false;

        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }

        for (int x : cnt) if (x != 0) return false;
        return true;
    }
}