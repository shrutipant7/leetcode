class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tempInterval = new int[intervals.length+1][2];
        for(int i=0; i<intervals.length; i++) {
            tempInterval[i] = intervals[i];
        }
        tempInterval[tempInterval.length-1] = newInterval;
        return merge(tempInterval);
    }
    static int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        LinkedList<int[]> res= new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int[] compareInterval = intervals[0];
        for(int i=0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(compareInterval[1] < interval[0]) {
                res.add(compareInterval);
                compareInterval = interval;
            }
            else {
                compareInterval = new int[]{compareInterval[0], Math.max(interval[1], compareInterval[1])};
            }
        }
        res.add(compareInterval);
        return res.toArray(new int[res.size()][]);
    }
}
