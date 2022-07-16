class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int g : gas) gasSum+=g;
        for(int c : cost) costSum+=c;
        if(costSum > gasSum) return -1;
        int res = 0;
        int total = 0;
        for(int i=0; i<gas.length-1; i++){
            total+= (gas[i]-cost[i]);
            if(total < 0) {
                total = 0;
                res = i+1;
            }
        }
        return res;
    }
}
