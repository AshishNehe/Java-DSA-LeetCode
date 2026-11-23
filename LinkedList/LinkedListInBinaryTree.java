
public class LinkedListInBinaryTree {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return checkPath(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private boolean checkPath(ListNode head, TreeNode root) {

        if (head == null) {
            return true;
        }

        if (root == null || head.val != root.val) {
            return false;
        }

        return checkPath(head.next, root.left)
                || checkPath(head.next, root.right);
    }

    public static void main(String[] args) {

        // Creating linked list: 4 -> 2 -> 8
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        // Creating binary tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        LinkedListInBinaryTree solution =
                new LinkedListInBinaryTree();

        boolean result = solution.isSubPath(head, root);

        System.out.println("Linked List exists in Binary Tree: " + result);
    }
}
