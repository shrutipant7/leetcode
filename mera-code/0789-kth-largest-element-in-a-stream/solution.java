class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        if(nums.length > 0) {
            for(int i=0; i < k && i < nums.length; i++) {
                pq.add(nums[i]);
            } 
        }
        for(int i=k; i < nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        } 
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
            return pq.peek();
        }
        if(pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
