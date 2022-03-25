class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length; //3
        int n = matrix[0].length; //3
        int minr = 0;
        int maxr = m-1; //2
        int minc = 0;
        int maxc = n-1; //2
        while(res.size() < m*n){
            for(int i=minc; i<=maxc && res.size() < m*n; i++ ) {
                res.add(matrix[minc][i]);
            }
            minr++;
            for(int i=minr; i<=maxr && res.size() < m*n; i++ ) {
                res.add(matrix[i][maxc]);
            }
            maxc--;
            for(int i=maxc; i>=minc && res.size() < m*n; i-- ) {
                res.add(matrix[maxr][i]);
            }
            maxr--;
            for(int i=maxr; i>=minr && res.size() < m*n; i-- ) {
                res.add(matrix[i][minc]);
            }
            minc++;
        }
        return res;
    }
}
