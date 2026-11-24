
import java.util.*;

public class PopulatingNextRightPointersII {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            Node previous = null;

            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                // Connect the previous node
                // to the current node
                if (previous != null) {
                    previous.next = current;
                }

                previous = current;

                // Add left child
                if (current.left != null) {
                    queue.add(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // Last node of this level points to null
            previous.next = null;
        }

        return root;
    }

    // Print nodes level by level using next pointers
    public static void printLevels(Node root) {

        Node levelStart = root;

        while (levelStart != null) {

            Node current = levelStart;

            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }

            System.out.println("null");

            // Move to the next level
            if (levelStart.left != null) {
                levelStart = levelStart.left;
            } else if (levelStart.right != null) {
                levelStart = levelStart.right;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Creating the binary tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        PopulatingNextRightPointersII solution =
                new PopulatingNextRightPointersII();

        solution.connect(root);

        System.out.println("Next Right Pointers:");

        printLevels(root);
    }
}
