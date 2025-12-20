class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10)
            return ans;

        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int code = 0;
        for (int i = 0; i < 10; i++) {
            char ch = s.charAt(i);
            code <<= 2;
            code |= map.get(ch);
        }
        seen.add(code);

        int mask = (1 << 20) - 1;
        for (int i = 10; i < s.length(); i++) {
            char ch = s.charAt(i);
            code <<= 2;
            code |= map.get(ch);
            code &= mask;
            if (seen.contains(code) && !added.contains(code)) {
                ans.add(s.substring(i - 9, i + 1));
                added.add(code);
            } else {
                seen.add(code);
            }
        }
        return ans;
    }
}
