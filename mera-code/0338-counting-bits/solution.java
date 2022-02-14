class Solution {
    public int[] countBits(int n) {
        int[] list = new int[n+1];
        list[0]=0;
        for (int i=1; i<=n; i++) {
            int num = i;
            int count = 0;
            while(num != 0){
                num = num & num-1;
                count++;
            } 
            list[i]=count;
        }
    return list;
    }
}
