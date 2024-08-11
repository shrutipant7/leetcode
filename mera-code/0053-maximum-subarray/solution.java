class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum=0;
        for (int i:nums) {
            curSum+=i;
            if (curSum > maxSum) maxSum = curSum;
            if (curSum <= 0) curSum = 0;;
        }
        return maxSum;
    }
}
