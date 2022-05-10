class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, res, new ArrayList<>());
        return res;
    }
    
    static void helper(int k, int n, int index, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() > k) {
            return;
        }
        
        else if(temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
        }
        
        else {
            for(int i=index; i<=9; i++){
                temp.add(i);
                helper(k, n-i, i+1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
