package Trees;

import java.util.Scanner;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        bt.Populate(scanner);
        bt.Display();

    }

    public BinaryTree(){

    }

    public static class Node{
        int value;
        Node right;
        Node left;

        public Node(int val){
            this.value = val;

        }
    }

    private Node root;

    //insert elements
    public void Populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();

        root = new Node(value);

        populate(scanner, root,0);
    }

    private void populate(Scanner scanner, Node node, int level) {
        System.out.println("(type true or false) Do you want to left of " + node.value + " | level: " + level);
        boolean left = scanner.nextBoolean();//0 ,1
        if(left){
            System.out.println("Enter value for the left of " + node.value + " | level: " + level );
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left, level + 1);
        }

        System.out.println("(type true or false) Do you want to right of " + node.value + " | level: " + level);
        boolean right = scanner.nextBoolean();//0 ,1
        if(right){
            System.out.println("Enter value for the right of " + node.value + " | level: " + level);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right,level + 1);
        }
    }

    public void Display(){
        diplay(root, "");
    }

    private void diplay(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        diplay(node.left, indent+"\t");
        diplay(node.right, indent+"\t");
    }


}


