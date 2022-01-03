class Solution {
	int result=0;
    public int findJudge(int n, int[][] trust) {
        
       int[] arr =  new int[n+1];
       for(int i=0;i<trust.length;i++) {
           arr[trust[i][0]]--;
           arr[trust[i][1]]++;
       }
       for(int i=1;i<arr.length;i++){
           if(arr[i]==n-1)
               return i;
       } 
        return -1;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<trust.length;i++)
        {
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0)+1);
        }
        
       map.entrySet().stream().filter(s->s.getValue()>=trust.length-1).collect(Collectors.toMap(e->e.getKey(),e->e.getValue())).forEach((k,v)-> result = k);
       return result==0?-1:result;
       */
    }
}