package MergeTwoSortedLists;



public class Main {
    public static void main(String[] args) {
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        ListNode result = mergeTwoSortedLists(list1, list2);
        printList(result); // Função para imprimir a lista resultante
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Crie um novo nó para armazenar o resultado e chame a função recursivamente
        if (list1.val < list2.val) {
            list1.next = mergeTwoSortedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoSortedLists(list1, list2.next);
            return list2;
        }
    }

    // Função auxiliar para imprimir a lista
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}