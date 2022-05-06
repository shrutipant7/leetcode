class Solution {
    public boolean isHappy(int n) {
        // <<--------- Using HashSet --------->>
        // Set<Integer> set = new HashSet<>();
        // int nextNum = n;
        // while(true){
        //     nextNum = getNextNum(nextNum);
        //     System.out.println(nextNum);
        //     if(nextNum == 1) return true;
        //     else if(set.contains(nextNum)) return false;
        //     else set.add(nextNum);
        // }
        
        
        int slow = n;        
        int fast = getNextNum(n);
        while(slow != fast && fast != 1) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
        } 
        if(fast == 1) return true;
        else return false;
    }
    
    static int getNextNum(int num) {
        int newNum = 0;
        while(num > 0) {
            newNum += (num%10) * (num%10);
            num = num/10;
        }
        return newNum;
    }
}
