class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0, len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[len - i - 1]);
        }
        return maxSum;
    }
}
