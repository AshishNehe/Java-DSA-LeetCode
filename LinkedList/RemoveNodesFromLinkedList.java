
public class RemoveNodesFromLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNodes(ListNode head) {

        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Remove nodes smaller than maximum
        int max = Integer.MIN_VALUE;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            if (curr.val < max) {
                prev.next = curr.next;
            } else {
                max = curr.val;
                prev = curr;
            }

            curr = curr.next;
        }

        // Step 3: Restore original order
        return reverse(head);
    }

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

        // Input: 5 -> 2 -> 13 -> 3 -> 8
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        RemoveNodesFromLinkedList solution =
            new RemoveNodesFromLinkedList();

        head = solution.removeNodes(head);

        System.out.println("After removing nodes:");
        printList(head);
    }
}
