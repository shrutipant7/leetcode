class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isMatching(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    boolean isMatching(char c1, char c2) {
        if((c1 == '(' && c2 == ')') ||
        (c1 == '{' && c2 == '}') ||
        (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}
