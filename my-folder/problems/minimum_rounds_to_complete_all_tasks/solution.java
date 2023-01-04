class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskMap = new HashMap<>();

        for(int task:tasks){
            taskMap.put(task, taskMap.getOrDefault(task, 0)+1);
        }
        int count = 0;
        for(int val:taskMap.values()){
            if(val == 1)
                return -1;
            count += Math.ceil(val/3.0);
        }
        return count;
    }
}