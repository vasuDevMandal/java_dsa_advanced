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
//        System.out.println(findFirstUpperCaseChar("thisisiNDia"));

//        char[] s = {'h','e','l','l','o','a'};
//        reverseStringInPlace(s);
//        reverseStringInPlaceRec(s);
//        System.out.println(Arrays.toString(s));

//        printNos(5);

//        System.out.println(fib(3));
//        System.out.println(recLen("this"));

        insertionSortRec(new int[] {3,2,4,1}, 4);

    }
    //insertion sort recursive, n is nums length
    static void insertionSortRec(int[] nums, int n){
        if(n <= 1){
            return;
        }

        insertionSortRec(nums, n - 1);

        int last = nums[n - 1];
        int j = n-2;

        while(j>=0 && nums[j] > last){
            nums[j+1] = nums[j];
            j--;
        }

        nums[j+1] = last;
    }


    //length of a string using recursion
    //https://www.geeksforgeeks.org/dsa/program-for-length-of-a-string-using-recursion/
    static int recLen(String str){
        if(str.isEmpty()){
            return 0;
        }else{
            return recLen(str.substring(1)) + 1;
        }
    }

    //509. Fibonacci Number
    static int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    //Print 1 To N Without Loop
    //https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1
    static void printNos(int n) {
        if(n<1){
           return;
        }
        printNos(n-1);
        System.out.print(n + " ");
    }

    //344. Reverse String
    static void reverseStringInPlaceRec(char[] s) {
        int start = 0;
        int end = s.length-1;
        reverseStringRec(s, 0,start,end);
    }

    private static void reverseStringRec(char[] s, int i, int start, int end) {
        if(start < end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            reverseStringRec(s,i+1, start+1, end-1);
        }
    }

    static void reverseStringInPlace(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start < end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }


    //First uppercase letter in a string
    static char findFirstUpperCaseChar(String str){
        return firstUpperCase(str,0);
    }
    static char firstUpperCase(String str, int i){
        if(str.charAt(i)=='\0'){
            return 0;
        }
        if( Character.isUpperCase(str.charAt(i))){
            return str.charAt(i);
        }else{
            return firstUpperCase(str,i+1);
        }
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
