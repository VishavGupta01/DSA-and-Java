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
    public static int size;

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List Underflow!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
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
        System.out.println();
    }

    public static void main(String[] args) {
        basicsLinkedLists list = new basicsLinkedLists();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.add(3, 3);
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println("Removed Element: " + list.removeFirst());
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
    }
}
