
public class MergeNodesInBetweenZeros {

    // Node structure
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeNodes(ListNode head) {

        ListNode current = head.next;
        ListNode write = head;

        int sum = 0;

        while (current != null) {

            if (current.val != 0) {
                sum += current.val;
            } else {

                // Store the group sum
                write.val = sum;

                // Skip the completed group
                write.next = current.next;

                // Move to the next result node
                write = write.next;

                sum = 0;
            }

            current = current.next;
        }

        return head;
    }

    // Create a linked list
    public static ListNode createList(int[] values) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
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

        int[] values = {0, 3, 1, 0, 4, 5, 2, 0};

        ListNode head = createList(values);

        head = mergeNodes(head);

        System.out.println("Merged Linked List:");
        printList(head);
    }
}
