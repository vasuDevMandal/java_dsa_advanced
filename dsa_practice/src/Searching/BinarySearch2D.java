package Searching;

import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = { {10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
        System.out.println(Arrays.toString(search(matrix, 28)));
    }

    static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1; //comparing to every last element the row

        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row,col};
            }
            if(matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}

