class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        if (target >= letters[letters.length - 1])
            return ans;

        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left];
    }
}
