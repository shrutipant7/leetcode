public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int res = 0;
        while (l <= r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax <= rmax) {
                res += lmax - height[l];
                l++;
            } else {
                res += rmax - height[r];
                r--;
            }
        }
        return res;
    }
}
