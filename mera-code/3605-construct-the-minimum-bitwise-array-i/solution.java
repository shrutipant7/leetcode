class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size(), i = 0;
        int[] ans = new int[len];
        for (int x : nums) {
            if (x == 2) {
                ans[i++] = -1;
                continue;
            }
            for (int j = 0; j < 32; j++) {
                if ((x & (1 << j)) == 0) {
                    int mask = 1 << (j - 1);
                    int k = x ^ mask;
                    ans[i++] = k;
                    break;
                }
            }
        }
        return ans;
    }
}
