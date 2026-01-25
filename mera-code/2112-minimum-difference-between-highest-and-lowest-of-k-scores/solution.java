class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int st = 0, diff = (int) 1e5 + 1;
        for (int end = k - 1; end < nums.length; end++) {
            diff = Math.min(diff, nums[end] - nums[st]);
            st++;
        }
        return diff;
    }
}
