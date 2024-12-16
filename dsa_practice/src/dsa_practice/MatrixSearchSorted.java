package dsa_practice;

import java.util.Arrays;

public class MatrixSearchSorted {

    public static void main(String[] args) {

        int[][] arr = {
                {10,20,30,40},
                {50,60,70,80},
                {90,100,110,120},
                {130,140,150,160}
        };

        System.out.println(Arrays.toString(search(arr,90)));
    }

    static int[] search(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length - 1;


        while(r < matrix.length && c >= 0){
            System.out.println("row: " + r + " col: " + c + " | val: " + matrix[r][c] + " target:" +target);
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }
            if(matrix[r][c] < target){
                r++;
            }else{
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
