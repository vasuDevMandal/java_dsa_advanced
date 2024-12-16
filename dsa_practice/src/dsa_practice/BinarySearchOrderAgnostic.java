package dsa_practice;

public class BinarySearchOrderAgnostic {

    public static void main(String[] args) {
//        int[] arr = {-34, -22, -11, -5 , 0, 3 ,5, 6,8,9,23,34,56,76};//asc
        int[] arr = {98,78,56,45,34,23,21,0,-2,-3,-5,-8,-11,-19,-34};//desc
        int target = -5;
        int ans = binarySearch(arr, target);

        System.out.print("ans: " + ans);

    }

    //return the index
    //return -1 if does not exist
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        //find array sorted in ascending or descending order
        boolean isAsc = arr[start] < arr[end];
        System.out.println( "sorted in " + (isAsc?"Ascending order" : "Descending order"));

        while(start <= end){
            //find the middle element
            //int mid = (start + end)/2; // possible that, (start + end) exceeds the range on int in java
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            if (isAsc){
                if(target < arr[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }

}
