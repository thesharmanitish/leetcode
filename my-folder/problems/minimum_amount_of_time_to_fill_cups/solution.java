class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {return o2 - o1;});
        for(int a:amount)
            pq.add(a);
        int count = 0;
        while(!pq.isEmpty()){
            int[] pre = new int[2];
            if(pq.peek() ==0)
                return count;
            for(int i=0;i<2;i++){
                if(pq.peek()!=0){
                    pre[i] = pq.poll();
                    pre[i] -=1;
                }
                    
            }
            count++;
            pq.add(pre[0]);
            pq.add(pre[1]);
        }
        return count;
    }
}