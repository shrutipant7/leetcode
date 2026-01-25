class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length(), ansSt = 0, ansEnd = 0, curMatch = 0, minLen = Integer.MAX_VALUE;
        if (tLen == 0 || tLen > sLen)
            return "";

        Map<Character, Integer> tMap = new HashMap<>(), sMap = new HashMap<>();
        for (char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        int st = 0;
        for (int end = 0; end < sLen; end++) {
            char chEnd = s.charAt(end);

            sMap.put(chEnd, sMap.getOrDefault(chEnd, 0) + 1);
            if (tMap.containsKey(chEnd) && sMap.get(chEnd).equals(tMap.get(chEnd)))
                curMatch++;
            while (st < sLen && curMatch == tMap.size()) {
                if ((end + 1 - st) < minLen) {
                    minLen = end + 1 - st;
                    ansSt = st;
                    ansEnd = end;
                }

                char chSt = s.charAt(st);
                if (tMap.containsKey(chSt) && sMap.get(chSt).equals(tMap.get(chSt)))
                    curMatch--;
                sMap.put(chSt, sMap.get(chSt) - 1);
                st++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansSt, ansEnd + 1);
    }
}
