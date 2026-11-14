
public class InsertGreatestCommonDivisors {

    // Node of the linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            // Find GCD of two adjacent nodes
            int gcdValue = gcd(curr.val, curr.next.val);

            // Create a new node with GCD value
            ListNode newNode = new ListNode(gcdValue);

            // Insert new node between current and next
            newNode.next = curr.next;
            curr.next = newNode;

            // Move to the next original node
            curr = newNode.next;
        }

        return head;
    }

    // Calculate GCD using Euclidean algorithm
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Print linked list
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

        // Create original linked list
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        InsertGreatestCommonDivisors solution =
            new InsertGreatestCommonDivisors();

        head = solution.insertGreatestCommonDivisors(head);

        System.out.println("Updated Linked List:");
        printList(head);
    }
}
