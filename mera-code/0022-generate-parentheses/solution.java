class Solution {
    public List<String> generateParenthesis(int n) {
    // your code goes here
    List<String> res = new ArrayList<>();
    recFunc(res, "(", 1, 0, n);
    return res;
  }

  public void recFunc(List<String> res, String str, int open, int close, int n) {
    if (open > n || close > open) return;
    if (open == close && open == n) {
      res.add(str);
      return;
    }
    recFunc(res, str + "(", open + 1, close, n);
    recFunc(res, str + ")", open, close + 1, n);
  }
}
