class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<String>();
        int limit = 1<<k;
        for(int i=0; i<=s.length()-k && limit > 0; i++) {
            String subStr = s.substring(i, i+k);
            if(!set.contains(subStr)) {
                set.add(subStr);
                limit--;
            }
        }
        return limit > 0 ? false : true;
    }
}
