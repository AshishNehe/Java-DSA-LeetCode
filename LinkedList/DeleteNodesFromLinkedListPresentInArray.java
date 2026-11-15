
import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {

    // Node of the linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {

        // Store array values in a HashSet
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        // Delete nodes whose values are present in the HashSet
        while (curr.next != null) {

            if (set.contains(curr.next.val)) {

                // Skip the node
                curr.next = curr.next.next;

            } else {

                // Move to the next node
                curr = curr.next;
            }
        }

        return dummy.next;
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

        // Array values to delete
        int[] nums = {1, 2, 3};

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        DeleteNodesFromLinkedListPresentInArray solution =
            new DeleteNodesFromLinkedListPresentInArray();

        head = solution.modifiedList(nums, head);

        System.out.println("Updated Linked List:");
        printList(head);
    }
}
