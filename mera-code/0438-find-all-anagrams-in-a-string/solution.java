class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        if(len1 < len2) return res;
        
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int startIndex = 0;
        
        for(int i=0; i < len2; i++) {
            map1[s.charAt(i) - 'a'] +=1;
            map2[p.charAt(i) - 'a'] +=1;
        }
        
        if(len1 == len2 && matchFunction(map1, map2)) {
            res.add(startIndex);
            return res;
        }
        
        for(int endIndex=len2; endIndex<len1; endIndex++) {
            if(endIndex == len2 && matchFunction(map1, map2)) res.add(startIndex);
            map1[s.charAt(endIndex) - 'a'] +=1;
            map1[s.charAt(startIndex) - 'a'] -=1;
            startIndex++;
            if(matchFunction(map1, map2)) res.add(startIndex);
        }
        return res;
    }
    
    public boolean matchFunction(int[] map1, int[] map2) {
        for(int i=0; i<26; i++) {
            if(map1[i] != map2[i]) return false;
        }
        return true;
    }
}
