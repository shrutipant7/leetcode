class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }
    
    static void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> temp, int start) {
        if(target < 0) return; 
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(res, candidates, target-candidates[i], temp, i);
                temp.remove(temp.size()-1);
        }
    }
}
