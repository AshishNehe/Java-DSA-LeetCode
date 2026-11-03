
public class InsertionSortList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;
            ListNode prev = dummy;

            while (prev.next != null &&
                   prev.next.val < curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;

            curr = nextNode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        InsertionSortList solution =
            new InsertionSortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode result = solution.insertionSortList(head);

        while (result != null) {
            System.out.print(result.val);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }
    }
}
