package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,5,8,9,32,56,6,10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[]arr){
        boolean swapped;
        for (int i =0; i < arr.length; i++){
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]){
//                    swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
//            if not swapped in any value of i, that means array is sorted
            if(!swapped){
                break;
            }
        }

    }
}
