class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        List<String> operators = new ArrayList<String>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        for(int i=0; i< tokens.length; i++){
            if(operators.contains(tokens[i])) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(compute(tokens[i], num1, num2)));
            }
            else stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());
    }
    static Integer compute(String operator, int num2, int num1) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return null;
        }
    }
}
