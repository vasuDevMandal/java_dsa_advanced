package leetcodeProblems;

public class Q852_Peak_Index_in_a_Mountain_Array {
    public static void main(String[] args) {

        int[] arr = {2,3,4,5,6,8,5,6,4,3,2,1};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid +1]){
//                we are in decreasing part of array
//                it may be the answer, but we can still check left
                end = mid;
            }else{
//                we are in increasing part of the array
                start = mid + 1;
            }
        }
//            in the end both start and end will point to same location
        return start;
    }
}
