class Pair {
    int num;
    int min;

    public Pair(int n, int m) {
        this.num = n;
        this.min = m;
    }
}

class MinStack {
    Stack<Pair> stack = new Stack<Pair>();
    public MinStack() {
    }
    
    public void push(int val) {
        int minVal = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new Pair(val, minVal));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().num;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
