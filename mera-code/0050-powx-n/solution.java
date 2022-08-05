class Solution {
    public double myPow(double x, int n) {
        double res = helper(x, n);
        return n<0 ? 1/res : res;
    }
    
    public double helper(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        double resVal = helper(x*x, n/2);
        return n%2 == 0 ? resVal : resVal*x;
    }
}
