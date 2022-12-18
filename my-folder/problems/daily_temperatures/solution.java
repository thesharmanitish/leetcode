// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int[] result = new int[temperatures.length];
//         Stack<int[]> stack = new Stack<>();

//         for(int i=0;i<temperatures.length;i++){
//             while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
//                 result[stack.peek()[1]] = i-stack.pop()[1];
//             }
//             stack.push(new int[]{temperatures[i], i});
//         }
        
//         return result;
//     }
// }
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new Integer[]{temperatures[temperatures.length-1], temperatures.length-1});
        for(int i=temperatures.length-1;i>=0;i--){
            int temp = temperatures[i];
            if(temperatures[i]>= pq.peek()[0]){
                while(!pq.isEmpty() && pq.peek()[0]<= temperatures[i])
                    pq.poll();
            }
            if(!pq.isEmpty())
                temperatures[i] = pq.peek()[1]-i;
            else 
                temperatures[i] = 0;
            pq.offer(new Integer[]{temp, i});
            
        }

        return temperatures;
    }
}