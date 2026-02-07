class Solution {
    public int totalFruit(int[] fruits) {
        int end = 0, st = 0, len = fruits.length, maxVal = 0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        while (end < len) {
            fruitMap.put(fruits[end], fruitMap.getOrDefault(fruits[end], 0) + 1);
            while (fruitMap.size() > 2) {
                if (fruitMap.get(fruits[st]) == 1)
                    fruitMap.remove(fruits[st]);
                else
                    fruitMap.put(fruits[st], fruitMap.get(fruits[st]) - 1);
                st++;
            }

            maxVal = Math.max(maxVal, end - st + 1);
            end++;
        }
        return maxVal;
    }
}
