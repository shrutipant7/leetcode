class Solution {
    public int trap(int[] height) {
        int count = 0;                 
        int len = height.length;
        int[] rightMax = new int[len];
        int[] leftMax = new int[len];
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        leftMax[0] = height[0];                
        // [0,1,1,2,2,2,2,3,3,3,3,3]
        rightMax[rightMax.length-1] = height[len-1]; 
        // [3,3,3,3,3,3,3,3,2,2,2,1]
        for(int i=1; i<height.length-1; i++) {
            leftMax[i]  = height[i] > leftMax[i-1] ? height[i] : leftMax[i-1];
        }
        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = height[i] > rightMax[i+1] ? height[i] : rightMax[i+1];
        }
        for(int i=0; i<height.length-1; i++) {
            int waterHeight =  Math.min(leftMax[i], rightMax[i]) - height[i];
            if(waterHeight > 0) {
                count+=waterHeight;
            }
        }  
        return count;
    }
}
