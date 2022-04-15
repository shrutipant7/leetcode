class Solution {
    public boolean isAnagram(String s, String t) {
        int[] list = new int[26];        
        for(int i=0; i< s.length(); i++) {
            list[s.charAt(i) - 'a'] = list[s.charAt(i) - 'a']+1;
        }
        for(int i=0; i< t.length(); i++) {
            list[t.charAt(i) - 'a'] = list[t.charAt(i) - 'a']-1;
        }
        for(int i=0; i< list.length; i++) {
        System.out.print(list[i]);
            if(list[i] != 0) return false;
        }
        return true;
    }
}
