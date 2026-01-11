class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean taken = false;
                boolean notTaken = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    taken = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = taken || notTaken;
            }
        }
        return dp[len][sum];
    }
}
