class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> ans = new ArrayList<>();
        TreeMap<Long, Long> map = new TreeMap<>();
        for (int[] it : segments) {
            long l = it[0], r = it[1], c = it[2];
            map.put(l, map.getOrDefault(l, 0L) + c);
            map.put(r, map.getOrDefault(r, 0L) - c);
        }

        long sum = 0, start = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (start == 0) {
                start = entry.getKey();
                sum = entry.getValue();
                continue;
            }
            List<Long> temp = new ArrayList<>();
            temp.add(start);
            temp.add(entry.getKey());
            temp.add(sum);
            if (sum > 0) {
                ans.add(temp);
            }
            sum += entry.getValue();
            start = entry.getKey();
        }
        return ans;
    }
}
