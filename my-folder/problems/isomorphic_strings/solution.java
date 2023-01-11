class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sarr = new int[254];
        int[] tarr = new int[254];
        int prev = 0;
        for(int i=0;i<s.length();i++){
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)])
                return false;            
            sarr[s.charAt(i)] =i+1;
            tarr[t.charAt(i)] =i+1;

        }
        return true;
    }
}
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length()!= t.length())
//             return false;
//         Map<Character, Integer> map = new HashMap<>();
//         int n = s.length();
//         boolean[] visited = new boolean[128];
//         for(int i=0;i<n;i++){
//             char c = s.charAt(i);
//             if(!map.containsKey(c)){
//                 if(visited[t.charAt(i)])
//                     return false;
//                 map.put(c, i);
//                 visited[t.charAt(i)] = true;
//             }
//             else{
//                 int ind = map.get(c);
//                 if(t.charAt(ind)!=t.charAt(i))
//                     return false;
//             }
//         }
//         return true;
//     }
// }