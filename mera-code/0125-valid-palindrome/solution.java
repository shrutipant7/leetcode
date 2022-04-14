class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int end = s.length()-1;
        char startCh;
        char endCh;
        while(start <= end) {   
            startCh = s.charAt(start);
            endCh = s.charAt(end);
                if(!Character.isLetterOrDigit(startCh)) {
                    start++;
                }
                else if(!Character.isLetterOrDigit(endCh)) {
                    end--;
                }                
                else {
                    if(Character.toLowerCase(startCh) != Character.toLowerCase(endCh)) {
                     return false;
                    } 
                    start++;
                    end--;
                }
        }
        return true;
    }
}
