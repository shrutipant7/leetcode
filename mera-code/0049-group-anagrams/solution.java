class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            List<String> mappedStr = new ArrayList<>();
            if (map.containsKey(tempStr)) {
                mappedStr = map.get(tempStr);
            }
            mappedStr.add(str);
            map.put(tempStr, mappedStr);
        }

        for (List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}
