
import java.util.HashSet;

public class LinkedListComponents {

    // Node structure
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int numComponents(ListNode head, int[] nums) {

        // Store nums in a HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int count = 0;

        // Traverse the linked list
        while (head != null) {

            if (set.contains(head.val)) {

                // Check whether current node
                // is the last node of a component
                if (head.next == null ||
                    !set.contains(head.next.val)) {

                    count++;
                }
            }

            head = head.next;
        }

        return count;
    }

    // Create linked list
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

        int[] values = {0, 1, 2, 3};
        int[] nums = {0, 1, 3};

        ListNode head = createList(values);

        int result = numComponents(head, nums);

        System.out.println("Number of Components: " + result);
    }
}
