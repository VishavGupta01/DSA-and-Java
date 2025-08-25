public class triesBasics {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for(Node n : children) {
                n = null;
            }
        }
    }

    public static void insertion(String s, Node root) { // O(L) , L -> Length of biggest String
        Node curr = root;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
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

    public static void main(String[] args) {
        // Node root1 = new Node();
        // String[] strings = {"the", "a", "there", "their", "any", "thee"};
        // for(String s : strings) {
        //     insertion(s, root1);
        // }

        // System.out.println(search("thei", root1));

        Node root2 = new Node();
        String[] dict = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";

        for(String s : dict) {
            insertion(s, root2);
        }
        System.out.println(wordBreak(key, root2));
    }
}
