class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col ==1) return target == matrix[0][0];
        for(int i=0; i<row; i++) {
            if (target == matrix[i][col-1]) return true;
            else if(target < matrix[i][col-1]) return binarySearch(target, matrix[i], 0, col-1);
            else continue;
        }
        return false;
    }
    
    static boolean binarySearch(int key, int[] a, int low, int high) {
        if(low > high) {
            return false;
        }
        int mid = (low+high)/2;
        if (key == a[mid]) return true;
        else if( key < a[mid]) return binarySearch(key, a, low, mid-1);
        return binarySearch(key, a, mid+1, high);
    }
}
