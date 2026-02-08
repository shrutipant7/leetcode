class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int minSum = Integer.MAX_VALUE, curSum = 0, st = 0, end = 0, total = 0;
        for (int it : cardPoints)
            total += it;
        if (len == k)
            return total;

        while (end < len) {
            curSum += cardPoints[end];
            if (end == len - k - 1)
                minSum = curSum;
            while (end - st + 1 > len - k) {
                curSum -= cardPoints[st];
                minSum = Math.min(minSum, curSum);
                st++;
            }
            end++;
        }
        return total - minSum;
    }
}
