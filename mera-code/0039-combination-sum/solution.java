class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recFun(0, new ArrayList<>(), candidates, ans, target);
        return ans;
    }

    public void recFun(int ind, List<Integer> temp, int[] candidates, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || ind == candidates.length)
            return;
        temp.add(candidates[ind]);
        recFun(ind, temp, candidates, ans, target - candidates[ind]);
        temp.remove(temp.size() - 1);
        recFun(ind + 1, temp, candidates, ans, target);
    }
}
