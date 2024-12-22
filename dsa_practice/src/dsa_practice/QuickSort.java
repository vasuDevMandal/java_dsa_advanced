package dsa_practice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {3,4,2,5,1};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] num, int low, int hi){
        if(low>= hi){
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e-s) /2;
        int pivot = num[m];

        while(s < e){
            while(num[s] < pivot){
                s++;
            }
            while(num[e] > pivot){
                e--;
            }

            if( s <= e){
                int temp = num[s];
                num[s] = num[e];
                num[e] = temp;
                s++;
                e--;
            }
        }

        //now pivot is at correct index, sort other halves of list
        quickSort(num, low, e);
        quickSort(num, s, hi);





    }






}
