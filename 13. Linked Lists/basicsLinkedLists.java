public class basicsLinkedLists {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL(basicsLinkedLists list) { // O(n)
        Node temp = head;
        if (temp == null) {
            System.out.println("Linked List Underflow!");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        basicsLinkedLists list = new basicsLinkedLists();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printLL(list);
    }
}
