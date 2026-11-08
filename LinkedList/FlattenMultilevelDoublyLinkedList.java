
public class FlattenMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        flattenDFS(head);

        return head;
    }

    private Node flattenDFS(Node curr) {

        Node last = curr;

        while (curr != null) {

            Node nextNode = curr.next;

            if (curr.child != null) {

                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);

                // Connect current node to child
                curr.next = childHead;
                childHead.prev = curr;

                // Remove child pointer
                curr.child = null;

                // Connect child tail to original next
                if (nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }

                last = childTail;

            } else {
                last = curr;
            }

            curr = nextNode;
        }

        return last;
    }

    public static void main(String[] args) {

        FlattenMultilevelDoublyLinkedList solution =
            new FlattenMultilevelDoublyLinkedList();

        // Main list: 1 <-> 2 <-> 3 <-> 4
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;

        // Child list: 7 <-> 8 <-> 9
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;

        // Attach child list to node 3
        n3.child = n7;

        Node result = solution.flatten(n1);

        // Print flattened list
        while (result != null) {
            System.out.print(result.val);

            if (result.next != null) {
                System.out.print(" <-> ");
            }

            result = result.next;
        }
    }
}
