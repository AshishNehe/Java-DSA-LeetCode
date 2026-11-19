
public class FindMinMaxNodesBetweenCriticalPoints {

    // Node structure
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int previous = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    first = index;
                }

                if (previous != -1) {
                    int distance = index - previous;

                    minDistance = Math.min(minDistance, distance);
                    maxDistance = index - first;
                }

                previous = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (maxDistance == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
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

    public static void main(String[] args) {

        int[] values = {5, 3, 1, 2, 5, 1, 2};

        ListNode head = createList(values);

        int[] result = nodesBetweenCriticalPoints(head);

        System.out.println("Minimum Distance: " + result[0]);
        System.out.println("Maximum Distance: " + result[1]);
    }
}
