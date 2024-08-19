class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, curCount = 0;
        for (int i : nums) {
            if (i == 1) {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            }
            else {
                curCount = 0;
            }
        }
        return maxCount;
    }
}
