class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        //For circular array, iterate the array twice.
        for (int i=(2*len)-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i%len]) {
                stack.pop();
            }
            //Only 2 possibilites from here: Either stack is empty after repeated popping or next greater element is found.
            if(stack.isEmpty()) {
                res[i%len] = -1;
            } else {
                res[i%len] = stack.peek();
            }
            stack.push(nums[i%len]);
        }
        return res;
    }
}
