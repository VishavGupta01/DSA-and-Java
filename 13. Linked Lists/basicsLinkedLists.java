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

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List Underflow!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
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

    public int iterativeSearch(basicsLinkedLists list, int key) {
        Node temp = head;
        int i = 0;
        if (head == null) {
            System.out.println("List Underflow!");
            return -1;
        }
        while(temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recursiveSearch(basicsLinkedLists list, Node head1, int key) {
        if(head1 == null) {
            return -1;
        }
        if (head1.data == key) {
            return 0;
        }
        int idx = recursiveSearch(list, head1.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
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
        System.out.println();
        System.out.println("Removed Element: " + list.removeFirst());
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println();
        System.out.println("Removed Element: " + list.removeLast());
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println();

        // Iterative Search
        System.out.println("Iterative Search for Key = 5 at index: " + list.iterativeSearch(list, 5));
        System.out.println();

        //Recursive Search
        System.out.println("Recursive Search for Key = 3 at index: " + list.recursiveSearch(list, head, 3));
        System.out.println();
    }
}
