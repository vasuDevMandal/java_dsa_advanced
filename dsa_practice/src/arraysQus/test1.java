package arraysQus;

import java.util.HashMap;

public class test1 {

    int[] nums = {2,7,11,15};
    int target = 9;

    int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++ ){
                if(nums[i] + nums[j] == target){
                    int[] arr =  {i,j};
                    return arr;
                }
            }
        }
        return null;
    }

//    two pass hash
    int[] twoSum2(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }

//        find the complement
        for(int i = 0; i < n; i++){
            int compliment = target - nums[i];

            if(map.containsKey(compliment) && (map.get(compliment) != i)){
                return new int[]{i, map.get(compliment)};
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {

    }
}
