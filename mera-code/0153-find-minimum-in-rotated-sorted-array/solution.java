class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE; 
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] < min) {
                min = nums[mid];
            } 
            if(nums[low] < nums[mid]){ //left array is sorted 
                min = Math.min(nums[low], min);
                low = mid + 1;
            }
            else { //right array is sorted
                min = Math.min(nums[high], min);
                high = mid -1;
            }
        }
        return min;
    }
}
