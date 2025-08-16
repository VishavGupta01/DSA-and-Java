import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class topViewOfTree {
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

    static class Info {
        Node node;
        int hd;

        Info(Node n, int hd) {
            this.node = n;
            this.hd = hd;
        }
    }

    public static int[] topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));
        map.put(0, root);

        while(!q.isEmpty()) {
            Info curr = q.remove();

            if(curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }

            if(!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
                min = Math.min(curr.hd, min);
                max = Math.max(curr.hd, max);
            }
            if(curr.node.left != null) q.add(new Info(curr.node.left, curr.hd - 1));
            if(curr.node.right != null) q.add(new Info(curr.node.right, curr.hd + 1));
        }

        int n = max - min + 1;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = map.get(i + min).data;
        }
        return res;
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

        int[] res = topView(root);
        for(int num : res) {
            System.out.print(num + " ");
        }
    }
}
