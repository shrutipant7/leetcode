class Solution {
    public int removeDuplicates(int[] nums) {
        int lastInsertIndex = 0;
        if(nums.length == 1) return 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[lastInsertIndex]) {
                lastInsertIndex++;
                nums[lastInsertIndex] = nums[i];
            }
        }
        return lastInsertIndex+1;
    }
}
