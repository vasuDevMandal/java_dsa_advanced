package Searching;

public class InfiniteArray {
    public static void main(String[] args) {

        int[] arr = {2,4,5,7,12,23,45,56,65,87,99,213,465,567};
        int target = 12;

        System.out.println(searchArray(arr,target));

    }

    static int searchArray(int[] arr, int target){
//        first find the range
//        first start with the box of size 2
        int start = 0;
        int end  = 1;

//        condition for target lie it the range
        while(target > arr[end]){
            int newStart = end + 1;
//            double the size of slice
//            end = previous end * 2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end ){
            int mid = start + (end - start)/2;
            if(target > arr[mid]){
                start = mid + 1;
            } else if (target < arr[mid]){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
