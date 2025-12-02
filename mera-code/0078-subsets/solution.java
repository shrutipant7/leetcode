class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recFun(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    public void recFun(int ind, List<Integer> temp, int[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        recFun(ind+1, temp, nums, ans);
        temp.remove(temp.size()-1);
        recFun(ind+1, temp, nums, ans);
    }
}
