class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        String newStr = s.toLowerCase();
        while (i < j) {
            char chLeft = newStr.charAt(i);
            if (!alphaNum(chLeft)) {
                i++;
                continue;
            }
            char chRight = newStr.charAt(j);
            if (!alphaNum(chRight)) {
                j--;
                continue;
            }
            if (chLeft != chRight) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
