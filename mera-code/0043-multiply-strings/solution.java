class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(); 
        int len2 = num2.length();
        int[] resArr= new int[len1+len2];
        StringBuilder result = new StringBuilder("");
        for(int i=len1-1; i>=0; i--) {
            for(int j=len2-1; j>=0; j--) {
                int ansIndex = i+j+1;
                int remIndex = i+j;
                int prod = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                prod+=resArr[ansIndex];
                resArr[ansIndex]= prod%10;
                resArr[remIndex]+= prod/10;
            }   
        }
        
        boolean firstDigit = false;
        for(int i=0; i<resArr.length; i++) {
            if(resArr[i] > 0) firstDigit = true;
            if(firstDigit) result.append(resArr[i]);
        }
        return result.toString();
    }
}
