package estruturasDeDados;

import java.util.*;

public class DataStructures {

    public static void main(String[] args) {
        // LISTAS
        //Array
        String[] array = new String[3];
        array[0] = "A";
        array[1] = "B";
        System.out.println("Array[1]: " + array[1]); // acesso direto por índice

        //ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");          // adicionar
        arrayList.add("B");
        arrayList.remove("B");       // remover por valor
        System.out.println(arrayList.contains("A")); // busca

        //LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");               // adicionar no fim
        linkedList.addFirst("Z");          // adicionar no início
        linkedList.addLast("B");           // adicionar no fim
        linkedList.removeFirst();          // remover do início
        linkedList.removeLast();           // remover do fim
        System.out.println(linkedList.contains("A")); // busca

        // SETS ===================================

        //HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("A"); // duplicados são ignorados
        hashSet.remove("B");
        System.out.println(hashSet.contains("A"));

        //TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        System.out.println(treeSet); // saída: [A, B, C] (ordenado)
        treeSet.remove("B");
        System.out.println(treeSet.contains("A"));

        //LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.remove("B");
        System.out.println(linkedHashSet.contains("C"));

        // MAPAS ===================================

        //HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.remove(1);
        System.out.println(hashMap.get(2));     // busca por chave
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.containsValue("B"));

        //TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        System.out.println(treeMap); // saída ordenada pelas chaves
        treeMap.remove(1);
        System.out.println(treeMap.get(2));

        //LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.remove(1);
        System.out.println(linkedHashMap.containsKey(2));

        // OUTROS ===================================

        //HashTable
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "A");
        hashtable.put(2, "B");
        hashtable.remove(1);
        System.out.println(hashtable.get(2));

        //Stack
        Stack<String> stack = new Stack<>();
        stack.push("A");     // inserir no topo
        stack.push("B");
        stack.pop();          // remover do topo
        System.out.println(stack.peek()); // ver topo sem remover
        System.out.println(stack.search("A")); // posição

        //Queue
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");    // adicionar no fim
        queue.offer("B");
        queue.poll();         // remover do início
        System.out.println(queue.peek()); // ver primeiro sem remover
    }
}
