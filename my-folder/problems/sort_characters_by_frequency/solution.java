class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c:s.toCharArray()){
            freq[c] +=1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        // RuleBasedCollator rulesCollator = new RuleBasedCollator(rule);
        for(int i=0;i<128;i++){
            if(freq[i] ==0)
                continue;
            pq.offer(new int[]{i, freq[i]});
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            while(x[1]-->0)
                result.append((char)x[0]);

        }
        return result.toString();
    }
}