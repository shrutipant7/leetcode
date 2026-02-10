class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen = 0, len = nums.length;
        Set<Integer> odd = new HashSet<>();
        Set<Integer> even = new HashSet<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if (odd.size() > len / 2 || even.size() > len / 2)
                    break;
                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);
                if (odd.size() == even.size())
                    maxLen = Math.max(maxLen, j - i + 1);
            }
            odd.clear();
            even.clear();
        }
        return maxLen;
    }
}
