class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Pair> list = new ArrayList<>();
        int mod = 1000000007;
        for(int i=0;i<n;i++)
            list.add(new Pair(speed[i], efficiency[i]));
        
        Collections.sort(list, (a,b)-> b.y-a.y);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max =0, sum=0;
        for(Pair p:list){
            if(pq.size() ==k)
               sum -= pq.remove();
            pq.offer(p.x);
            sum = p.x +sum;
            max = Math.max(max, sum*p.y);
        }
        
        return (int)(max%mod);
        
    }
}