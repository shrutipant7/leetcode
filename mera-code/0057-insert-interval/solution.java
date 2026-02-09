class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };

        List<int[]> temp = new ArrayList<>();
        for (int[] it : intervals) {
            if (newInterval == null || newInterval[0] > it[1]) {
                temp.add(it);
            } else if (newInterval[1] < it[0]) {
                temp.add(newInterval);
                temp.add(it);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], it[0]);
                newInterval[1] = Math.max(newInterval[1], it[1]);
            }
        }
        if (newInterval != null) temp.add(newInterval);

        int[][] ans = new int[temp.size()][2];
        int k = 0;
        while (k < temp.size()) {
            ans[k] = new int[] { temp.get(k)[0], temp.get(k)[1] };
            k++;
        }
        return ans;
    }
}
