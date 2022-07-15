class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        int left = 0;
        int right = 0;
        int jumpCount = 0;
        while(right < len-1) {
            int fathestJump = 0;
            for(int i=left; i<=right; i++) {
                fathestJump = Math.max(fathestJump, i+nums[i]);
            }            
            left = right+1;
            right = fathestJump; 
            jumpCount++;
        }
        return jumpCount;
    }
}
