
import java.util.Stack;

public class AddTwoNumbersII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Store first linked list values
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Store second linked list values
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;

        // Add digits from right to left
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int sum = carry;

            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            carry = sum / 10;

            int digit = sum % 10;

            // Insert new node at the beginning
            ListNode newNode = new ListNode(digit);

            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    // Create a linked list from an array
    public static ListNode createList(int[] values) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // Print linked list
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

        // First number: 7243
        ListNode l1 = createList(new int[]{7, 2, 4, 3});

        // Second number: 564
        ListNode l2 = createList(new int[]{5, 6, 4});

        AddTwoNumbersII solution = new AddTwoNumbersII();

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("First Number: 7243");
        System.out.println("Second Number: 564");

        System.out.print("Sum: ");
        printList(result);
    }
}
