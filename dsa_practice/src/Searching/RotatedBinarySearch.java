package Searching;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,9,0,1,4};
        System.out.println(findPivot(arr));
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

//      if pivot not found or -1, means array is not rotated
        if(pivot == -1){
            return binarySearch(nums,target, 0 , nums.length - 1);
        }
//        case  1
        if(nums[pivot] == target){
            return pivot;
        }
//        case 2
        if(target  >= nums[0]){
            return binarySearch(nums, target, 0, pivot - 1);
        }
//        case 3
        return binarySearch(nums, target,pivot+1, nums.length-1);
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

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length -1 ;
        while(start <= end ){
            int mid = start + (end - start)/2;
//            4 cases
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid-1;
            }
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
