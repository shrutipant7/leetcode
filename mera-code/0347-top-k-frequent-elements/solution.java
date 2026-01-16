class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length, j = 0;
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= len; i++)
            bucket.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        int ls = len;
        while (j < k && ls >= 0) {
            if (bucket.get(ls).size() > 0) {
                for (int it : bucket.get(ls)) {
                    res[j++] = it;
                }
            }
            ls--;
        }
        return res;
    }
}
