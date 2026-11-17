
public class DoubleANumberRepresentedAsLinkedList {

    // Node of the linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode doubleIt(ListNode head) {

        // Step 1: Reverse the linked list
        head = reverse(head);

        ListNode curr = head;
        ListNode prev = null;

        int carry = 0;

        // Step 2: Double every digit
        while (curr != null) {

            int value = curr.val * 2 + carry;

            curr.val = value % 10;
            carry = value / 10;

            prev = curr;
            curr = curr.next;
        }

        // Step 3: Add a new node if carry remains
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        // Step 4: Restore original order
        return reverse(head);
    }

    // Reverse the linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
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

        // Input: 1 -> 8 -> 9
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);

        DoubleANumberRepresentedAsLinkedList solution =
            new DoubleANumberRepresentedAsLinkedList();

        head = solution.doubleIt(head);

        System.out.println("Doubled Number:");
        printList(head);
    }
}
