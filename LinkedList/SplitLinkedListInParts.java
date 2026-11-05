
public class SplitLinkedListInParts {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        // Calculate linked list length
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Calculate the size of each part
        int baseSize = length / k;
        int extraNodes = length % k;

        ListNode[] result = new ListNode[k];

        curr = head;

        // Split the linked list
        for (int i = 0; i < k; i++) {

            result[i] = curr;

            int partSize = baseSize;

            if (i < extraNodes) {
                partSize++;
            }

            // Move to the last node of this part
            for (int j = 0; j < partSize - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            // Disconnect the current part
            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SplitLinkedListInParts solution =
            new SplitLinkedListInParts();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next =
            new ListNode(10);

        ListNode[] parts = solution.splitListToParts(head, 3);

        for (ListNode part : parts) {

            while (part != null) {
                System.out.print(part.val + " ");
                part = part.next;
            }

            System.out.println();
        }
    }
}
