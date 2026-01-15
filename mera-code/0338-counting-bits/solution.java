class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == offset * 2) {
                offset = i;
                dp[i] = 1;
            } else
                dp[i] = dp[i - offset] + 1;
        }
        return dp;
    }
}
