package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {

    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        System.out.println(disappearedNumber(input));
    }

    static List<Integer> disappearedNumber(int[] arr) {
        cyclicSort(arr);
        int i=0;
        List<Integer> ans = new ArrayList<>();
        while(i < arr.length){
            if(arr[i] != i+1){
                ans.add(i+1);
            }
            i++;
        }
        return ans;
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] -1;
            if( arr[i] != arr[correct] ){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr,int  first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
