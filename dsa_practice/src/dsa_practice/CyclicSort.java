package dsa_practice;

import java.util.Arrays;

//to solve it in single pass we use cyclic sort
//** VERY Important: when given numbers from range 1 to N, use cyclic sort
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {4,5,3,2,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

   static void cyclicSort(int[] arr){
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1;//element at this index should be arr[i]
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
   }


    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
