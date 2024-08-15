class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length; //7
        int shiftIndex = k%len; //2
        reverse(nums, 0, len-1);
        //System.out.print(Arrays.toString(nums));
        reverse(nums, 0, shiftIndex-1);
        //System.out.print(Arrays.toString(nums));
        reverse(nums, shiftIndex, len-1);
    }

    public void reverse(int[] nums, int init, int fin) {
        int temp = 0;
        for (int i=init, j=fin; i<j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
