package strings.duplicatedWords;

import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        // \\b = Garante que o match comece no inicio de uma palavra (não no meio do texto colado)
        // () = Agrupamento
        // \\w+ = Qualquer caractere "word" (letras maiúsculas/minúsculas, dígitos e underscore)
        // + = Um ou mais caracteres -> Ou seja, pega a palavra inteira

        //(?: ...) = Non-capturing group -> Agrupa a expressão sem criar um novo grupo numerado
        // Está sendo usado só para organizar a lógica, porque o que interessa é apenas o grupo 1 (a primeira palavra encontrada)
        // \\W+ = Um ou mais não-caracteres de palavra (tudo que não é a-zA-Z0-9_)
        // Normalmente captura espaços, vírgulas, pontos etc
        // Isso permite detectar repetições separadas por espaço ou pontuação

        // \\1 = Backreference: refere-se ao conteúdo capturado no grupo 1
        // Isso significa que procura a mesma palavra encontrada antes
        // \\b = Novamente, limite de palavra.
        // Garante que a repetição termine no final da palavra, evitando casos como "abc abcd" serem considerados repetição.

        // + = O grupo inteiro (?:\w\1\b) deve ocorrer uma ou mais vezes
        // Ou seja: a palavra do grupo 1 repetida pelo menos uma vez, separada por espaços/pontuação

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }
        in.close();
    }
}