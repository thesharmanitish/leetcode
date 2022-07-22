class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0 || g.length ==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int s1 =0, s2 = 0, count =0;
        
        for(s2=0;s2<s.length;s2++){
            if(s1 < g.length && g[s1]<=s[s2]){
                count++;
                s1++;
            }
        }
        return count;
    }
}