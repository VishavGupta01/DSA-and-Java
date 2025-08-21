import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void rootToLeafPaths(Node root, List<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            System.out.println(path);
        }
        rootToLeafPaths(root.left, path);
        rootToLeafPaths(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        if((min != null && root.data <= min.data) || (max != null && root.data >= max.data)) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node createMirror(Node root) {
        if(root == null) {
            return null;
        }

        Node left = createMirror(root.left);
        Node right = createMirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static Node sortedArrayToBST(Node root, int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        root = new Node(arr[mid]);
        root.left = sortedArrayToBST(root.left, arr, start, mid - 1);
        root.right = sortedArrayToBST(root.right, arr, mid + 1, end);

        return root;
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
        return;
    }

    public static void main(String[] args) {
        // int[] values = {5, 3, 1, 4, 6, 7};
        // Node root = null;
        // for(int val : values) {
        //     root = insert(root, val);
        // }
        // levelOrder(root);
        // root = createMirror(root);
        // System.out.println();
        // levelOrder(root);

        int[] arr = {1,2,3,4,5,6,7};
        Node root = null;
        root = sortedArrayToBST(root, arr, 0, arr.length - 1);
        levelOrder(root);
    }
}
