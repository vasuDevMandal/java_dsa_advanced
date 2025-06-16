package sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while (i < arr.length){
//          value at arr[i] has its correct position at arr[i] - 1
//          if at any index we find a value 5, then its correct position is 5 - 1 = 4
            int correct = arr[i] - 1;

//          whatever is at the correct index of 5 is swapped with current position of 5
//          if value at correct index is correct then skip the swap
            if(arr[i] == arr[correct] ){
                i++;
            }else{
                swap(arr, i, correct);
            }
        }
    }

    static void swap(int[] arr,int  first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
