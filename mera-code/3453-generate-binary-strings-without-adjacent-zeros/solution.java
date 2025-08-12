class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        recFun(ans, n, "");
        return ans;
    }

    private void recFun(List<String> ans, int n, String str) {
        if (str.length() == n) {
            ans.add(str);
            return;
        }
        if (str.length() == 0 || str.charAt(str.length() - 1) != '0') {
            recFun(ans, n, str + "0");
        }
        recFun(ans, n, str + "1");
    }
}
