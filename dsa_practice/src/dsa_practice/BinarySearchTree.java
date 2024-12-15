package dsa_practice;


public class BinarySearchTree {
	
	private TreeNode root;
	
	private class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value){
			this.data = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert(TreeNode root,int value) {
		TreeNode newnode = new TreeNode(value);
		if(root == null) {
			root = newnode;
			return newnode;
		}
		if(value < root.data) {
			root.left = insert(root.left, value);
		}else {
			root.right = insert(root.right, value) ;
		}
		
		return root;
		
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {			
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public TreeNode search(TreeNode root, int value) {
		if(root == null || root.data == value) {//base case
			return root;
		}
		
		if(value < root.data) {
			return search(root.left, value);
		}else {
			return search(root.right, value);
		}
		
	}
	public boolean isValid(TreeNode root, long min, long max) {
		if(root == null) {//base case
			return true;
		}
		
		if(root.data < min || root.data > max) {
			return false;
		}
		boolean left = isValid(root.left, min, root.data);
		if(left) {
			boolean right = isValid(root.right, root.data, max);
			return right;
		}
		
		return false;
	}
	
	public void createInValidBinaryTree() {
		TreeNode node1 = new TreeNode(404);
		root.left = node1;
		
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(5);
//		bst.createInValidBinaryTree();// un-comment for making tree invalid
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.inOrder(bst.root);
		
		System.out.println();
		System.out.println("find key:" + bst.search(bst.root,3).data);
		
		System.out.println("is valid tree: " + bst.isValid(bst.root, Long.MIN_VALUE, Long.MAX_VALUE));
	}

}
