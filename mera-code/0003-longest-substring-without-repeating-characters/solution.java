class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char chEnd = s.charAt(end);
            while (set.contains(chEnd)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(chEnd);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
