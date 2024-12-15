package dsa_practice;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {-34, -22, -11, -5 , 0, 3 ,5, 6,8,9,23,34,56,76};
        int target = -5;
        int ans = binarySearch(arr, target);

        System.out.print("ans: " + ans);

        System.out.println();
    }

    //return the index
    //return -1 if does not exist
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            //find the middle element
            //int mid = (start + end)/2; // possible that, (start + end) exceeds the range on int in java
            int mid = start + (end - start) / 2;

            if(target < arr[mid] ){
                end = mid - 1;
            } else if ( target > arr[mid]){
                start = mid + 1;
            }else{
                //ans found
                return mid;
            }
        }

        return -1;
    }
}