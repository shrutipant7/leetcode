class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int copy = x;
        int y = 0;
        while(copy>0) {
            y = (y*10)+(copy%10);
            copy=copy/10;
        }
        if(x == y) return true;
            else return false;
    }
}
