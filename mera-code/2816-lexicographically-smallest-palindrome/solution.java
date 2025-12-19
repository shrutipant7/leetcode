class Solution {
    public String makeSmallestPalindrome(String s) {
        int len = s.length();
        int l=0, r=len-1;
        char[] arr = s.toCharArray();
        while ( l<r) {
            char lCh = arr[l];
            char rCh = arr[r];
            if (lCh < rCh) arr[r] = arr[l];
            else if (lCh > rCh) arr[l] = arr[r];
            l++;
            r--;
        }
        return new String(arr);
    }
}
