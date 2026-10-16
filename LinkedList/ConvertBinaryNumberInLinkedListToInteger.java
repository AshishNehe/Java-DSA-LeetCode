
public class ConvertBinaryNumberInLinkedListToInteger {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }

        return result;
    }

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)
}
