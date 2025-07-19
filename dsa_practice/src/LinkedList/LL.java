package LinkedList;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = node;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;

    }

    public void insertAtIndex(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
//        node.next = temp.next;
        temp.next = node;

        size++;

    }

    public void InsertViaRecursion(int val, int index){
        head = InsertRec(val, index, head);

    }

    private Node InsertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = InsertRec(val, --index, node.next);
        return node;
    }


    public void removeDuplicates(){
        System.out.println("remove duplicates..");
        Node node = head;
        while (node.next != null){
            if(node.value == node.next.value ){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;

    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;
        size--;

        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    public int findIndex(int val){
        Node node = head;
        int count = 0;
        while (node != null){
            if(val == node.value){
                return count;
            }
            count++;
            node = node.next;
        }
        return 0;

    }
    public Node find(int val){
        Node node = head;
        while (node != null){
            if(val == node.value){
                return node;
            }
            node = node.next;
        }
        return null;

    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display(){
        System.out.println("-Display-");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int val){
            this.value = val;
        }

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }

    void sortViaBubble(){
        sortViaBubbleSort(size - 1, 0);
    }

    private void sortViaBubbleSort(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get( col);
            Node second = get( col+ 1);
            if(first.value > second.value){
                //swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){
                    Node prev = get(col-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col -1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }

            sortViaBubbleSort(row, col + 1);
        }else {
            sortViaBubbleSort(row - 1, 0);
        }

    }

//    recursion reverse of linked list
    void reverseListRecursive(Node node){
        //base condition
        if(node == tail){
            head = tail;
            return;
        }
        //it keeps calling itself, till it reach the last node and call base condition
        reverseListRecursive(node.next);

        //it starts executing, when we are at last node
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //iterative reverse linked list
    public void reverseIter(){
        System.out.println("iterative reverse list");
        if(size < 2){
            return;
        }
    //    initializing pointers
        Node prev = null;
        Node present = head;
        Node next = present.next;
    //  loop for iterating over all list items
        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }

    //reverse in between
    public void reverseBetween(Node head, int left, int right){
        System.out.println("iterative reverse list");
        if(size < 2){
            return;
        }
        //    initializing pointers
        Node prev = null;
        Node present = head;
        Node next = present.next;
        //  loop for iterating over all list items
        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }


}
