class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxRate = 0;
        for(int pile : piles) {
            maxRate = Math.max(maxRate, pile);
        }
        int low = 0;
        int high = maxRate-1;
        int lastMinRate = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(validateSpeed(piles, h, mid+1)){
                lastMinRate = mid+1;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }  
        return lastMinRate;
    }
    
    static boolean validateSpeed(int[] piles, int h, int bananasEaten) {
        int timeToEat = 0;
        for(int pile : piles) {
            timeToEat+= Math.ceil(Double.valueOf(pile)/bananasEaten);
            if (timeToEat > h) return false;
        }
        return true;
    }
}
