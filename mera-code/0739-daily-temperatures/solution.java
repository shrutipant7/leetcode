public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        res[len - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(len - 1);

        for (int i = len - 2; i >= 0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
