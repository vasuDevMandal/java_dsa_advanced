package leetcodeProblems;

public class Q1672_richest_customer_wealth {
    public static void main(String[] args) {
       int[][] accounts = {{1, 2, 3}, {3, 2, 1,5}};

        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {

//        int[] totalWealthArr = new int[accounts.length];

        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++){
           int count = 0;
            for (int num: accounts[i]){
                count = count + num;
            }
            if(count > maximum){
                maximum = count;
            }
//            totalWealthArr[i] = count;
        }

//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < totalWealthArr.length; i++) {
//            if(totalWealthArr[i] > max){
//                max = totalWealthArr[i];
//            }
//        }

//        return max;

        return maximum;
    }
}
