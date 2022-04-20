class Solution {
    public String frequencySort(String s) {
        if(s.length() == 1) return s;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        while(!pq.isEmpty()) {
            for(int i=0; i < map.get(pq.peek()); i++) {
               res.append(pq.peek());
            }
            pq.poll();
        }
        return res.toString();
    }
}
