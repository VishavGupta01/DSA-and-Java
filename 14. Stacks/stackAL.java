import java.util.ArrayList;

public class stackAL {
    public static class Stack {
        static ArrayList<Integer> stack = new ArrayList<>();

        public static boolean isEmpty() {
            return stack.size() == 0;
        }

        public static void push(int data) {
            stack.add(data);
        }

        public static int pop() {
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return top;
        }

        public static int peek() {
            return stack.get(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
