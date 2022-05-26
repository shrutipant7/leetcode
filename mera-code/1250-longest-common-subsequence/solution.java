class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // int[][] dp = new int[m+1][n+1];
        // for(int[] k : dp) {
        //     Arrays.fill(k, -1);
        // }
        // recursiveDP(text1, text2, dp, m, n);
        return iterativeDP(text1, text2, m, n);
        // return dp[m][n];
    }
    
//     public int recursiveDP(String text1, String text2, int[][] dp, int m, int n) {
//         if(m == 0 || n == 0) return 0;
//         if(dp[m][n] != -1) return dp[m][n];
//         if(text1.charAt(m-1) == text2.charAt(n-1)) 
//             return dp[m][n] = 1+recursiveDP(text1, text2, dp, m-1, n-1);
//         else 
//             return dp[m][n] = Math.max(recursiveDP(text1, text2, dp, m-1, n), recursiveDP(text1, text2, dp, m, n-1));
        
//     }
    
     public int iterativeDP(String X,String Y,int m,int n) {
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
