// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         if(trust.length ==0)
//             return n>1?-1:1;
//         if(trust.length ==1)
//             return trust[0][1];
//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for(int[] t:trust){
//             if(map.containsKey(t[0]))
//                 map.remove(t[0]);
//             else
//                 map.computeIfAbsent(t[1], ArrayList::new).add(t[0]);
//         }
//         for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
//             if(entry.getValue().size() > map.size())
//                 return entry.getKey();

//         }
//         return -1;
//     }
// }

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++; 
        }

        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}