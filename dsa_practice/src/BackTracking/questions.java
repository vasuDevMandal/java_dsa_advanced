package BackTracking;

import java.util.*;

public class questions {
    public static void main(String[] args) {

//        System.out.println(coinChange(new int[]{1,2,5}, 6));

        List<String> list =  letterCasePermutation("a1b2");
        System.out.println(list);

    }
//784. Letter Case Permutation

    //DFS approach
    static List<String> letterCasePermutation(String S) {
        //DFS approach
        List<String> result = new LinkedList<>();
        recurse(S.toCharArray(), 0 , result);
        return result;
    }

    static void recurse(char[] str, int pos, List<String> result){
        //base case
        if(pos == str.length){
            result.add(new String(str));
            return;
        }

        //if digit, do nothing
        //or use Character.isDigit()
        if(str[pos] >= '0' && str[pos] <= '9'){
            recurse(str,pos+1, result);
            return;
        }

        //DFS traverse, to leftmost node first
        str[pos] = Character.toLowerCase(str[pos]);
        recurse(str, pos+1, result);

        str[pos] = Character.toUpperCase(str[pos]);
        recurse(str, pos+1, result);
    }



    //BFS approach - 784. Letter Case Permutation
//    static List<String> letterCasePermutation(String S) {
//        if(S == null){
//            return new LinkedList<>();
//        }
//
//        //BFS require queue
//        Queue<String> queue = new LinkedList<>();
//        queue.add(S);
//
//        //we dynamically add values in queue,
//        //so it traverses level by level
//        for(int i = 0; i < S.length(); i++){
//            if(Character.isDigit(S.charAt(i))) continue;
//
//            int size = queue.size();
//            for(int j = 0; j < size; j++){
//                String cur = queue.remove();
//                char[] charArr = cur.toCharArray();
//
//                charArr[i] = Character.toUpperCase(charArr[i]);
//                queue.add(String.valueOf(charArr));
//
//                charArr[i] = Character.toLowerCase(charArr[i]);
//                queue.add(String.valueOf(charArr));
//            }
//        }
//        return new LinkedList<>(queue);
//    }


    //Backtrack approach - 784. Letter Case Permutation
//    static List<String> letterCasePermutation(String S) {
//        List<String> result = new ArrayList<>();
//        recurse(S.toCharArray(),0, result);
//        return result;
//    }
//
//    static void recurse(char[] str, int pos, List<String> result) {
//        if(pos == str.length){
//            result.add(new String(str));
//            return;
//        }
//        if(Character.isLetter(str[pos])){
//            if(Character.isUpperCase(str[pos])){
//                str[pos] = Character.toLowerCase(str[pos]);
//                recurse(str, pos+1, result);
//                str[pos] = Character.toUpperCase(str[pos]);
//            }else{
//                str[pos] = Character.toUpperCase(str[pos]);
//                recurse(str, pos+1, result);
//                str[pos] = Character.toLowerCase(str[pos]);
//            }
//        }
//        recurse(str,pos+1, result);
//    }
//Backtrack approach - 784. Letter Case Permutation
//    static void recurse(char[] str, int pos, List<String> result) {
//        //If we have reached a leaf in the recursion tree, save the result.
//        if (pos == str.length) {
//            result.add(new String(str));
//            return;
//        }
//
//        //If char is not a letter, no processing required.
//        if (Character.isLetter(str[pos])) {
//            //If uppercase char, we make it lower case, and recurse.
//            if (Character.isUpperCase(str[pos])) {
//                str[pos] = Character.toLowerCase(str[pos]);
//
//                //Start a new branch in the recursion tree, exploring options that are possible only if we had changed the case.
//                recurse(str, pos + 1, result);
//
//                //Backtracking. We undo the change so that we can start a new branch in the recursion tree.
//                str[pos] = Character.toUpperCase(str[pos]);
//            }
//            //If lowercase, then we make it upper case, and recurse.
//            else {
//                str[pos] = Character.toUpperCase(str[pos]);
//                recurse(str, pos + 1, result);
//                //Backtracking as explained above.
//                str[pos] = Character.toLowerCase(str[pos]);
//            }
//        }
//        //This branch explores options that are possible only if the previously performed change (if any) hadn't happened.
//        recurse(str, pos + 1,  result);
//    }
//
//    static List<String> letterCasePermutation(String S) {
//        List<String> result = new ArrayList<>();
//        recurse(S.toCharArray(), 0, result);
//        return result;
//    }

    //322. Coin Change, https://leetcode.com/problems/coin-change/description/

    private static int coinChange(int[] coins, int amount) {
        int max = amount + 1;       // sentinel (infinity)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);       // initialize as "infinity"
        dp[0] = 0;                  // base case

        for (int coin : coins) {
            // for each coin
            System.out.println("coin: " + coin + " | amount: "+ amount);
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                System.out.println(Arrays.toString(dp));
            }
            System.out.println('\n');
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
