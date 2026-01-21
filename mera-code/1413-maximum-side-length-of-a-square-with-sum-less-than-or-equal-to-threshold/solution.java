class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int ans = -1;
        int m = mat.length, n = mat[0].length;
        int[][] prefMat = new int[m][n];
        generatePrefMat(prefMat, mat);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lim = Math.min(m - i, n - j);
                int low = ans + 1, high = lim - 1;
                while (low <= high) {
                    int k = (low + high) >> 1;
                    int top = i == 0 ? 0 : prefMat[i - 1][j + k];
                    int left = j == 0 ? 0 : prefMat[i + k][j - 1];
                    int diag = (i == 0 || j == 0) ? 0 : prefMat[i - 1][j - 1];
                    int sqSum = prefMat[i + k][j + k] - top - left + diag;
                    if (sqSum > threshold)
                        high = k - 1;
                    else
                        low = k + 1;
                }
                ans = Math.max(ans, high);
            }
        }
        return ans + 1;
    }

    public void generatePrefMat(int[][] prefMat, int[][] mat) {
        int m = prefMat.length, n = prefMat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i == 0 ? 0 : prefMat[i - 1][j];
                int left = j == 0 ? 0 : prefMat[i][j - 1];
                int diag = (i == 0 || j == 0) ? 0 : prefMat[i - 1][j - 1];
                prefMat[i][j] = top + left - diag + mat[i][j];
            }
        }
    }
}
