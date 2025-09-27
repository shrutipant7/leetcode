class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        long left = 2, right = x / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid == x / mid)
                return (int) mid;
            if (mid < x / mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (int) right;
    }
}
