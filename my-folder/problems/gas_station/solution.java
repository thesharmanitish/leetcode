class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0, currentFuel = 0, prev = 0;

        for(int i=0;i<gas.length;i++){
            int x = gas[i] - cost[i];
            totalFuel += x;
            currentFuel += x;
            if(currentFuel <0){    
                currentFuel = 0;
                prev =i+1;
            }
            
        } 
        
        return totalFuel<0?-1:prev;
    }
}