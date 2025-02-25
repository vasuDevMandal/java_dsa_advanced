package dsa_practice.trees;

import javax.swing.tree.TreeNode;
import java.util.*;

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

//levelOrder | https://leetcode.com/problems/binary-tree-level-order-traversal/
//bottomUp-levelOrder | https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
            //for bottom up use this result
            //result.add(0,currentLevel);//at first index we add below levels
            result.add(currentLevel);
        }
        return result;
    }
//https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //every iteration of while loop check single level as for loop run according to level size
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            //for loop is running over queue elements
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();//read every item from a queue
                if(i == levelSize-1){
                    result.add(currentNode.value);
                }
                if(currentNode.left !=  null){//check if current node has left node
                    queue.offer(currentNode.left);//add left node to queue
                }
                if(currentNode.right !=  null){//check if current node has right nodes
                    queue.offer(currentNode.right);//add right node to queue
                }
            };

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

    //https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return ( nodeLevel(root, xx, 0) == nodeLevel(root, yy, 0)) && (!isSibling(root, xx, yy));
    }

    private Node findNode(Node node, int x){
        if(node == null){
            return null;
        }
        if(node.value == x){
            return node;
        }
        Node n = findNode(node.left,x);
        if(n!=null){
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(Node node, Node x, Node y){
        if(node == null){
            return false;
        }
        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x)
                        || isSibling(node.left, x, y) || isSibling(node.right, x, y)
                );
    }

    int nodeLevel(Node node, Node x, int level){
        if(node == null){
            return 0;
        }
        if (node == x){
            return level;
        }

        int currentLevel = nodeLevel(node.left, x, level+1);
        if ( currentLevel != 0 ){
            return currentLevel;
        }
        return nodeLevel(node.right, x, level+1);
    }

    //https://leetcode.com/problems/symmetric-tree/description/
    public boolean isSymmetric(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.value != right.value){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }


    //google asked
    public Node findLevelOrderSuccessor(Node root, int key){
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //every iteration of while loop check single level as for loop run according to level size
        while(!queue.isEmpty()){

            Node currentNode = queue.poll();//read every item from a queue
            if(currentNode.left !=  null){//check if current node has left node
                queue.offer(currentNode.left);//add left node to queue
            }
            if(currentNode.right !=  null){//check if current node has right nodes
                queue.offer(currentNode.right);//add right node to queue
            }
            if(key == currentNode.value){
                break;
            }
        }
        return queue.peek();
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //from both ends we are adding and removing
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);//retrieves and removes first-element/head from deque
        boolean reverse = false;

        //every iteration of while loop check single level as for loop run according to level size
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            //for loop is running over deque elements
            for (int i = 0; i < levelSize; i++) {
                if(!reverse){
                    Node currentNode = deque.pollFirst();//read head item from a deque
                    currentLevel.add(currentNode.value);//adding to list
                    if(currentNode.left !=  null){//check if current node has left node
                        deque.addLast(currentNode.left);//add left node to deque
                    }
                    if(currentNode.right !=  null){//check if current node has right nodes
                        deque.addLast(currentNode.right);//add right node to queue
                    }
                }else{
                    Node currentNode = deque.pollLast();//read head item from a deque
                    currentLevel.add(currentNode.value);//adding to list

                    if(currentNode.right !=  null){//check if current node has right nodes
                        deque.addFirst(currentNode.right);//add right node to queue
                    }
                    if(currentNode.left !=  null){//check if current node has left node
                        deque.addFirst(currentNode.left);//add left node to deque
                    }
                }
            };
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }

    //DFS - https://leetcode.com/problems/diameter-of-binary-tree/description/
    int diameterOuter = 0;
    public int diameterOfBinaryTree(Node root) {
        heightD(root);
        return diameterOuter;
    }
    int heightD(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = heightD(node.left);
        int rightHeight = heightD(node.right);

        int currentNodeDiameter = leftHeight + rightHeight + 1;//+1 for currentRoot node
        diameterOuter = Math.max(diameterOuter,currentNodeDiameter);

        return Math.max(leftHeight, rightHeight);
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public Node invertTree(Node root) {
        if(root == null){
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    //DFS
    //Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(Node root) {
        return helper(root, null, null);
    }
    private boolean helper(Node node, Integer low, Integer high){
        if(node == null){
            return true;
        }

        if(low != null && node.value <= low){
            return false;
        }

        if(high != null && node.value >= high){
            return false;
        }

        boolean leftTree = helper(node.left, low, node.value);
        boolean rightTree = helper(node.right, node.value, high) ;

        return leftTree && rightTree;
    }


    //DFS - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public Node lowestCommonAncestor(Node node, Node p, Node q) {
        if(node == null){
            return null;
        }
        if(node == p || node == q){
            return node;
        }
        Node left = lowestCommonAncestor(node.left, p ,q);
        Node right = lowestCommonAncestor(node.right, p ,q);
        if(left != null && right != null){
            return node;
        }
        return left == null ? right : left;
    }

    //DFS - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    int count_KthSmallest = 0;
    public int kthSmallest(Node root, int k) {
        return HelperKthSmallest(root,k).value;
    }
    public Node HelperKthSmallest(Node node, int k) {
        if(node == null){
            return null;
        }
        Node left = HelperKthSmallest(node.left, k);
        if(left!=null){
            return left;
        }
        count_KthSmallest++;
        if(count_KthSmallest == k){
            return node;
        }
        return HelperKthSmallest(node.right, k);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {35,9,2,42,124,4,6,56,732,23,8};
        tree.populate(nums);

        System.out.println("is symmetric:" + tree.isSymmetric(tree.root));

//        tree.display();
    }

}
