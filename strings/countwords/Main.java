package strings.countwords;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(CountWords(new String[]{"the", "dog", "got", "the", "bone"}));
    }

    public static ArrayList<Integer> CountWords(String[] words) {
        Map<String, Integer> contagem = new HashMap<>();
        ArrayList<Integer> valores = new ArrayList<>();
        for(String word: words){
            if(!contagem.containsKey(word)){
                contagem.put(word, 1);
            }else{
                contagem.put(word, contagem.get(word) + 1);
            }
        }
        valores.addAll(contagem.values());
        Collections.sort(valores);
         return valores;
    }
}