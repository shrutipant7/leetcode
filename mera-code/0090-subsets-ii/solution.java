class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), 0, nums);
        // for(List<Integer> entry : res) finalResult.add(entry);
        return res;
    }
    
    static void backtrack(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(res, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }
    }
}
