
import java.util.*;

public class NextGreaterNodeInLinkedList {

    // Node structure
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int[] nextLargerNodes(ListNode head) {

        List<Integer> values = new ArrayList<>();

        // Store linked list values
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();
        int[] answer = new int[n];

        // Stack stores indexes
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Find the next greater value
            while (!stack.isEmpty() &&
                   values.get(i) > values.get(stack.peek())) {

                int index = stack.pop();
                answer[index] = values.get(i);
            }

            stack.push(i);
        }

        return answer;
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

    // Print answer array
    public static void printArray(int[] answer) {

        System.out.print("Next Greater Nodes: ");

        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);

            if (i < answer.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] values = {2, 1, 5};

        ListNode head = createList(values);

        int[] result = nextLargerNodes(head);

        printArray(result);
    }
}
