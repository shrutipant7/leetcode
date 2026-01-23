class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (b[0] - a[0]));
        for (int n : arr) {
            int[] temp = new int[] { Math.abs(n - x), n };
            pq.add(temp);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}
