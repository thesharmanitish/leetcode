class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {return o2-o1;});
        if(target.length ==1)
            return target[0]==1;
        for(int i:target){
            pq.offer(i);
        }
        
        if(pq.size()==2){
            int x = pq.poll();
            int y = pq.poll();
            return x%y>=1 || y==1;
                
        }
        int s = Arrays.stream(target).sum();
        
        while(pq.peek() >1){
            int x = pq.poll();
            int rest = s - x;
            if(rest == 1)
                return true;
            
            int y = x%rest;
            if(y ==0 || y == x)
                return false;
            
            pq.offer(y);
            s = s-x+y;
            
            
        }
        return true;
    }
}