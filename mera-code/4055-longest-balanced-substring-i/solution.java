class Solution {
    public int longestBalanced(String s) {
        int maxLen = 0, len = s.length();
        if (len == 1)
            return len;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (allBalanced(map))
                    maxLen = Math.max(maxLen, j - i + 1);
            }
            map.clear();
        }
        return maxLen;
    }

    public boolean allBalanced(Map<Character, Integer> map) {
        int bal = 0;
        for (int freq : map.values()) {
            if (bal == 0)
                bal = freq;
            if (bal != freq)
                return false;
        }
        return true;
    }
}
