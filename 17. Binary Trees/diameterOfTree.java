public class diameterOfTree {
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

        public static int diameterOfTreeA1(Node root) { // O(n^2) due to additional calls for calc Height
            if(root == null) {
                return 0;
            }

            // Case 1 : Passes through Root
            int lh = height(root.left), rh = height(root.right);
            int diamRoot = lh + rh + 1;

            // Case 2 : Doesn't pass through Root
            int diaLeftSubTree = diameterOfTreeA1(root.left);
            int diaRightSubTree = diameterOfTreeA1(root.right);

            return Math.max(diamRoot, Math.max(diaLeftSubTree, diaRightSubTree));
        }

        public static int height(Node root) {
            if(root == null) {
                return 0;
            }
            return Math.max(height(root.left), height(root.right)) + 1;
        }

            static class Info {
                int diameter;
                int height;

                Info(int d, int h) {
                    this.diameter = d;
                    this.height = h;
                }
            }

            public static Info diameterOfTreeA2(Node root) { // O(n)
                if(root == null) {
                    return new Info(0, 0);
                }

                Info left = diameterOfTreeA2(root.left);
                Info right = diameterOfTreeA2(root.right);

                int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);
                int height = Math.max(left.height, right.height) + 1;

                return new Info(diameter, height);
            }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        System.out.println(tree.diameterOfTreeA1(root));
    }
}
