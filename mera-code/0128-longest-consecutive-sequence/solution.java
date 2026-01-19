class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxAns = 1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int i = 1;
                while (set.contains(x + i)) {
                    i++;
                }
                maxAns = Math.max(maxAns, i);
            }
        }

        return maxAns;
    }
}
