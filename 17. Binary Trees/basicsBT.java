import java.util.LinkedList;
import java.util.Queue;

public class basicsBT {
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

        public static void preOrder(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }

        public static void postOrder(Node root) {
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if(curr == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                }
            }
        }

        public static int heightOfTree(Node root) {
            if(root == null) {
                return 0;
            }

            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int countNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int count = countNodes(root.left) + countNodes(root.right);
            return count + 1;
        }

        public static int sumOfAllNodes(Node root) {
            if(root == null) {
                return 0;
            }

            return sumOfAllNodes(root.left) + sumOfAllNodes(root.right) + root.data;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.postOrder(root);
        // tree.inOrder(root);
        // tree.levelOrder(root);

        // System.out.println(tree.heightOfTree(root));

        // System.out.println(tree.countNodes(root));

        System.out.println(tree.sumOfAllNodes(root));
    }
}
