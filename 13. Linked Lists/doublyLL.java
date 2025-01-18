public class doublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node temp = new Node(data);
        size++;
        if(head == null) {
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public void addLast(int data) {
        if(head == null) {
            addFirst(data);
            return;
        }
        Node temp = new Node(data);
        size++;
        Node ptr = head;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = temp;
        temp.prev = ptr;
    }

    public void removeFirst() {
        if(head == null) {
            System.out.println("List UnderFlow!");
            return;
        }
        if(size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public int removeLast() {
        if(head == null) {
            System.out.println("List Underflow!");
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        doublyLL list = new doublyLL();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.print();
    }
}
