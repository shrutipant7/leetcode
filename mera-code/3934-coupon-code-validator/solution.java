class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Set<String> validBusinessLine = new HashSet<>();
        validBusinessLine.add("electronics");
        validBusinessLine.add("grocery");
        validBusinessLine.add("pharmacy");
        validBusinessLine.add("restaurant");
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            boolean isValid = true;
            // Validate code
            if (code[i].length() == 0) {
                isValid = false;
            } else {
                for (char ch : code[i].toCharArray()) {
                    if (ch != '_' && !Character.isLetterOrDigit(ch)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!validBusinessLine.contains(businessLine[i]))
                isValid = false;
            if (!isActive[i])
                isValid = false;
            if (isValid) {
                List<String> temp = new ArrayList<>();
                temp.add(code[i]);
                temp.add(businessLine[i]);
                ans.add(new ArrayList<>(temp));
            }
        }

        Collections.sort(ans, (a, b) -> {
            if (a.get(1).equals(b.get(1))) {
                return a.get(0).compareTo(b.get(0));
            }
            return a.get(1).compareTo(b.get(1));
        });

        List<String> res = new ArrayList<>();
        for (List<String> item : ans) {
            res.add(item.get(0));
        }
        return res;
    }
}
