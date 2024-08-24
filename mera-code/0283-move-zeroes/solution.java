class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i=0, j=1;
        while (j <= n-1) {
            //When both i and j point to 0, find the next non-zero value of j to be swapped
            if (nums[i]==0 && nums[j]==0) {
                j++;
                continue;
            }
            else if (nums[i]==0) {
                //Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                //Increment count of pointers
                i++;
                j++;
                continue;
            } 
            //If i and j both have non-zero value, just increment the pointers
                i++;
                j++;
            
        }
    }
}
