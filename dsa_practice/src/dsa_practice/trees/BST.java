package dsa_practice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        return node;
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


    //similar for others
    public void preOrder(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " " );
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrder(){
       inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value + " " );
        inOrderTraversal(node.right);
    }

//    https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        //FIFO is used in level order, so we are using queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);//retrieves and removes first-element/head from queue

        //every iteration of while loop check single level as for loop run according to level size
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            //for loop is running over queue elements
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();//read head item from a queue
                currentLevel.add(currentNode.value);//adding 1 node
                if(currentNode.left !=  null){//check if current node has left node
                    queue.offer(currentNode.left);//add left node to queue
                }
                if(currentNode.right !=  null){//check if current node has right nodes
                    queue.offer(currentNode.right);//add right node to queue
                }
            };
            result.add(currentLevel);
        }
        return result;
    }

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public List<Double> AverageOfEveryLevel(Node root) {
        List<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //every iteration of while loop check single level as for loop run according to level size
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double averageLevel = 0;

            //for loop is running over queue elements
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();//read every item from a queue
                averageLevel += currentNode.value;//add all level order nodes
                if(currentNode.left !=  null){//check if current node has left node
                    queue.offer(currentNode.left);//add left node to queue
                }
                if(currentNode.right !=  null){//check if current node has right nodes
                    queue.offer(currentNode.right);//add right node to queue
                }
            };
            //get the average of level
            averageLevel = averageLevel / levelSize;
            //add level average to list
            result.add(averageLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {35,9,2,42,124,4,6,56,732,23,8};
        tree.populate(nums);

        tree.display();
    }

}
