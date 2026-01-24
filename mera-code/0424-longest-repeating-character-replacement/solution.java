class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public int characterReplacement(String s, int k) {
        int st = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char chEnd = s.charAt(end);
            map.put(chEnd, map.getOrDefault(chEnd, 0) + 1);
            while (st < s.length() && (end - st + 1) - map.get(findMajorityChar()) > k) {
                char chSt = s.charAt(st);
                map.put(chSt, map.get(chSt) - 1);
                if (map.get(chSt) <= 0)
                    map.remove(chSt);
                st++;
            }
            maxLen = Math.max(maxLen, end - st + 1);
        }
        return maxLen;
    }

    public char findMajorityChar() {
        int maxCnt = 0;
        char maxChar = 'A';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }
}
