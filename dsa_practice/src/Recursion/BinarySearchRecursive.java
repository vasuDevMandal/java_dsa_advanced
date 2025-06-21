package Recursion;

public class BinarySearchRecursive {
    public static void main(String[] args) {

        int[] arr = {2,3,5,7,9,12,24,45,67,78};
        System.out.println(binarySearch(arr,67));
    }

    static int binarySearch(int[]arr, int target){
        int start = 0;
        int end = arr.length-1;

        return search(arr,target,start,end);
    }

    static int search(int[]arr, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end - start)/2;
        //1st condition - target at middle
        if(arr[mid] == target){
            return mid;
        }
        //2nd condition-left side
        if(target < arr[mid]){
            return search(arr, target, start, mid - 1);
        }
        //3rd condition-right side
        return  search(arr, target, mid + 1, end);
    }
}
