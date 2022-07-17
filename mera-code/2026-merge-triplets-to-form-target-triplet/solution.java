class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];
        for(int[] i : triplets) {
            if(i[0] <= target[0] && i[1] <= target[1] && i[2] <= target[2])
                res = new int[]{Math.max(res[0], i[0]), Math.max(res[1], i[1]), Math.max(res[2], i[2])};
        }
        return Arrays.equals(res, target);
    }
}
