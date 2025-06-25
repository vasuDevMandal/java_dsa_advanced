package sorting;

import java.util.Arrays;

public class MergeSortInPlace {


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        mergeSortIP(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortIP(int[] arr, int s, int e){
        System.out.println("array: " + Arrays.toString(arr));
        if(e - s <= 1){
            return;
        }

        int mid = s + (e-s) / 2;

        System.out.println("mid: " + mid);

        mergeSortIP(arr, s , mid);//here mid is excluded
        mergeSortIP(arr, mid , e);//here mid element is included

        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int m, int e){
        int[] mix = new int[e - s];
        //index for all 3 arrays
        int i = s;//for left
        int j = m;//for right
        int k = 0;//for mix array

        //first loop checks left and right arrays length
        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        //if left or right array has more elements the add to mix as it is

        while(i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < e){
            mix[k] = arr[j];
            j++;
            k++;
        }

        System.out.println("sorted mix: " + Arrays.toString(mix));
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}
