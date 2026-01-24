class Solution {
    public int longestOnes(int[] nums, int k) {
        int st = 0, maxCount = 0, zeroCnt = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k && st < nums.length) {
                if (nums[st] == 0)
                    zeroCnt--;
                st++;
            }
            maxCount = Math.max(maxCount, end - st + 1);
        }
        return maxCount;
    }
}
