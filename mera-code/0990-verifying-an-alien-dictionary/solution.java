class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);
        for (int i = 0; i < words.length - 1; i++) {
            String prev = words[i];
            String nxt = words[i + 1];
            if (!verifyOrder(map, prev, nxt))
                return false;
        }
        return true;

    }

    private boolean verifyOrder(Map<Character, Integer> map, String prev, String next) {
        int l1 = prev.length(), l2 = next.length();
        int len = Math.min(l1, l2);
        int i=0;
        while (i < len) {
            if (map.get(prev.charAt(i)) < map.get(next.charAt(i)))
                return true;
            if (map.get(prev.charAt(i)) > map.get(next.charAt(i)))
                return false;
            i++;
        }
        return l1 <= l2;
    }
}
