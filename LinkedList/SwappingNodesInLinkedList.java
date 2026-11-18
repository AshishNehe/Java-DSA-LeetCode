
public class SwappingNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {

        // Find the kth node from the beginning
        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find the kth node from the end
        ListNode fast = first;
        ListNode second = head;

        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    // Print the linked list
    public static void printList(ListNode head) {
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

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original Linked List:");
        printList(head);

        head = swapNodes(head, k);

        System.out.println("After Swapping:");
        printList(head);
    }
}
