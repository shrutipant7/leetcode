class Solution {
    public int missingNumber(int[] nums) {
        int found = 0, exp = 0;
        for (int i = 0; i < nums.length; i++) {
            exp ^= i + 1;
            found ^= nums[i];
        }
        return found ^ exp;
    }
}
