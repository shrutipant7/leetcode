class Solution {
    public int countBinarySubstrings(String s) {
        int[] grp = new int[s.length()];
        int j = 0;
        grp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                grp[++j] = 1;
            } else {
                grp[j]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= j; i++) {
            ans += Math.min(grp[i - 1], grp[i]);
        }
        return ans;
    }
}
