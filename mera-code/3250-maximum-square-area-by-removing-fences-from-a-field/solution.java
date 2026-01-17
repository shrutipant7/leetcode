class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = (int) 1e9 + 7;
        if (m == n)
            return ((m - 1) * (m - 1)) % MOD;

        int maxArea = -1;
        List<Integer> vList = new ArrayList<>();
        vList.add(1);
        for (int i : vFences)
            vList.add(i);
        vList.add(n);
        Collections.sort(vList);

        Set<Integer> hSet = new HashSet<>();
        hSet.add(m - 1);
        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                hSet.add(Math.abs(hFences[i] - hFences[j]));
            }
            hSet.add(Math.abs(hFences[i] - 1));
            hSet.add(Math.abs(hFences[i] - m));
        }

        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                int dist = vList.get(j) - vList.get(i);
                if (hSet.contains(dist))
                    maxArea = Math.max(maxArea, dist);
            }
        }
        if (maxArea == -1)
            return -1;
        return (int) ((1L * maxArea * maxArea) % MOD);

    }
}
