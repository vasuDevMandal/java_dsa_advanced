package arraysQus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class arrayQusEsy {
    public static void main(String[] args) {

//        int[][] mat = {{1,2},{2,3},{3,4}};
//        System.out.println(mat.length);
//        System.out.println(mat[0].length);

        System.out.println(addToArrayForm(new int[] {1,2,0,0},34));
//        System.out.println(32454%10);
//        System.out.println(32454/10);
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
