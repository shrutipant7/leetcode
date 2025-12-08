class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (!isMatching(stack.pop(), c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    boolean isMatching(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') ||
                (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}
