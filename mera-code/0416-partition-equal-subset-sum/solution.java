class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int n : nums) {
            sum+=n;
        }
        if(sum%2!=0 ) {
            return false;
        }        
        return subsetSum(nums, sum/2, len);
    }
    
    static boolean subsetSum(int[] nums, int sum, int len) {
        boolean[][] t = new boolean[len+1][sum+1];
        for(int i=0; i<=len; i++) {
            for(int j=0; j<=sum; j++) {
                if(i == 0) t[i][j] = false;
                if(j == 0) t[i][j] = true;
            }
        }
                             
        for(int i=1; i<len+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(nums[i-1] <= j) {
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                } else  {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[len][sum];
    }
}
