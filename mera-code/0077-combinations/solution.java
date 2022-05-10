class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, n, k, new ArrayList<>(), 1);
        return res;
    }
    
    static void backtrack(List<List<Integer>> res, int n, int k, List<Integer> temp, int start){
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++) {
            temp.add(i);
            backtrack(res, n, k, temp, i+1);
            temp.remove(temp.size()-1);
        }                
    }
}
