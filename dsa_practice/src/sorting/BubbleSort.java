package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,3,8,9,32,56,6,10};
//        bubbleSort2(arr);
        bubbleSortDetails(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort1(int[]arr){
        for (int i =0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    static void bubbleSort2(int[]arr){
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

    static void bubbleSortDetails(int[]arr){
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++){
            swapped = false;
            System.out.println("\nouter loop - index: " + i);
            System.out.println("arr:" + Arrays.toString(arr));
            for (int j = 1; j < arr.length - i; j++) {
                System.out.println("\tinner loop - index: " + j);
                if(arr[j-1] > arr[j]){
                    swapped = true;
                    System.out.println("\t\tswapped");
                    System.out.println("\t\t\tindexes: " + (j-1) + "<=>" + j );
                    System.out.println("\t\t\tvalues: " + arr[j-1] + " <=> " + arr[j]);
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                }
            }
            if (!swapped){
                //array is sorted
                return;
            }
        }
    }

}
