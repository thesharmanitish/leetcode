class Solution {
    public int[] findOriginalArray(int[] changed) {
        if((changed.length &1)==1)
            return new int[0];
        
        int n = changed.length/2;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, start = 0;
        int[] res = new int[n];
        Arrays.sort(changed);
        
        for(int c:changed){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        for(int c: changed){
            if(c==0){
                if(map.containsKey(c)){
                    int x = map.get(c);
                    if(x==1)
                        return new int[0];
                    else if(x==0)
                        continue;
                    count +=1;
                    map.put(0, x-2);
                    res[start++] = 0;
                }
                else continue;
            }            
            else if(map.containsKey(2*c)){
                Integer x1 = map.get(2*c);
                Integer x2 = map.get(c);
                
                if(x2 ==null || x1 ==null)
                    continue;
                if(x1 ==1)
                    map.remove(2*c);
                else
                    map.put(2*c, x1-1);    
                if(x2 ==1)
                    map.remove(c);
                else
                    map.put(c, x2-1);    
                count++;
                res[start++] = c;
            }
            

                       
        }
        if(count == n)
            return res;        
       return new int[0]; 
    }
}