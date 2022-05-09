class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        
        List<String> telephone = new ArrayList<>(
            Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        Queue<String> q = new LinkedList<>();
        
        for(char digit : digits.toCharArray()) {
            char[] digitChar = telephone.get(digit - '2').toCharArray();
            if(q.isEmpty()) {
                for(char ch : digitChar) {
                    q.offer(String.valueOf(ch));
                }
            } //Push [a, b, c] to queue.
            else {
                int queueSize = q.size();
                while(queueSize > 0) {
                    String top = q.poll();
                    for(char ch : digitChar) {
                        q.offer(top + String.valueOf(ch));
                    }
                    queueSize--;
                }
            }
        }    
        while(!q.isEmpty()){
            result.add(q.poll());
        }
        return result;
    }
}
