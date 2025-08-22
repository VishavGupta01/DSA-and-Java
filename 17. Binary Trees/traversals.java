import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class traversals {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(curr.data + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    public static ArrayList<Integer> morris(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        Node curr = root;
        while(curr != null) {
            // Case 1: Root has no left SubTree
            if(curr.left == null) {
                list.add(curr.data);
                curr = curr.right;
            } else {
                Node ip = curr.left;
                while(ip.right != null && ip.right != curr) ip = ip.right;

                if(ip.right == null) {
                    // Case 2: Root has a left subTree with the rightMost Node pointing to NULL
                    ip.right = curr;
                    curr = curr.left;
                } else {
                    // Case 3: Root has a left SubTree with the rightMost Node pointing to curr
                    ip.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);

        System.out.println(morris(root));
    }
}

