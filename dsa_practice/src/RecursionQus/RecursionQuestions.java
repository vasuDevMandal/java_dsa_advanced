package RecursionQus;

import java.util.Arrays;

public class RecursionQuestions {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        printTriangle(nums);
//        int[] arr = {1, 4, 3, -5, -4, 8, 6};
//        System.out.println(Arrays.toString(findMinMax(arr)));

//        int[] nums = {-1,0,3,5,9,12};
//        System.out.println(binarySearchRec(nums, 5));

    }

    //704. Binary Search
    static int binarySearchRec(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return bSearchRec(nums, target, start, end);
    }

    private static int bSearchRec(int[] nums, int target, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(target == nums[mid]){
            return mid;
        }
        if(target > nums[mid]){
            return bSearchRec(nums,target, mid + 1, end);
        }else if(target < nums[mid]){
            return bSearchRec(nums, target, start, mid -1);
        }
        return  -1;
    }

    //find min max in array
    static int[] findMinMax(int[] arr){
        int n = arr.length;
        int[] res = new int[2];
        res[0] = findMinRec(arr,n);
        res[1] = findMaxRec(arr,n);
        return res;
    }
    static int findMinRec(int[] nums, int n){
        if(n == 1){
            return nums[0];
        }
        int min = findMinRec(nums,n-1);
        if(nums[n-1] < min){
           return nums[n-1];
        }else{
            return min;
        }
    }
    static int findMaxRec(int[] nums, int n){
        if(n == 1){
            return nums[0];
        }
        int max = findMaxRec(nums,n-1);
        if(nums[n-1] > max){
            return nums[n-1];
        }else{
            return max;
        }
    }

    //Sum triangle from array
    //https://www.geeksforgeeks.org/dsa/sum-triangle-from-array/
    static void printTriangle(int[] nums){
        if(nums.length < 1){
            return;
        }
        int[] ans = new int[nums.length-1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i] + nums[i+1];
        }
        printTriangle(ans);
        System.out.println(Arrays.toString(nums));
    }
}
