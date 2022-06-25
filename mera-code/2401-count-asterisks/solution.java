class Solution {
    public int countAsterisks(String s) {
        boolean countOn = true;
        int starCount = 0;
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '|') countOn = !countOn;
            if(countOn && s.charAt(i) == '*') starCount+=1;
        }
        return starCount;
    }
}
