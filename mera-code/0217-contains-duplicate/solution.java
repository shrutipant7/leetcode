class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numap = new HashSet<>();
        for(int num : nums) {
            if(!numap.add(num)){
                return true;
            }
        }
            return false;
    }
}
