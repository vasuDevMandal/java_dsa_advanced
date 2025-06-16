package sorting;

import java.util.Arrays;

//select an element and put it in right position
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
//            find the maximum item in the remaining array and swap it with correct index
            int last = arr.length - 1 - i ;
            int max = getMaxIndex(arr,0 , last);
            swap(arr, max, last);
        }
    }

    private static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }


    private static int getMaxIndex(int[] arr,int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

}
