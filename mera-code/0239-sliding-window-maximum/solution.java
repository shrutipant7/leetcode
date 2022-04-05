class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> queue = new ArrayDeque<>(); //Storing indices.
        for(int i=0; i<k; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
        
        for(int i=k; i<n; i++) {
            res[i-k] = nums[queue.peekFirst()];            
            while(!queue.isEmpty() && queue.peekFirst() <= i-k)
                queue.removeFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
            res[n-k] = nums[queue.peekFirst()];  
    return res;
    }
}
