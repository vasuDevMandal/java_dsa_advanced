package dsa_practice;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
		
//		root = node1;
//		
//		node1.left = node2; // 2<-1->null
//		node1.right = node4;// 2<-1->4
//		node2.left = node3;// 3<-2->null
//		node4.left = node5;//null<-4->5
//		node4.right = node6;// 6<-4->5
		
		root = node4;//binary tree
		
		node4.left = node2; node2.left = node1;node2.right= node3;
		node4.right = node5;node5.right = node6;
		
		
		
		
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
	
		public void PreOrderViaStack(TreeNode root) {
			if(root == null) {
				return;
			}
			
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			
			while(!stack.isEmpty()) {
				TreeNode temp = stack.pop();
				System.out.print( temp.data +" ");
				if(temp.right != null) {
					stack.push(temp.right);
				}
				if(temp.left != null) {
					stack.push(temp.left);
				}
			}
		}
		
		public void PostOrderViaStack(TreeNode root) {//ACB
			if(root == null) {
				return;
			}
			
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			stack1.push(root);
			
			while(!stack1.isEmpty()) {
				TreeNode temp = stack1.pop();
				stack2.push(temp);
				
				if(temp.left != null) {
					stack1.push(temp.left);
				}
				if(temp.right != null) {
					stack1.push(temp.right);
				}
			}
			
			// Output nodes in postorder
	        while (!stack2.isEmpty()) {
	            System.out.print(stack2.pop().data + " ");
	        }
		}
		
		public void InOrderViaStack(TreeNode root) {//ABC
			if(root == null) {
				return;
			}
			
			Stack<TreeNode> stack = new Stack<>();
			TreeNode temp = root;
			
			while(temp != null || !stack.isEmpty()) {
				if(temp != null) {
					stack.push(temp);
					temp = temp.left;
				}else {
					temp = stack.pop();
					System.out.print( temp.data +" ");
					temp = temp.right;
				}
			}
		}
		
		//using queue
		public void LevelOrderTraversal(TreeNode root) {
			if(root == null) {
				return;
			}
			Queue<TreeNode> q = new LinkedList<>();
			q.offer(root);
			while(!q.isEmpty()) {
				TreeNode temp = q.poll();
				System.out.print(temp.data+" ");
				if(temp.left != null) {
					q.offer(temp.left);
				}
				if(temp.right != null) {
					q.offer(temp.right);
				}
			}
		}
		
		
		
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree();
		TreeNode root = tree.root;
		System.out.println("\n____traversal using recursion");
		System.out.print("In-order traversal: ");
		tree.InOrderTraversal(root);
		
		System.out.println();
		System.out.print("Pre-order traversal: ");
		tree.PreOrderTraversal(root);
		
		System.out.println();
		System.out.print("Post-order traversal: ");
		tree.PostOrderTraversal(root);

		System.out.println();
		System.out.println("\n____traversal using Stack");
		System.out.print("In-order traversal via stack: ");
		tree.InOrderViaStack(root);
		
		System.out.println();
		System.out.print("pre-order traversal via stack: ");
		tree.PreOrderViaStack(root);
		
		System.out.println();
		System.out.print("post-order traversal via stack: ");
		tree.PostOrderViaStack(root);
		
		System.out.println();
		System.out.print("\n____Level order traversal via queue: \n");
		tree.LevelOrderTraversal(root);
	}
	 

}
