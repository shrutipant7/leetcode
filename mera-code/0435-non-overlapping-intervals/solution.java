class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int cnt = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start < prevEnd) {
                prevEnd = Math.min(prevEnd, end);
                cnt++;
            } else
                prevEnd = end;
        }
        return cnt;
    }
}
