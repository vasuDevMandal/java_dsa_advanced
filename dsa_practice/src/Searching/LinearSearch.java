package Searching;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int [][] arr = {
                {34,56},
                {323,5,7,8},
                {34,56,35,7},
                {6,9,4,25,7}
        };
        int target = 4;
        int[] result = search(arr, target);
        System.out.println(Arrays.toString(result));

    }

    static int[] search(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }


}
