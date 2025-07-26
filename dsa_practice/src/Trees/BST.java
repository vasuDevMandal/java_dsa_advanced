package Trees;

public class BST {

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {45,40,67,89,98,56,5,34,45,6,88};
        bst.Populate(nums);
        bst.Display();
    }

    public class Node{
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

    public BST() { }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void Display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details ) {
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left Child of " + node.getValue() + " -> ");
        display(node.right, "Right Child of " + node.getValue() + " -> ");
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.getValue()){
            node.left = insert(node.left, value);
        }

        if(value > node.getValue()){
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean Balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.right) && balanced(node.left);
    }

    private void Populate(int[] nums){
        for(int item : nums){
            insert(item);
        }
    }
}
