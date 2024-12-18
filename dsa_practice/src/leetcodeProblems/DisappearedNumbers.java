package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
//google asked
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1 ;//element at this index should be arr[i]
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }

        //find missing numbers
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index +1){
                ans.add(index+1);
            }
        }

        return ans;
    }


    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}