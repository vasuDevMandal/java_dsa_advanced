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

//        insertionSortRec(new int[] {3,2,4,1}, 4);
//        int[] arr = new int[] {3,2,4,1};
//        selectionSortRec(arr,0);
//        System.out.println(Arrays.toString(arr));

//        System.out.println(sumRec(33));
//        System.out.println(isPrimeRec(3,2));

//        System.out.println(naturalNumSum(3));
//        System.out.println(isPowerOfTwo(16));
//        System.out.println(findPower(16,4));

//        int[] numSorted= {10,20,30,40,50};
//        int[] num2 = {20,25,40,30,50};
//        System.out.println(isSorted(num2,0));

//        System.out.println(numberOfSteps(15));
        System.out.println(removeDuplicatesStr("aaabbccccddd",0));
    }

    //remove Duplicates from string
    static String removeDuplicatesStr(String str, int i){
        if (i == str.length()-1) return String.valueOf(str.charAt(i));
        if(str.charAt(i)== str.charAt(i+1)){
            return removeDuplicatesStr(str,i+1);
        }
        return str.charAt(i) + removeDuplicatesStr(str,i+1);
    }

    //1342. Number of Steps to Reduce a Number to Zero
    static int numberOfSteps(int num) {
        return steps(num , 0);
    }
    private static int steps(int num, int steps) {
        if(num <= 0) return steps;
        if(num % 2 == 0){
            num /= 2;
            return steps(num, steps + 1);
        }else {
            num--;
            return steps(num, steps + 1);
        }
    }

    //Check if an Array is Sorted
    static boolean isSorted(int[] arr, int i){
        if(arr.length == 1) return true;
        if(i < arr.length - 1){
            return (arr[i] <= arr[i+1]) && isSorted(arr,i+1) ;
        }
        return true;
    }

    //Write a recursive function for given n(total) and a(number) to determine x, n = a^x
    static int findPower(int n, int a){
        return (int)(Math.log10(n) - Math.log10(a));
    }

    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n%4 == 0) {
            return isPowerOfFour(n / 4);
        }
        return false;

    }


    //231. Power of Two
    static boolean isPowerOfTwoBitShift(int n) {
       int x = 1;
       while (x <= n){
           if(x == n) return true;
           x = x << 1;
       }
       return false;
    }
    static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            int ans = (int)Math.pow(2,i);
            if(ans == n){
                System.out.println(n + " is power of 2^" + i);
                return true;
            }
        }
        return false;
    }

    //Sum of natural numbers using recursion
    static int naturalNumSum(int n){
        if(n<=1){
            return n;
        }
        return n + naturalNumSum( n-1);
    }

    //Recursive program for prime number, i is the divisior
    static boolean isPrimeRec(int num, int i){
        if(num <= 2){
            return (num == 2) ? true : false;
        }
        if (num % i == 0){
            return false;
        }
        if( i*i > num ){
            return true;
        }
        return isPrimeRec(num, i + 1);
    }
    static boolean isPrime(int num){
        //prime are greater than 1, only divisible by 1 and itself
        if(num <= 1){
            return false;
        }
        for (int i = 2; i * i< num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }



    //Sum of digit of a number using recursion
    static int sumRec(int num){
        if(num < 10){
            return num;
        }
        int digit = num % 10;
        num = num / 10;

        return digit + sumRec(num);
    }

    //selection sort recursive
    static void selectionSortRec(int[] nums, int start){
        if(start >= nums.length - 1){
            return;
        }
        int minIndex = start;
        for (int i = start+1; i < nums.length; i++) {
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
        }
        //swap
        int temp = nums[start];
        nums[start] = nums[minIndex];
        nums[minIndex] = temp;

        selectionSortRec(nums, start + 1);
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
