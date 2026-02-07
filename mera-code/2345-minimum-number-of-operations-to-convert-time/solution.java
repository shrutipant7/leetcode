class Solution {
    public int convertTime(String current, String correct) {
        int target = calcMinutes(current, correct);
        //     int[] minutes = new int[] { 1, 5, 15, 60 };
        //     int[][] dp = new int[5][target + 1];
        //     for (int[] it : dp)
        //         Arrays.fill(it, Integer.MAX_VALUE - 1);
        //     for (int i = 0; i <= 4; i++)
        //         dp[i][0] = 0;
        //     for (int i = 1; i <= 4; i++) {
        //         for (int j = 1; j <= target; j++) {
        //             if (minutes[i - 1] > j)
        //                 dp[i][j] = dp[i - 1][j];
        //             else
        //                 dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - minutes[i - 1]]);
        //         }
        //     }
        //     return dp[4][target];

        int ans = 0;
        if (target >= 60) {
            ans += target / 60;
            target = target % 60;
        }
        if (target >= 15) {
            ans += target / 15;
            target = target % 15;
        }
        if (target >= 5) {
            ans += target / 5;
            target = target % 5;
        }
        if (target >= 1) {
            ans += target / 1;
            target = target % 1;
        }
        return ans;
    }

    public int calcMinutes(String current, String correct) {
        String[] curArr = current.split(":");
        String[] corArr = correct.split(":");
        int curMin = (Integer.parseInt(curArr[0]) * 60) + Integer.parseInt(curArr[1]);
        int corMin = (Integer.parseInt(corArr[0]) * 60) + Integer.parseInt(corArr[1]);
        return corMin - curMin;
    }

}
