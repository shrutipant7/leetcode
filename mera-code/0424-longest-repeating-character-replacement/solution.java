class Solution {
    public int characterReplacement(String s, int k) {
        int startIndex = 0;
        int res = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int endIndex = 0; endIndex < s.length(); endIndex++) {
            char endChar = s.charAt(endIndex);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(endChar));
            if(endIndex - startIndex + 1 - maxRepeatLetterCount > k) {     
                char startChar = s.charAt(startIndex);
                map.put(startChar, map.get(startChar)-1);
                startIndex++;
            }
            res = Math.max(res, endIndex - startIndex + 1);
        }
        return res;
    }
}
