class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ch = new char[26];
            for(char c : str.toCharArray()) {
                ch[c - 'a']++;
            }
            String chStr = String.valueOf(ch);
            if(map.containsKey(chStr)) map.get(chStr).add(str);
            else map.put(chStr, new ArrayList<>(Arrays.asList(str)));
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
