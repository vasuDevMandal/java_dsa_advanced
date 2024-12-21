package dsa_practice.questions;

import java.util.Arrays;

public class SelectionSortRecursion {
    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 1 };

        selectionSort(arr,arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
     }


    static void selectionSort(int[] arr, int row, int col, int max){
        //top up - bottom down
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[max]){
                selectionSort(arr, row, col+1 , col);
            }else{
                selectionSort(arr, row, col+1 , max);
            }
        }else{
            //now we have max in line, as full line compared
            //so, swap
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp ;
            //as one full line pass complete and 1 index sorted, max will default to 0 index again
            selectionSort(arr, row - 1, 0 , 0);
        }
    }
}
