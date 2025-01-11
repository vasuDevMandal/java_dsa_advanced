package dsa_practice.stackNqueues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue q = new CustomQueue(5);
//
//        q.insert(1);
//        q.insert(2);
//        q.insert(3);
//        q.insert(4);
//        q.insert(5);
//
//        q.display();
//        System.out.println(q.remove());
//        q.display();

//        CircularQueue cq = new CircularQueue(5);
//        cq.insert(1);
//        cq.insert(2);
//        cq.insert(3);
//        cq.insert(4);
//        cq.insert(5);
//        cq.display();
//        System.out.println(cq.remove());
//        cq.display();
//        cq.insert(21);
//        cq.display();

        DynamicQueue dq = new DynamicQueue(5);
        dq.insert(1);
        dq.insert(2);
        dq.insert(3);
        dq.insert(4);
        dq.insert(5);
        dq.insert(34);
        dq.display();

        System.out.println(dq.remove());
        dq.display();
        dq.insert(12);
        dq.display();
    }
}
