package LinkedList.Questions;

import java.util.Arrays;

public class cycleSort {
    public static void main(String[] args) {
        int[] nums = {5,1,4,2,3};
        System.out.println(Arrays.toString(nums));
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while(arr.length > i){
            int correct = arr[i] - 1;//correct position of the current element;
            if(arr[i] == arr[correct]){
                i++;
            }else{
                swap(arr,i, correct);
            }
        }
    }

    private static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}
