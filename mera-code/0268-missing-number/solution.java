class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sumFound = IntStream.of(nums).reduce(0, Integer::sum);
        int sumExpected = (len)*(len+1)/2;
        return sumExpected-sumFound ;
    }
}
