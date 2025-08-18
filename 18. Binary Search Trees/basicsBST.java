public class basicsBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.data < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static boolean search(Node root, int val) {
        if(root == null) {
            return false;
        }

        if(root.data == val) {
            return true;
        } else if(root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node delete(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // Case 1: Leaf Node
            if(root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Single Node
            if(root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two Nodes
            Node nextSucc = root.right; // Inorder Successor
            while(nextSucc.left != null) {
                nextSucc = nextSucc.left;
            }
            root.data = nextSucc.data;
            root.right = delete(root.right, nextSucc.data);
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } else if(root.data > k2) {
            printInRange(root.left, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int val : values) {
            root = insert(root, val);
        }
        printInRange(root, 2, 4);
    }
}
