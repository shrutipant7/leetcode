class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        int st = 0, len1 = s1.length(), len2 = s2.length(), matchedChar = 0;
        if (len1 > len2)
            return false;

        for (char c : s1.toCharArray()) {
            s1Cnt[c - 'a']++;
        }
        for (int i = 0; i < len1; i++) {
            s2Cnt[s2.charAt(i) - 'a']++;
        }
        matchedChar = countMatchingChar(s1Cnt, s2Cnt);
        if (matchedChar == 26)
            return true;

        for (int end = len1; end < len2; end++) {
            char chEnd = s2.charAt(end), chSt = s2.charAt(st);
            if (s1Cnt[chEnd - 'a'] == s2Cnt[chEnd - 'a'])
                matchedChar--;
            s2Cnt[chEnd - 'a']++;
            if (s1Cnt[chEnd - 'a'] == s2Cnt[chEnd - 'a'])
                matchedChar++;

            if (s1Cnt[chSt - 'a'] == s2Cnt[chSt - 'a'])
                matchedChar--;
            s2Cnt[chSt - 'a']--;
            if (s1Cnt[chSt - 'a'] == s2Cnt[chSt - 'a'])
                matchedChar++;

            if (matchedChar == 26)
                return true;
            st++;
        }
        return false;
    }

    public int countMatchingChar(int[] s1Cnt, int[] s2Cnt) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Cnt[i] == s2Cnt[i])
                ans++;
        }
        return ans;
    }
}
