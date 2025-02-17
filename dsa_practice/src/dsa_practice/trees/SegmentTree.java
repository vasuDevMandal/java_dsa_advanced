package dsa_practice.trees;

class SegmentTree {

    public static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    Node root;


    public SegmentTree(int[] arr){
        //create a tree using this array
        this.root = constructTree(arr, 0 , arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start == end){
            //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create a node with start and end index you are currently at
        Node node = new Node(start, end);

        int mid = (start + end )/2;

        node.left = this.constructTree(arr,start , mid);
        node.right = this.constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }
    public void display(Node node){
        String str = "";

        if(node.left != null){
            str = str + "Interval["+ node.left.startInterval+ "-" + node.left.endInterval+"] and data:" + node.left.data + " => ";
        } else {
            str = str + "\tNo left child => ";
        }

        //for current node
        str = str + "Interval["+ node.startInterval+ "-" + node.endInterval+"] and data:" + node.data + " <= ";

        if(node.right != null){
            str = str + "Interval["+ node.right.startInterval+ "-" + node.right.endInterval+"] and data:" + node.right.data ;
        } else {
            str = str + " No right child";
        }

        System.out.println(str);

        //call recursion
        if(node.left != null){
            display(node.left);
        }
        if(node.right != null){
            display(node.right);
        }

    }

    //query | qsi - queryStartIndex, qei - queryEndIndex
    public int Query(int qsi, int qei){
        return this.Query(this.root, qsi, qei);
    }

    private int Query(Node node, int qsi, int qei ){
        if(node.startInterval >= qsi &&  node.endInterval <= qei ){
            //node is completely lying inside the query range
            return node.data;
        }else if(node.startInterval > qei || node.endInterval < qsi){
            //node is completely outside query range
            return 0;
        }else{
            return this.Query(node.left,qsi,qei) + this.Query(node.right,qsi,qei);
        }
    }

    //update function
    public void update(int index ,int value){
         this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }else{
                int leftAns = this.update(node.left, index, value);
                int rightAns = this.update(node.right, index, value);

                return leftAns + rightAns;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 6, 7, -2, -8, -4, 9};

        SegmentTree st = new SegmentTree(arr);

        st.display();

        System.out.println("\nquery");
        System.out.println("query-[0,2] data: "+ st.Query(0,2));

        System.out.println("\nupdate--");
        st.update(3,0);
        st.display();
    }
}
