class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = ((n & (1 << i)) >> i);
        }
        for (int i = 0; i < 32; i++) {
            int j = 31 - i;
            if (bits[j] == 1)
                ans += (1 << i);
        }
        return ans;
    }
}
