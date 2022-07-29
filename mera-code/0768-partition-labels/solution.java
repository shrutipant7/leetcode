class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int maxWin = 0;
        int lastInd = 0;
        for(int i=0; i<s.length(); i++){
            int end = map.get(s.charAt(i));
            maxWin = Math.max(maxWin, end);
            if(maxWin == i) {
                res.add(maxWin-lastInd+1);
                lastInd = i+1;
                maxWin = 0;
            }
        } 
        return res;
    }
}
