class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int minr = 0; //Initialize min row, max row, min column and max column
        int maxr = m-1;
        int minc = 0;
        int maxc = n-1;
        while(res.size() < m*n){ //Condition to know when to stop i.e., when all elements have been traversed.
            for(int i=minc; i<=maxc && res.size() < m*n; i++ ) {//res.size() < m*n prevent printing elements again when in innermost part of the matrix.
                res.add(matrix[minc][i]);
            }
            minr++; //Increment min row so that the corner element won't be included in next loop.
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
    // Credit: PepCoding youtube channel for detailed solution in Hindi. 
    // Video link: https://www.youtube.com/watch?v=SVFXEqn3Ceo
}
