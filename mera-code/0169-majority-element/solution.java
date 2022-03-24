class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == candidate){
                vote++;
            } else {
                vote--;
            }
            if(vote == 0){
                candidate = nums[i];
                vote = 1;
            }
        }
        return candidate;
    }
}
