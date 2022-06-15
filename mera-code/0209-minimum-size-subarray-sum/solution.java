class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;
        for(int endIndex = 0; endIndex < nums.length; endIndex++) {
            curSum+= nums[endIndex];
            while(curSum >= target) {
                minLength = Math.min(minLength, endIndex - startIndex + 1);
                curSum-= nums[startIndex];
                startIndex++;
            }
        }
        return  minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
