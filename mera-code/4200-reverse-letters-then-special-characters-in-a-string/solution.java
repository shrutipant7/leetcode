class Solution {
    public String reverseByType(String s) {
        List<Character> letter = new ArrayList<>();
        List<Character> sym = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                letter.add(ch);
            else
                sym.add(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                ans.append(letter.get(letter.size() - 1));
                letter.remove(letter.size() - 1);
            } else {
                ans.append(sym.get(sym.size() - 1));
                sym.remove(sym.size() - 1);
            }
        }

        return new String(ans);
    }
}
