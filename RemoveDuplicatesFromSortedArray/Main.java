package RemoveDuplicatesFromSortedArray;

public class Main {
    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String LongestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        // Começa com o prefixo sendo a primeira palavra
        String prefix = strings[0];

        // Itera sobre o array de strings comparando com o prefixo
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                // Encurta o prefixo até que ele corresponda ao início da palavra atual
                prefix = prefix.substring(0, prefix.length() - 1);

                // Se o prefixo for esvaziado, não há prefixo comum
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}