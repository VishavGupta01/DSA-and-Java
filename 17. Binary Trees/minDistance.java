import java.util.ArrayList;

public class minDistance {
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

        public static int minDistance1(Node root, Node n1, Node n2) { // TC -> O(n) , SC -> O(n)
            if(root == null) {
                return -1;
            }
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

            int minDistance = path1.size() - i + path2.size() - i;
            return minDistance;
        }

        public static boolean getPath(Node root, Node n1, ArrayList<Node> path) {
            if(root == null) {
                return false;
            }
            path.add(root);
            if(root == n1) {
                return true;
            }
            if(getPath(root.left, n1, path) || getPath(root.right, n1, path)) {
                return true;
            }
            path.remove(root);
            return false;
        }
    }

    public static int minDistance(Node root, int n1, int n2) { // TC-> O(n) , SC-> O(h)
        if(root == null) {
            return -1;
        }

        Node lca = getLCA(root, n1, n2);
        if(lca == null) {
            return -1;
        }

        return disLcaToNode(lca, n1, 0) + disLcaToNode(lca, n2, 0);
    }

    public static Node getLCA(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = getLCA(root.left, n1, n2);
        Node right = getLCA(root.right, n1, n2);
        if(left == null) {
            return right;
        } else if(right == null) {
            return left;
        }
        return root;
    }

    public static int disLcaToNode(Node root, int n, int dist) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return dist;
        }

        int left = disLcaToNode(root.left, n, dist + 1);
        if(left != -1) return left;

        return disLcaToNode(root.right, n, dist + 1);
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

        System.out.println(minDistance(root, 4, 5));
    }
}
