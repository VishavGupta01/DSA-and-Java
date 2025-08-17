import java.util.ArrayList;

public class lowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildBinaryTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);

            return newNode;
        }
    }

    // Approach 1
    public static int lca1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if(!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return -1;
        }

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1).data;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> list) {
        if(root == null) {
            return false;
        }

        list.add(root);

        if(root.data == n) {
            return true;
        }
        if(getPath(root.left, n, list) || getPath(root.right, n, list)) {
            return true;
        }
        list.remove(root);
        return false;
    }

    // Approach 2
    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);

        if(right == null) {
            return left;
        } else if(left == null) {
            return right;
        }
        return root;
    }

    // Revision
    public static int lcaR1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if(!getPath1(root, n1, path1) || !getPath1(root, n2, path2)) {
            return -1;
        }

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i).data != path2.get(i).data) {
                break;
            }
        }
        return path1.get(i-1).data;
    }

    public static boolean getPath1(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);
        if(root.data == n) {
            return true;
        }

        if(getPath(root.left, n, path) || getPath(root.right, n, path)) {
            return true;
        }
        path.remove(root);
        return false;
    }

    public static Node lcaR2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lcaR2(root.left, n1, n2);
        Node right = lcaR2(root.right, n1, n2);
        if(right == null) {
            return left;
        } else if(left == null) {
            return right;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lcaR2(root, 6, 7).data);
    }
}
