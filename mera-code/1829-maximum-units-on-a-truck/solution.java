class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        for (int[] box : boxTypes) {
            int take = 0;
            if (truckSize <= 0)
                break;
            take = Math.min(box[0], truckSize);
            ans += take * box[1];
            truckSize = truckSize - box[0];
        }
        return ans;
    }
}
