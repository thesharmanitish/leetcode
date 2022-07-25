class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> set = new TreeMap<>();
        
        int i=0, counta =0, countb=0;
        for(char c:s.toCharArray()){
            if(c == '|'){
                set.put(i, counta);
                
            }else
                ++counta;
            i++;    
        }
        int[] res = new int[queries.length];
        for(i=0;i<queries.length;i++){
            Integer c  = set.ceilingKey(queries[i][0]);
            if(c== null)
                continue;
            int s1 = set.get(c);
            
            Integer f  = set.floorKey(queries[i][1]);
            if(f== null)
                continue;            
            int s2 = set.get(f);
            res[i]=s2>=s1?s2-s1:0;
        }
        
        return res;
    }
// public int[] platesBetweenCandles(String s, int[][] queries) {
//     int psum[] = new int[s.length() + 1];
//     int next[] = new int[s.length() + 1], prev[] = new int[s.length() + 1];
//     Arrays.fill(next, Integer.MAX_VALUE);
//     int res[] = new int[queries.length];
//     for (int i = 0; i < s.length(); ++i) {
//         psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
//         prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
//     }
//     for (int i = s.length() - 1; i >= 0; --i)
//         next[i] = s.charAt(i) == '|' ? i : next[i + 1];
//     for (int j = 0; j < queries.length; ++j) {
//         int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
//         res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
//     }        
//     return res;
// }    
}