package arraysQus;

import java.util.*;

public class arrayQusEsy {
    public static void main(String[] args) {

//        int[][] mat = {{1,2},{2,3},{3,4}};
//        System.out.println(mat.length);
//        System.out.println(mat[0].length);

//        System.out.println(addToArrayForm(new int[] {1,2,0,0},34));
//        System.out.println(32454%10);
//        System.out.println(32454/10);

        System.out.println(Arrays.toString(sumZero(5)));
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
