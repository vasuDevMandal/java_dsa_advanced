package dsa_practice.stackNqueues;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(this.isFull()){
          //double the array size
          int[] temp = new int[data.length * 2];
          
          //copy all previous items into new array
            for (int i = 0; i < data.length ; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        //at this point we know array is not full as size is modified if it was full
        return super.insert(item);
    }
}
