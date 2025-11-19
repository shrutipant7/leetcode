class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('5', "jkl");
        keypad.put('6', "mno");
        keypad.put('7', "pqrs");
        keypad.put('8', "tuv");
        keypad.put('9', "wxyz");
        recFun(digits, keypad, 0, new StringBuilder(), res);
        return res;
    }

    public void recFun(
            String digits, Map<Character, String> keypad, int ind, StringBuilder sb, List<String> res) {
        if (ind == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = keypad.get(digits.charAt(ind));
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            recFun(digits, keypad, ind + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
