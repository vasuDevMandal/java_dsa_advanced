package dsa_practice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {23,45,677,8,82,-23,34,0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

   static void selectionSort(int[] arr){
        for(int i = 0 ; i<arr.length ; i++ ){
            //find max item in the remaining array and swap with correct index
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0 , last);
            swap(arr, maxIndex , last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for (int i = start; i <= last; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
