class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numap = new HashSet<>();
        for (int num : nums) {
            if (numap.contains(num)) {
                return true;
            }
            numap.add(num);
        }
        return false;
    }
}
