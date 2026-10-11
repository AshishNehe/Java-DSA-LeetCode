
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next; // Save next node
            curr.next = prev;          // Reverse the link

            prev = curr;               // Move prev forward
            curr = next;               // Move curr forward
        }

        return prev;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
}
