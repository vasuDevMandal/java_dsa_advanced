package BackTracking;

import java.util.Arrays;

public class questions {
    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{1,2,5}, 6));
    }

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
