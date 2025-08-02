package arraysQus;

import java.util.*;

public class arrayQusEsy {
    public static void main(String[] args) {
//        int[][] mat = {{3,7,8},{9,11,13},{15,16,17}};
//        int[][] mat = {{7,8},{1,2}};
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(mat.length);
//        System.out.println(mat[0].length);
//        System.out.println(addToArrayForm(new int[] {1,2,0,0},34));
//        System.out.println(32454%10);
//        System.out.println(32454/10);
//        System.out.println(Arrays.toString(sumZero(5)));

//        System.out.println(Arrays.toString(rowMin2dMat(mat)));
//        System.out.println(Arrays.toString(colMax2dMat(mat)));
//
//        List<Integer> list = luckyNumbers(mat);
//        System.out.println(list.getFirst());
//        System.out.println("\n"+maxSubArray(nums));

    }

    //66. Plus One
    static int[] plusOne(int[] digits) {
       int n = digits.length;
       //loop starts from last and go to first, to do proper carry propagation
        for (int i = n - 1; i >=0 ; i--) {
            //if least significant digit is smaller than 9 then add and return
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        //if all digits were 9 in the array
        int[] nums = new int[n+1];
        nums[0] = 1;
        return nums;
    }
    //fail for large inputs even long will fail
//    static int[] plusOne(int[] digits) {
//        StringBuilder sb = new StringBuilder();
//        for(int num : digits){
//            sb.append(num);
//        }
//        int combined = Integer.parseInt(sb.toString());
//        int res = combined + 1 ;
//
//        String resStr = String.valueOf(res);
//        int[] ans = new int[resStr.length()];
//
//        for (int i = 0; i < resStr.length(); i++) {
//            ans[i] = Character.getNumericValue(resStr.charAt(i));
//        }
//        return ans;
//    }

    //566. Reshape the Matrix
    int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        if((rows * cols) != (r*c)) return mat;

        //create new mat
        int[][] out = new int[r][c];
        int outRows = 0;
        int outCols = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                out[outRows][outCols] = mat[i][j];
                outCols++;//inner loop controls cols so we are updating them for 'out' here

                //max required cols reached so change rows
                if(outCols == c){
                    outCols = 0;
                    outRows++;
                }
            }
        }

        return out;
    }

    //53. Maximum Subarray
    static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    //1380. Lucky Numbers in a Matrix
    static List<Integer> luckyNumbers(int[][] matrix) {
        int[] maxInCols = colMax2dMat(matrix);
        int[] minInRows = rowMin2dMat(matrix);
        //minimum in row and max in col; number in both matrix is the ans
        //[3, 9, 15]
        //[15, 16, 17] |  ans -> 15
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < minInRows.length; i++) {
            for (int j = 0; j < maxInCols.length; j++) {
                if( minInRows[i] == maxInCols[j]){
                    list.add(minInRows[i]);
                }
            }
        }
        return list;
    }
    static int[] colMax2dMat(int[][] matrix) {
        int[] colMaxArr = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++){
            int maxInCol = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if(matrix[j][i] > maxInCol){
                    maxInCol = matrix[j][i];
                }
            }
            colMaxArr[i] = maxInCol;
        }
        return colMaxArr;
    }
    static int[] rowMin2dMat(int[][] matrix) {
        int[] rowMinArr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++){
            int min = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            rowMinArr[i] = min;
        }
        return rowMinArr;
    }


    //1304. Find N Unique Integers Sum up to Zero
    static int[] sumZero(int n) {
        int[] ans = new int[n];
        int start = 0;
        int end = n - 1;
        while(start < end){
            ans[start] = -(start + 1);
            ans[end] = start + 1;
            start++;
            end--;
        }
        return ans;
    }

    //1886. Determine Whether Matrix Can Be Obtained By Rotation
    static boolean findRotation(int[][] mat, int[][] target) {
        //check new matrix equal to target
        for (int i = 0; i < 4; i++) {
            if(matchMatrix(mat,target)){
                return true;
            }
            rotateMatrix(mat);
        }
        return false;
    }
    static boolean matchMatrix(int[][] mat,int[][] target){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    static void rotateMatrix(int[][] mat){
        int n = mat.length;
        //transpose only upper triangle
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i] = temp;
            }
        }
        //reverse
        for (int i = 0; i < n; i++) {
            int left = 0;//row start index
            int right = mat.length - 1;//row end index
            //swap
            while (left<right){
                int temp = mat[i][left];
                mat[i][left]=mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    //1854. Maximum Population Year
    public int maximumPopulation(int[][] logs) {
        int[] alive = new int[101];
        for(int[] log : logs){
            int birthYear = log[0];
            int deathYear = log[1];
            alive[birthYear - 1950]++;//inc count in person alive count
            alive[deathYear - 1950]--;//dec count, on alive array on year it dies
        }
        int year = 1950;//initial year
        int maxPop = alive[0]; // max population in year, 1950
        for (int i = 1; i < 101 ; i++) {
            alive[i] += alive[i-1];
            if(alive[i] > maxPop){
                maxPop = alive[i];
                year = 1950 + i;
            }
        }
        return year;
    }

    //989. Add to Array-Form of Integer
    static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length-1;

        while (i>=0 || k>0){//first k will finish
            if(i>=0){
                k += num[i];
                i--;
            }
            result.add(k%10);//add the last digit
            k/=10;//drop the last digit

        }
        Collections.reverse(result);
        return result;
    }

    //1252. Cells with Odd Values in a Matrix
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        int counter = 0;

        for(int[] k : indices){
            row[k[0]]++;
            col[k[1]]++;
        }
        for(int i = 0; i < row.length; i++){
            for(int j = 0; j < col.length; j++){
                if( (row[i] + col[j])%2 != 0 ) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // 832. Flipping an Image
    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] row : image) {
            //flip the row
            for (int i = 0; i < row.length / 2; i++){
                int temp = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
             for(int j = 0; j < row.length; j++){
                row[j] = row[j] == 0 ? 1 : 0;
            }
        }
        return image;
    }

// 1773. Count Items Matching a Rule
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> item : items){
            if(ruleKey.equals("type") && item.get(0).equals(ruleValue)){
                count++;
            }else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)){
                count++;
            } else if(ruleKey.equals("name") && item.get(2).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }

// 1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int current = 0;

        for(int height: gain){
            current = current + height;
            if(current > maxAltitude){
                maxAltitude = current;
            }
        }
        return maxAltitude;
    }
}
