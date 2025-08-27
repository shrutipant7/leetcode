class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
      int[][][] dp = new int[n][2][3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    return recFun(prices, n, 0, 0, 2, dp);
  }

  private int recFun(int[] prices, int n, int idx, int alreadyBought, int count, int[][][] dp) {
    if (idx >= n || count == 0) return 0;
    if (dp[idx][alreadyBought][count] != -1) return dp[idx][alreadyBought][count];
    if (alreadyBought == 1) {
      return dp[idx][alreadyBought][count] =
          Math.max(
              prices[idx] + recFun(prices, n, idx + 1, 0, count - 1, dp),
              recFun(prices, n, idx + 1, alreadyBought, count, dp));
    }
    return dp[idx][alreadyBought][count] =
        Math.max(
            -prices[idx] + recFun(prices, n, idx + 1, 1, count, dp),
            recFun(prices, n, idx + 1, alreadyBought, count, dp));
  }
}
