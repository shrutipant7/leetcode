class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n <= 2)
            return true;
        int lastBit = -1;
        while (n != 0) {
            int currBit = n & 1;
            if (lastBit != -1 && currBit != lastBit)
                return false;
            lastBit = currBit == 0 ? 1 : 0;
            n >>= 1;
        }
        return true;
    }
}
