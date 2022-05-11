class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for(int i=1; i<5; i++){
            dp[i]+= dp[i-1];
        }
        if(n > 1){
            while(n > 1) {
                for(int i=1; i<5; i++){
                    dp[i]+= dp[i-1];
                } 
                n--;
            }
        }
        return dp[4];
    }
}
