class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1)
            return triangle.get(0).get(0);
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int lim = triangle.get(i).size();
            for (int j = lim - 1; j >= 0; j--) {
                int top = dp[j];
                int left = j == 0 ? Integer.MAX_VALUE : dp[j - 1];
                dp[j] = Math.min(top, left) + triangle.get(i).get(j);
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[j]);
        }
        return minSum;
    }
}
