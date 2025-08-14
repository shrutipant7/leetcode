class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1;
        int i=0, len = num.length();
        while (i <= len-3) {
            char ch = num.charAt(i);
            if (ch == num.charAt(i+1) && ch == num.charAt(i+2)) {
                ans = Math.max(ans, ch-'0');
                i+=3;
                continue;
            }
            i++;
        }
    if (ans != -1) return ""+ans+ans+ans;
    return "";
    }
}
