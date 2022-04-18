class Solution {
    public void sortColors(int[] nums) {
        int lastRedIndex = 0;
        int firstBlueIndex = nums.length-1;
        int current = 0;
        while(current <= firstBlueIndex) {
            if(nums[current] == 0) {
                swap(nums, lastRedIndex, current);
                lastRedIndex++;
                current++;
                // Increment current. As only 0s and 1s are present between lastRedIndex and current.
            }
            else if(nums[current] == 2) {
                swap(nums, firstBlueIndex, current);
                firstBlueIndex--;
            }
            else {
                current++;
            }
        }
    }
    static void swap(int[] arr, int n1Index, int n2Index) {
        if(arr[n1Index] != arr[n2Index]) {
            int temp = arr[n2Index];
            arr[n2Index] = arr[n1Index];
            arr[n1Index] = temp;
        }
    }
}
