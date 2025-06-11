package Searching;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class Q1295_Find_Numbers_with_Even_Number_of_Digits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896,252525,2525};

        int result = findEven(nums);

        System.out.println(result);
    }

    static int findEven(int[] arr){
        int counter = 0;
        for( int num : arr ){
            if((((int)Math.log10(num) + 1) % 2) == 0){
                counter++;
            }
        }

        return counter;
    }

//    static boolean even(int num) {
//        int count = 0;
//        while (num > 0){
//            count++;
//            num = num/10;
//        }
////        return count % 2 == 0;
//        return (int)Math.log10(num) + 1;
//    }
}
