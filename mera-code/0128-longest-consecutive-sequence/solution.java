class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int maxLen = 1;
        for(int n : nums) {
            set.add(n);
        }
        for(int n : nums) {
            if(!set.contains(n-1)) {
                int m = n+1;
                while(set.contains(m)) {
                    m++;
                    maxLen = Math.max(maxLen, m-n);
                }
            }
        }
        return maxLen;
    }
}
