package dsa_practice;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {23,4,6,76,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void bubbleSort(int[] arr){
        boolean swapped;
        //run step n-1 times
        for ( int i = 0 ; i < arr.length ; i++ ){
            swapped = false;
            //for each step, max item comes at last respective step
            for (int j = 1; j < arr.length - i ; j++) {
                if(arr[j] < arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //if value not swapped for particular value of i, it means the array is sorted hence stop the program
            if(!swapped){
                break;
            }
        }
    }
}
