class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        if(len1 == 0 || len2 == 0) return new int[][]{};
        List<int[]> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<len1 && j<len2) {
            if((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) ||
               (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])){
                res.add(new int[]{Math.max(firstList[i][0], secondList[j][0]),
                                  Math.min(firstList[i][1], secondList[j][1])});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
