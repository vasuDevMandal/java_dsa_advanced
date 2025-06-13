package Searching;

import java.util.Arrays;

public class BinarySearchSorted2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,30,40},
                {50,60,70,80},
                {90,100,110,120},
                {140,150,160,200}
        };

        System.out.println(Arrays.toString(search(matrix, 140)));
    }

    static int[] BinarySearch(int[][] matrix,int row, int cStart, int cEnd, int target){
        while (cStart <= cEnd){
            int mid = cStart + (cStart - cEnd)/2;
            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if(matrix[row][mid] < target){
                cStart = mid + 1;
            }else{
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] search(int[][] matrix , int target){
        int rows = matrix.length;
        int cols = matrix[0].length;// matrix may be empty

        if(rows == 1){
            return BinarySearch(matrix,0,0, cols-1,target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

//      run the loop till 2 rows are remaining
        while (rStart < (rEnd -1)){//while this true it will have more than 2 rows
            int rMid = rStart + (rEnd - rStart)/2;

            if(matrix[rMid][cMid] == target){
                return new int[]{rMid,cMid};
            }
            if(matrix[rMid][cMid] < target){
//                above rows elements are smaller, so ignore all above
                rStart = rMid;
            }else{
//                below all rows elements are larger, so ignore below rows
                rEnd = rMid;
            }
        }

//      now we have only 2 rows
//      check whether the target is in the col of 2 rows
        if(matrix[rStart][cMid] == target){
            return new int[]{rStart,cMid};
        }
        //rEnd or rStart+1
        if(matrix[rEnd][cMid] == target){
            return new int[]{rEnd,cMid};
        }

//        search in 1st half (1st row 1 half)
        if(target <= matrix[rStart][cMid-1] ){
            return BinarySearch(matrix, rStart, 0,cMid-1,target);
        }
//        search in 2nd half (1st row 2 half)
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return BinarySearch(matrix, rStart, cMid +1, cols-1 ,target);
        }
//        search in 3rd half (2nd row 1st half)
        if(target <= matrix[rEnd][cMid-1]){
            return BinarySearch(matrix, rEnd, 0, cMid-1 ,target);
        }
//        search in 4th half (2nd row 2nd half)
        if( target >= matrix[rEnd][cMid+1]){
            return BinarySearch(matrix, rEnd, cMid +1, cols-1 ,target);
        }




        return new int[]{-1,-1};
    }


}
