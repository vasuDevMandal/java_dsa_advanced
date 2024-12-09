package dsa_practice;

public class BinaryTree {
	
	public TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void preOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
	}
	
	public static void main(String[] args) {
		
	}
	 

}
