class Solution {
    public int[] plusOne(int[] digits) {
        int carryDigit = 1;
        int[] result = new int[digits.length+1];
        for(int i=digits.length-1; i>=0; i--) {
            int sum = digits[i] + carryDigit;
            carryDigit = sum/10;
            digits[i] = sum%10;
        }
        if(carryDigit != 0) {
            result[0] = 1;
            return result;
        }
        // Collections.reverse(interRes);
        // for(int i=0; i<interRes.size(); i++) {
        //     result[i] = interRes.get(i);
        // }
        return digits;
    }
}
