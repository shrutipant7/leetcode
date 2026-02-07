class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, maxLen = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        for (int it : dp)
            maxLen = Math.max(maxLen, it);
        return maxLen;
    }
}
