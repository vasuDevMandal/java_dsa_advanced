package arraysQus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//questions from
//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/05-arrays.md

public class EasyArraysQus {
    public static void main(String[] args) {

//        int[] nums = {1,2,3,4};
//        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};

//        System.out.println(Arrays.toString(runningSum(nums)));
//        System.out.println(Arrays.toString(runningSumOneLoop(nums)));
//        System.out.println(maximumWealth(accounts));
//        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));

//        int[] candies = {2,3,5,1,3};
//        System.out.println(kidsWithCandies(candies,3));

    }

//    1512. Number of Good Pairs
    static int numIdenticalPairs(int[] nums) {

    }


//    1431. Kids With the Greatest Number of Candies
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            if (max < candy) {
                max = candy;
            }
        }
        for (int candy : candies) {
            if (max <= (candy + extraCandies)) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

//    1470. Shuffle the Array
    static int[] shuffle(int[] nums, int n) {
        int gap = n;
        System.out.println(gap);
        int[] ans = new int[nums.length];
        int xCounter = 0;
        int yCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i%2 == 0){
                //even index
                ans[i] = nums[xCounter];
                xCounter++;
            }else{
                //odd index
                ans[i] = nums[gap + yCounter];
                yCounter++;
            }
        }
        return ans;
    }

    static int maximumWealth(int[][] accounts) {
        int[] ans = new int[accounts.length];
        int max = ans[0];
        for (int i = 0; i < accounts.length; i++){
            for (int j = 0; j < accounts[0].length; j++){
                ans[i] += accounts[i][j];
            }
            if(max < ans[i]){
                max = ans[i];
            }
        }
        return max;
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
