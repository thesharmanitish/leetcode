class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int task:tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        int count = 0;
        for(int v:map.values()){
            if(v<2)
                return -1;
            
            else if(v>=3){
                
                count+=v/3;
                if(v%3>0)
                    count+=1;
            }else if(v==2){
                count += 1;
            }
            

        }
        return count;
    }
}