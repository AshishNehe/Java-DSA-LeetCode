
public class MergeInBetweenLinkedLists {

    // Node of the linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeInBetween(
            ListNode list1, int a, int b, ListNode list2) {

        // Step 1: Find the node before index a
        ListNode first = list1;

        for (int i = 0; i < a - 1; i++) {
            first = first.next;
        }

        // Step 2: Find the node after index b
        ListNode last = first;

        for (int i = 0; i < b - a + 2; i++) {
            last = last.next;
        }

        // Step 3: Connect list1 to list2
        first.next = list2;

        // Step 4: Find the last node of list2
        ListNode curr = list2;

        while (curr.next != null) {
            curr = curr.next;
        }

        // Step 5: Connect list2 to remaining list1
        curr.next = last;

        return list1;
    }

    // Print the linked list
    private static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create first linked list
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);

        // Create second linked list
        ListNode list2 = new ListNode(100);
        list2.next = new ListNode(101);
        list2.next.next = new ListNode(102);

        int a = 3;
        int b = 4;

        MergeInBetweenLinkedLists solution =
            new MergeInBetweenLinkedLists();

        list1 = solution.mergeInBetween(list1, a, b, list2);

        System.out.println("Merged Linked List:");
        printList(list1);
    }
}
