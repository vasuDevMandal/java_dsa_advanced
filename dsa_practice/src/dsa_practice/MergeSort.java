package dsa_practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {2,1,4,5,3};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort( int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        //getting the answers
        int[] left = mergeSort(Arrays.copyOfRange(arr,0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge( left, right);
    }

    static int[] merge(int[] first, int[] second){

        int[] mix = new int[first.length + second.length];

        int i = 0;//current element pointer for first array
        int j = 0;//current element pointer for second array
        int k = 0;//current element pointer for mix array

        while (i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        //if one array finished before another
        //copy remaining elements
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;

    }
}
