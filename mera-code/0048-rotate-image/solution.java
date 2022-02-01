class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
//transpose the matrix
        for(int i=0; i<=n-1; i++) {
            for(int j=i; j<=n-1; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
// reverse columns of matrix. run loop only upto (n/2)-1 i.e., half
// else replaced avlues will be replaced again hence remain unchanged.
        for(int i=0; i<=n-1; i++) {
            for(int j=0; j<=(n/2)-1; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[i][n-1-j];
                    matrix[i][n-1-j]=temp;
            }
        }
    }
}
