package LinkedLists;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println(MergeTwoSortedLists(list1, list2));
    }

    public static ListNode MergeTwoSortedLists(ListNode list1, ListNode list2) {
        if(list1.val == list2.val){
            MergeTwoSortedLists(list1.next, list2.next);
        }

        return null;
    }
}