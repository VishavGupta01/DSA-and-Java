public class subTree {
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

        public static boolean subTree(Node root, Node subRoot) {
            if(root == null) return false;
            if(subRoot == null) return true;
            if(root.data == subRoot.data) {
                if(checkIdentical(root, subRoot)) {
                    return true;
                }
            }
            return subTree(root.left, subRoot) || subTree(root.right, subRoot);
        }

        public static boolean checkIdentical(Node root, Node subRoot) {
            if(root == null && subRoot == null) return true;
            else if(root == null || subRoot == null || root.data != subRoot.data) return false;

            return checkIdentical(root.left, subRoot.left) && checkIdentical(root.right, subRoot.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        System.out.println(tree.subTree(root, subRoot));
    }
}
