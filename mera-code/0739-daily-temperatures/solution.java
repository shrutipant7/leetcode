class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // int len = temperatures.length;
        // if(len == 1) return new int[]{0};
        // int[] res = new int[len];
        // Stack<Integer> stack = new Stack<>();
        // for(int i = len-1; i>=0; i--) {
        //     while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        //         stack.pop();
        //     }
        //     res[i] = stack.isEmpty() ? 0 : stack.peek()-i;
        //     stack.push(i);
        // }
        // return res;
        
        int len = temperatures.length;
        if(len == 1) return new int[]{0};
        int[] res = new int[len];
        int hottestDay = 0;
        for(int i = len-1; i>=0; i--) {
            if(temperatures[i] >= hottestDay) {
                hottestDay=temperatures[i];
                continue;
            }
            int days = 1;
            while(temperatures[i+days] <= temperatures[i]) {
                days+= res[i+days];
            }
            res[i] = days;
        }
        return res;
    }
}
