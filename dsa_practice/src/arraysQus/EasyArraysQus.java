package arraysQus;

import java.util.Arrays;

public class EasyArraysQus {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(runningSum(nums)));
        System.out.println(Arrays.toString(runningSumOneLoop(nums)));
    }

    static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j >= 0; j--){
                ans[i] = ans[i] + nums[j];
            }
        }
        return ans;
    }

    static int[] runningSumOneLoop(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans[i] += ans[i-1] + nums[i];
        }
        return ans;
    }
}
