
public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // Stop if fewer than k nodes remain
            if (kth == null) {
                break;
            }

            // Save the next group's starting node
            ListNode groupNext = kth.next;

            // Reverse the current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode nextNode = curr.next;

                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // Connect the reversed group
            ListNode temp = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }

    public static void main(String[] args) {

        ReverseNodesInKGroup solution =
            new ReverseNodesInKGroup();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = solution.reverseKGroup(head, 2);

        while (result != null) {

            System.out.print(result.val);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }
    }
}
