import java.util.LinkedList;
import java.util.Queue;

public class kthLevelOfTree {
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

    public static void kthLevel1(Node root, int k, int level) { // Recursion
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data + " ");
        }
        kthLevel1(root.left, k, level + 1);
        kthLevel1(root.right, k, level + 1);
    }

    public static void kthLevel2(Node root, int k) { // Iterative
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;

        while(!q.isEmpty()) {
            Node curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    level++;
                }
            } else {
                if(level == k) {
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
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

        kthLevel1(root, 3, 1);
        System.out.println();
        kthLevel2(root, 3);
    }
}
