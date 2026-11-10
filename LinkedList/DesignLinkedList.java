
public class DesignLinkedList {

    static class MyLinkedList {

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        private Node head;
        private int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            Node curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;

                while (curr.next != null) {
                    curr = curr.next;
                }

                curr.next = newNode;
            }

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                head = head.next;
                size--;
                return;
            }

            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
            size--;
        }

        public void display() {
            Node curr = head;

            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addAtHead(10);
        list.addAtTail(20);
        list.addAtTail(30);

        System.out.println("Original Linked List:");
        list.display();

        System.out.println("Value at index 1: " + list.get(1));

        list.addAtIndex(1, 15);
        System.out.println("After adding 15 at index 1:");
        list.display();

        list.deleteAtIndex(2);
        System.out.println("After deleting node at index 2:");
        list.display();

        System.out.println("Final Linked List:");
        list.display();
    }
}
