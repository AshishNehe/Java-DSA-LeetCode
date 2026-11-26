
public class FlattenBinaryTreeToLinkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode previous = null;

    public void flatten(TreeNode root) {

        // If tree is empty
        if (root == null) {
            return;
        }

        // Visit right subtree first
        flatten(root.right);

        // Visit left subtree
        flatten(root.left);

        // Connect current node to previous node
        root.right = previous;
        root.left = null;

        // Update previous node
        previous = root;
    }

    // Print the flattened linked list
    public static void printList(TreeNode root) {

        while (root != null) {
            System.out.print(root.val);

            if (root.right != null) {
                System.out.print(" -> ");
            }

            root = root.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating the binary tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList solution =
                new FlattenBinaryTreeToLinkedList();

        // Flatten the binary tree
        solution.flatten(root);

        System.out.println("Flattened Linked List:");

        printList(root);
    }
}
