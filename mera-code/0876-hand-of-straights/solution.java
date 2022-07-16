class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len%groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        while(!map.isEmpty()) {
            int first = map.firstKey();
            for(int i=first; i<first+groupSize; i++) {
                if(!nextKeyExist(i, map)) return false;
            }
        }
        return true;
    }
    
    public boolean nextKeyExist(int key, TreeMap<Integer, Integer> map) {
        if(map.get(key) == null) return false;
        else if(map.get(key) == 1) map.remove(key);
        else map.put(key, map.get(key)-1);
        return true;
    }
}
