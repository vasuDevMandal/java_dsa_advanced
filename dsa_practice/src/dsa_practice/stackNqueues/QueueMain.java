package dsa_practice.stackNqueues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue q = new CustomQueue(5);

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        q.display();
        System.out.println(q.remove());
        q.display();
//        q.front();
    }
}
