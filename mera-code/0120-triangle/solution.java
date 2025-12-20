class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int top = dp[i - 1][j];
                int left = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                dp[i][j] = Math.min(top, left) + triangle.get(i).get(j);
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        return minSum;
    }
}
