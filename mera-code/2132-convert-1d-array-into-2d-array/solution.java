class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        if(m*n != original.length)
            return new int[0][0];
        for(int i = 0; i<=m-1; i++) {
            result[i] = constructRow(i*n, (i+1)*(n)-1, original);
        }
        return result;
    }
    
    static int[] constructRow(int start, int end, int[] original) {
        return Arrays.copyOfRange(original, start, end + 1);
    }
}
