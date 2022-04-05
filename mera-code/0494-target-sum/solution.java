class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int arr_sum = 0;
        int arr_diff = target;
        
        for(int x: nums){
            arr_sum += x;
        }
        
         if(((arr_sum - target) % 2 == 1) || (target > arr_sum) || (target < -arr_sum)){
            return 0;
         }
        
        int s1 = (arr_diff + arr_sum)/2;
        return countSubsetSum(nums, s1);
        
    }
    
    public int countSubsetSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        
	    // for(int i=0; i<n+1; i++){
	    //     for(int j=0; j<sum+1; j++){
	    //         if(i==0){
	    //             dp[i][j] = 0;
	    //         }
	    //         if(j==0){
	    //             dp[i][j] = 1;
	    //         }
	    //     }
	    // }
        
        for(int i=1; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
            
        }
        return dp[n][sum];
    }
}
