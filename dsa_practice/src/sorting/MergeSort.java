package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        System.out.println(Arrays.toString(mergeSort(arr)));

    }

    static int[] mergeSort(int[] arr){
        System.out.println("array: " + Arrays.toString(arr));
        if(arr.length <= 1){
            return arr;
        }

        int mid = arr.length / 2;

        System.out.println(mid);
        int[] left = mergeSort(Arrays.copyOfRange(arr,0, mid));//here mid is excluded
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid, arr.length));//here mid element is included

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        //index for all 3 arrays
        int i = 0;//for left
        int j = 0;//for right
        int k = 0;//for mix array

        //first loop checks left and right arrays length
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        //if left or right array has more elements the add to mix as it is

        while(i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        System.out.println("sorted mix: " + Arrays.toString(mix));
        return mix;
    }
}
