class Solution {
    public String removeKdigits(String nums, int k) {
    if (k == nums.length()) return new String("0");
    StringBuilder res = new StringBuilder();
    Stack<Character> st = new Stack<>();
    for (char ch : nums.toCharArray()) {
      while (!st.isEmpty() && st.peek() > ch && k > 0) {
        st.pop();
        k--;
      }
      st.push(ch);
    }
    while (!st.isEmpty()) {
        // When the number is like 1234567 so k digits are still not removed, remove last k
        while (k > 0) {
            st.pop();
            k--;
        }
      res.append(st.pop());
    }
    while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
      res.deleteCharAt(res.length() - 1);
    }
    return res.length() > 0 ? res.reverse().toString() : "0";
  }
}
