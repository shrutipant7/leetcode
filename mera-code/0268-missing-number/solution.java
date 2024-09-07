class Solution {
    public int missingNumber(int[] nums) {
        int xorArr = 0, xorNum = 0;
        for(int i=0; i<nums.length; i++) {
            xorArr ^= nums[i];
            xorNum ^= i+1;
        }
        return xorArr^xorNum;
    }
}
