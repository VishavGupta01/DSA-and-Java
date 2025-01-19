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

    // Q2. Reverse a String using Stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()) s.push(ch);

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // Q1. Push at Bottom of Stack
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        pushAtBottom(st, 4);
        System.out.println(st);

        // Q2. Reverse a String
        System.out.println(reverseString("abc"));

        
    }
}