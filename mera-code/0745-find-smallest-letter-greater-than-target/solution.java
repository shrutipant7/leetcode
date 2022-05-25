class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int lastGreater = 0;
        while(start <= end) {
            int mid =  (end+start)/2;
            if(letters[mid] <= target) start = mid+1;
            else {
                end = mid-1;  
                lastGreater = mid;
            }
        }
        return letters[lastGreater];
    }
}
