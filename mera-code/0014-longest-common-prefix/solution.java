class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for(int i=0; i<strs[0].length(); i++) { 
            char tempStr = strs[0].charAt(i);
            for(String str : strs) {                                      
                if(str.length()-1 < i || str.charAt(i) != tempStr)  return res;
            }
            res+=tempStr;
        }
        return res;
    }
}
