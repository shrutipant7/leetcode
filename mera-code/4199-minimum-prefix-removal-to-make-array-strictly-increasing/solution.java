class Solution {
    public int minimumPrefixLength(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1])
                return i;
        }
        return 0;
    }
}
