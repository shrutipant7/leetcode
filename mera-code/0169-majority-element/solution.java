class Solution {
    public int majorityElement(int[] nums) {
        int majorityCount = (nums.length)/2;
        int candidate = nums[0];
        int vote = 1;
        for (int i:nums) {
            if(candidate!=i) {
                vote--;
            } else {
                vote++;
            }
            if(vote == 0) {
                candidate = i;
                vote++;
            }
        }
        // The element left in the end may or may not have majority. So check it.
        // This extra code beats 75% but is not required as per question
        int candCount = 0;
        for (int i:nums) {
            if(i==candidate) {
                candCount++;
            }
        }
        if (candCount > majorityCount) {
            return candidate;
        }
        //No element has clear majority
        else return -1;
    }
}
