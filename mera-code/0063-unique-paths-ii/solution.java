class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        boolean obstacleInFirstPath = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                obstacleInFirstPath = true;
            dp[i][0] = obstacleInFirstPath ? 0 : 1;
        }
        obstacleInFirstPath = false;

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                obstacleInFirstPath = true;
            dp[0][i] = obstacleInFirstPath ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }
}
