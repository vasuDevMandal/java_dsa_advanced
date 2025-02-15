package dsa_practice.trees;

class AVLTree {

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVLTree(){

    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root,"Root node: ");
    }

    private void display(Node node, String details) {
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue() + " | h[" + height(node) + "]");
        display(node.left,"Left child of " + node.getValue() + " -> ");
        display(node.right,"Right child of " + node.getValue() + " -> ");
    }

    private void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            Node newNode = new Node(value);
            return newNode;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        //checking heights - finding which rule to apply of 4 balancing rules

        if(height(node.left) - height(node.right) > 1){
            // LEFT HEAVY | +ve difference
            if (height(node.left.left) - height(node.right.right) > 0){
                // LEFT-LEFT case - difference is +ve
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // LEFT-RIGHT case - difference is -ve
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < 1){
            // RIGHT HEAVY | -ve difference
            if (height(node.right.left) - height(node.right.right) < 0){
                // RIGHT-RIGHT case - difference is +ve
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // RIGHT-LEFT case - difference is -ve
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)+1);
        p.height = Math.max(height(p.left), height(p.right)+1);

        return p;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)+1);
        c.height = Math.max(height(c.left), height(c.right)+1);

        return c;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 0; i < 100; i++) {
            tree.insert(i);
        }
        System.out.println(tree.height(tree.root));
        tree.display();
    }
}

