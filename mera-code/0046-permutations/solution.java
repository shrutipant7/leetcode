class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>());
        return res;
    }
    
    static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp){
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(res, nums, temp);
            temp.remove(temp.size()-1);
        }                
    }
}
