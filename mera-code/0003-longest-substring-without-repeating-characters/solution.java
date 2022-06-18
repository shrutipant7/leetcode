class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int endIndex = 0; endIndex < s.length(); endIndex++) {
            char endCh = s.charAt(endIndex);
            if(map.containsKey(endCh)) {
                startIndex = Math.max(map.get(endCh)+1, startIndex);
            }
            map.put(endCh, endIndex);
            res = Math.max(res, endIndex-startIndex+1);
        }
        return res;
    }
}
