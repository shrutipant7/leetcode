class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        boolean[] taken = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<>(), taken);
        return new ArrayList<>(res);
    }
    
    static void backtrack(Set<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] taken){
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(taken[i]) continue;
            taken[i] = true;
            temp.add(nums[i]);
            backtrack(res, nums, temp, taken);
            temp.remove(temp.size()-1);
            taken[i] = false;
        }
    }
}
