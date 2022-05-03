class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        
        for(int i=0; i<=len; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<=amount; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int j=1; j<=amount; j++) {
            if(j%coins[0] == 0) dp[1][j] = j/coins[0];
            else dp[1][j] = Integer.MAX_VALUE-1;;
        }
        for(int i=2; i<=len; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
            }
        }
        return dp[len][amount] == Integer.MAX_VALUE-1 ? -1 : dp[len][amount];
    }
}
