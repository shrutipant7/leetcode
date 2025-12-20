class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = (int) 1e9 + 7;
        int hLen = horizontalCuts.length, vLen = verticalCuts.length;
        int[] horCut = new int[hLen + 2], verCut = new int[vLen + 2];
        horCut[hLen + 1] = h;
        verCut[vLen + 1] = w;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < hLen; i++) {
            horCut[i + 1] = horizontalCuts[i];
        }
        for (int i = 0; i < vLen; i++) {
            verCut[i + 1] = verticalCuts[i];
        }

        long maxDifHor = 0, maxDifVer = 0;
        for (int i = 0; i < hLen + 1; i++) {
            maxDifHor = Math.max(maxDifHor, horCut[i + 1] - horCut[i]);
        }
        for (int i = 0; i < vLen + 1; i++) {
            maxDifVer = Math.max(maxDifVer, verCut[i + 1] - verCut[i]);
        }
        return (int) ((maxDifHor * maxDifVer) % MOD);
    }
}
