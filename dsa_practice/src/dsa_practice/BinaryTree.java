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
	
	public void createBinaryTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		root = node1;
		
		node1.left = node2; // 2<-1->null
		node1.right = node4;// 2<-1->4
		node2.left = node3;// 3<-2->null
		node4.left = node5;//null<-4->5
		node4.right = node6;// 6<-4->5
	}

	//A <-- B --> C     | B is root | left root right
	// inOrder prints - A B C, as name is In-order
	public void InOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		if(root.left != null) {
			InOrderTraversal(root.left);
		}
		System.out.print(root.data + " ");
		if(root.right != null) {
			InOrderTraversal(root.right);
		}
		
	}
	
	//preOrder prints - B A C
	public void PreOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + " ");
		if(root.left != null) {
			PreOrderTraversal(root.left);
		}
		if(root.right != null) {
			PreOrderTraversal(root.right);
		}
		
	}
	
	//post-Order prints - A C B
		public void PostOrderTraversal(TreeNode root) {
			if(root==null) {
				return;
			}
			
			if(root.left != null) {
				PreOrderTraversal(root.left);
			}
			if(root.right != null) {
				PreOrderTraversal(root.right);
			}
			
			System.out.print(root.data + " ");
			
		}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree();
		TreeNode root = tree.root;
		
		System.out.print("In-order traversal: ");
		tree.InOrderTraversal(root);
		
		System.out.println();
		System.out.print("Pre-order traversal: ");
		tree.PreOrderTraversal(root);
		
		System.out.println();
		System.out.print("Post-order traversal: ");
		tree.PostOrderTraversal(root);
	}
	 

}
