class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        String revStr = new StringBuilder(s).reverse().toString();
        return LCS(s, revStr, len, len);
    }
    
    public int LCS(String X, String Y,int m,int n) {
        int[][] dp = new int[m+1][n+1]; 
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            } 
        }
        return dp[m][n];
    }
}
