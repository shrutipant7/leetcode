class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int lastIndex = nums.length-1;
        int left = 0; int right = nums.length-1;
        while(left<=right) {
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                arr[lastIndex] = nums[left]*nums[left];
                left++;
                lastIndex--;
            }
            else {
                arr[lastIndex] = nums[right]*nums[right];
                right--;
                lastIndex--;
            }
        }
        return arr;
    }
}
