class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--) {
                while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    map.put(nums2[i], -1);
                    stack.push(nums2[i]);
                }
                else {
                    map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }
        }
        
        for(int i=nums1.length-1; i>=0; i--) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
