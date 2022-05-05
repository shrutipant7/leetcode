class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        getTarget(nums,0,target,0);
        return ans;
    }
    
    void getTarget( int[] nums, int index , int target,int curSum) {
        if(index >= nums.length){
            if(target == curSum){
                 ans++;
            }
            return;
        }
        getTarget(nums,index+1,target,curSum + nums[index]);
        getTarget(nums,index+1,target,curSum - nums[index]);
    }
}
