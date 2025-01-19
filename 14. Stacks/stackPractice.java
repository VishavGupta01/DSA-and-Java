import java.util.Stack;

public class stackPractice {
    // Q1. Push at Bottom of Stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int d = s.pop();
        pushAtBottom(s, data);
        s.push(d);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        pushAtBottom(st, 4);
        System.out.println(st);
    }
}
