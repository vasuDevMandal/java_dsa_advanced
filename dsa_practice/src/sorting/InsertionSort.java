package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7,4,5,8,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
//Concept:
//    Insertion Sort works like sorting cards in your hand.
//    We take one element at a time and insert it into the correct position in the sorted part of the array.
//Steps:
//    Base case: If size is 1, it's already sorted.
//    Sort the first n-1 elements recursively.
//    Insert the nth element into its correct position in the sorted subarray

    static void insertionSort(int[] arr){
//      we run this loop n-2 times,
//      with each iteration smallest element placed at start of the array
        for (int i = 0; i < arr.length - 1; i++) {
//          from position i to 0 we compare
            for (int j = i + 1; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }
}
