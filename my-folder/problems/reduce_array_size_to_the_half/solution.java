class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        Map<Integer, Integer> frqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        for(int a:arr){
            frqMap.put(a, frqMap.getOrDefault(a, 0)+1);
        }
        pq.addAll(frqMap.entrySet());
        
        int count =0, res = 0;
        while (true) {
            count += pq.poll().getValue();
            res++;
            if (count >= size / 2) {
                break;
            }
        }
        return res;
        
    }
}