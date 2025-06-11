package Searching;

import java.util.Arrays;

public class Q34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] ans = searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1,-1};
        int startValue = search(nums, target, true);
        int endValue = search(nums, target, false);

        ans[0] = startValue;
        ans[1] = endValue;

        return ans;
    }

    static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if( target < nums[mid]){
                end = mid -1;
            }else if( target > nums[mid]){
                start = mid + 1;
            }else{
//                potential answer
                ans = mid;

                if(findStartIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

