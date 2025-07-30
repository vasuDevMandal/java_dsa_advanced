package arraysQus;

import java.util.List;

public class arrayQusEsy {
    public static void main(String[] args) {

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
