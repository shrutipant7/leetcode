class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i < s.length(); i++) {
            if(!stack.isEmpty() && isMatching(stack.peek(), s.charAt(i))) stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
    static boolean isMatching(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') return true;
        else if (ch1 == '[' && ch2 == ']') return true;
        else if (ch1 == '{' && ch2 == '}') return true;
        else return false;
    }
}
