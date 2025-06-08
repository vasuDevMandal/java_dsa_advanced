package arraysQus;

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


    public static void main(String[] args) {

        int[][] nums = { {1,24,45,6}, {2, 3, 57, 7}, {3,5,7,8}};
        int[] nums2 = {2,7,11,15};
        int target = 9;

//        compare full array, it compares 2->3 and 3->2, has repeated comparisons
//        useful in printing 2d array , not in comparison
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j ++){
                System.out.print(nums[i][j] + " ");
               }
            System.out.println();
        }

        int max = 0;
//        compare every element only 1 time, useful in comparing 1d array with its own elements
        for(int i = 0; i < nums2.length; i++){
            System.out.println( "nums2[" + i + ']' + nums2[i]);
            for(int j = i + 1; j < nums2.length; j++ ){
                System.out.println( "------------nums2[" + j + ']' + nums2[j]);
                if(nums2[i] + nums2[j] == target){
                    int[] arr =  {i,j};

                }
            }

        }

    }
}
