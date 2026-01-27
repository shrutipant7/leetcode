class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length(), hLen = haystack.length();
        if (nLen > hLen)
            return -1;

        char firstChar = needle.charAt(0);
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.charAt(i) == firstChar) {
                if (haystack.substring(i, i + nLen).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
