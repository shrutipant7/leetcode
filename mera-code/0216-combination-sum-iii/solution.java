class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] numArr = new int[9];
        for (int i = 0; i < 9; i++) {
            numArr[i] = i + 1;
        }
        recFun(res, new ArrayList<>(), numArr, k, n, 0);
        return res;
    }

    private void recFun(
            List<List<Integer>> res, List<Integer> temp, int[] numArr, int k, int n, int ind) {
        if (n == 0 && k == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (ind == numArr.length || n < 0 || k < temp.size())
            return;
        temp.add(numArr[ind]);
        recFun(res, temp, numArr, k, n - numArr[ind], ind + 1);
        temp.remove(temp.size() - 1);
        recFun(res, temp, numArr, k, n, ind + 1);
    }
}
