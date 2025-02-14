package dsa_practice.trees;

class BST {
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

    public BST(){

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
        System.out.println(details + node.getValue());
        display(node.left,"Left child of: " + node.getValue());
        display(node.right,"Right child of: " + node.getValue());
    }

    private void insert(int value){

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

        return node;
    }






}
