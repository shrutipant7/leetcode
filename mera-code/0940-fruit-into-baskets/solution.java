class Solution {
    public int totalFruit(int[] fruits) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        for(int endIndex = 0; endIndex < fruits.length; endIndex++) {
            map.put(fruits[endIndex], map.getOrDefault(fruits[endIndex], 0) + 1);
            while(map.size() > 2) {
                int startInt = fruits[startIndex];
                map.put(startInt, map.get(startInt) - 1);
                if(map.get(startInt) == 0) {
                    map.remove(startInt);
                }
                startIndex++;
            }
            result = Math.max(result, endIndex-startIndex+1);
        }
        return result;
    }
}
