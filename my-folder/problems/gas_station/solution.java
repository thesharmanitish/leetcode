class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, ind = 0, currentGas = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i]-cost[i];
            currentGas += gas[i]-cost[i];
            if(currentGas<0){
                ind = i+1;
                currentGas = 0;
            }
                
        }
        return totalGas <0 || ind >= gas.length?-1:ind;
    }

















    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int totalFuel = 0, currentFuel = 0, prev = 0;

    //     for(int i=0;i<gas.length;i++){
    //         int x = gas[i] - cost[i];
    //         totalFuel += x;
    //         currentFuel += x;
    //         if(currentFuel <0){    
    //             currentFuel = 0;
    //             prev =i+1;
    //         }
            
    //     } 
        
    //     return totalFuel<0?-1:prev;
    // }
}


/**
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prev = 0, price = 0, i=0, sum = 0;
        for(i=0;i<gas.length;i++){
            sum = sum+gas[i]-cost[i];
        }
        if(sum<0)
            return -1;
        for(i=0;i<gas.length;i++){
            while(price <0 || price+gas[i]<cost[i]){
                
                price = price - gas[prev]+cost[prev];
                prev++;
            }
            price = price - cost[i] + gas[i];
            
        }
        if(prev == gas.length)
            return -1;  
        return prev;
    }
}
 */