class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    public String buildString(String str) {
        Stack stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '#') {
                if(!stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        return String.valueOf(stack);
    }
}
