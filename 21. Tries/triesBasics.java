import java.util.ArrayList;

public class triesBasics {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(Node n : children) {
                n = null;
            }
            freq = 1;
        }
    }

    public static void insertion(String s, Node root) { // O(L) , L -> Length of biggest String
        Node curr = root;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            } else {
                curr.children[ch - 'a'].freq++;
            }
            curr = curr.children[ch - 'a'];
        }
        curr.eow = true;
    }

    public static boolean search(String s, Node root) { // O(L)
        Node curr = root;
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key, Node root) { // TC : O(2^n * n^2)
        if(key.length() == 0) {
            return true;
        }

        for(int i = 0; i < key.length(); i++) {
            String prefix = key.substring(0, i + 1);
            String suffix = key.substring(i + 1);

            if(search(prefix, root) && wordBreak(suffix, root)) {
                return true;
            }
        }
        return false;
    }

    public static String prefixProblem(String s, Node root) { // Approach 1
        StringBuilder sb = new StringBuilder();
        Node curr = root;

        for(char ch : s.toCharArray()) {
            curr = curr.children[ch - 'a'];
            sb.append(ch);
            int count = 0;
            for(int i = 0; i < 26; i++) {
                if(curr.children[i] != null) {
                    count++;
                }
            }
            if(count == 1) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static String prefixProblem2(String s, Node root) { // Approach 2 (using Freq)
        Node curr = root;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            curr = curr.children[ch - 'a'];
            sb.append(ch);
            if(curr.freq == 1) {
                break;
            }
        }
        return sb.toString();
    }

    public static boolean startsWith(Node root, String prefix) {
        if(prefix.equals("")) {
            return true;
        }
        Node curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        // Node root1 = new Node();
        // String[] strings = {"the", "a", "there", "their", "any", "thee"};
        // for(String s : strings) {
        //     insertion(s, root1);
        // }

        // System.out.println(search("thei", root1));

        // Node root2 = new Node();
        // String[] dict = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // String key = "ilikesamsung";

        // for(String s : dict) {
        //     insertion(s, root2);
        // }
        // System.out.println(wordBreak(key, root2));

        // String[] arr = {"a", "ant"};

        // Node root3 = new Node();
        // root3.freq = -1;
        // for(String s : arr) {
        //     insertion(s, root3);
        // }

        // ArrayList<String> ans = new ArrayList<>();

        // for(String s : arr) {
        //     ans.add(prefixProblem2(s, root3));
        // }
        // System.out.println(ans);

        Node root = new Node();
        root.freq = -1;

        String[] words = {"apple", "app", "mango", "man", "woman"};
        String prefix = "moon";
        for(String s : words) {
            insertion(s, root);
        }
        System.out.println(startsWith(root, prefix));
    }
}
