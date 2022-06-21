class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{return o2 - o1;});
        int i = 0;
        for(i=0;i<heights.length-1;i++){
            
            int diff = heights[i+1]-heights[i];
            if(diff<=0)
                continue;
            
            bricks -= diff;
            pq.offer(diff);
            
            if(bricks<0 && ladders ==0){
                return i;
            }else if(bricks<0 && ladders>0){
                bricks +=pq.poll();
                ladders--;
            }
            
                
                
            
        }
        return heights.length-1;
    }
}