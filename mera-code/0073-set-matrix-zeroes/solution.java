class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isFirstColZero = false;
        for(int i=0; i<row; i++){ //for each row [1,1,1]
            if(matrix[i][0] == 0) isFirstColZero = true; //Check for 1st col
            for(int j=1; j<col; j++){ //Checking 1st col for 0 already done.
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<row; i++){ //for each row [1,1,1]
            for(int j=1; j<col; j++){ //for each column 1
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
                for(int j=0; j<col; j++){
                    matrix[0][j] = 0;
                }
        }
        if(isFirstColZero) {
                for(int i=0; i<row; i++){
                    matrix[i][0] = 0;
                }
        }
    }
}
