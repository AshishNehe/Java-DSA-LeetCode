
public class PartitionList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }

            curr = curr.next;
        }

        // Terminate the second list
        greater.next = null;

        // Join the two lists
        less.next = greaterDummy.next;

        return lessDummy.next;
    }

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)
}
