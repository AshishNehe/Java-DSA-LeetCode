
public class MaximumTwinSumOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static int pairSum(ListNode head) {

        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Calculate maximum twin sum
        int maxSum = 0;

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            int sum = first.val + second.val;

            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println(" -> null");
    }

    public static void main(String[] args) {

        // Create linked list: 5 -> 4 -> 2 -> 1
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Original Linked List:");
        printList(head);

        int result = pairSum(head);

        System.out.println("Maximum Twin Sum: " + result);
    }
}
