import java.util.Stack;

public class stackLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack Underflow!");
                return Integer.MIN_VALUE;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Stack Underflow!");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

        while(!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
