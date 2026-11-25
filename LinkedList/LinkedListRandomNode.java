
import java.util.Random;

public class LinkedListRandomNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {

        int result = 0;
        int count = 0;

        ListNode current = head;

        while (current != null) {

            count++;

            // Select current node with probability 1/count
            if (random.nextInt(count) == 0) {
                result = current.val;
            }

            current = current.next;
        }

        return result;
    }

    public static void main(String[] args) {

        // Creating linked list: 10 -> 20 -> 30 -> 40
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        LinkedListRandomNode solution =
                new LinkedListRandomNode(head);

        System.out.println("Random node selections:");

        // Generate 5 random selections
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.getRandom());
        }
    }
}
