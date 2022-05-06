class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(k == 1) return matrix[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for(int m=0; m<n; m++){
            for(int i : matrix[m]) {
                if(pq.size() < k) pq.add(i);
                else if(pq.peek() >= i) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        return pq.poll();
    }
}
