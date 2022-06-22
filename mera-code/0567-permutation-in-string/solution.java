class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int startIndex = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        int[] list1 = new int[26];
        int[] list2 = new int[26];
        
        //Initialise list1 and list2 to len1 or size of window
        for(int i=0; i < len1; i++) {
            list1[s1.charAt(i) - 'a']+=1;
            list2[s2.charAt(i) - 'a']+=1;
        }
        
        for(int endIndex = len1; endIndex < len2; endIndex++) {
            if(matchFunction(list1, list2)) return true;
            char newCh = s2.charAt(endIndex);
            char oldCh = s2.charAt(startIndex);
            list2[newCh - 'a']+=1;
            list2[oldCh - 'a']-=1;
            startIndex++;
        }
        return matchFunction(list1, list2);
    }
    
    //Check if list1 and list2 have same character frequency
    public boolean matchFunction(int[] list1, int[] list2) {
        for(int i=0; i<26; i++) {
            if(list1[i] != list2[i]) return false;
        }
        return true;
    }
}
