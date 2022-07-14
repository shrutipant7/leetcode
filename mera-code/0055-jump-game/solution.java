class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length-1;
        int goal = nums.length-1;
        for(int i=len-1; i>=0; i--) {
            if(nums[i] >= goal-i){
                goal = i;
            }
        }
        return goal == 0 ? true : false;
    }
}
