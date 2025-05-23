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

    // Q3. Reverse a Stack
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) return;

        int d = s.pop();
        reverseStack(s);
        pushAtBottom(s, d);
    }

    // Q4. Stock Span Problem
    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < span.length; i++) {
            int curr = stocks[i];
            while(!s.isEmpty() && curr > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    // Q5. Next Greater Element
    public static int[] nextGreater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return res;
    }

    // Q6. Valid Parenthesis
    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') s.push(ch);
            else {
                if(s.isEmpty()) return false;
                else if(ch == ')' && s.peek() == '(' || ch == '}' && s.peek() == '{' || ch == ']' && s.peek() == '[') {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    // Q7. Duplicate Parenthesis
    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch != ')') s.push(ch);
            else {
                int count = 0;
                while (s.peek() != '(') {
                    count++;
                    s.pop();
                }
                s.pop();
                if(count == 0) return true;
            }
        }
        return false;
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

        // Q3. Reverse a Stack
        Stack<Integer> st1 = new Stack<>();
        st1.push(1);
        st1.push(2);
        st1.push(3);
        System.out.println(st1);
        reverseStack(st1);
        System.out.println(st1);

        // Q4. Stock Span Problem
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stocks.length];
        stockSpan(stocks, span);

        for(int i = 0; i < span.length; i++) System.out.print(span[i] + " ");
        System.out.println();

        // Q5. Next Greater Element
        int[] arr = {6, 8, 0, 1, 3};
        int[] res = nextGreater(arr);
        for(int i : res) System.out.print(i + " ");
        System.out.println();

        // Q6. Valid Parenthesis
        System.out.println(validParenthesis("(){[]}"));

        // Q7. Duplicate Parenthesis
        System.out.println(duplicateParenthesis("a+(b+(c))")); // False
        System.out.println(duplicateParenthesis("((a))")); // True
    }
}
