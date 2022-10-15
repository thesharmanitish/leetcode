class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        int[] powers = new int[32];
        int i=0, prod=1;;
        while(n>0){
            if((n&1)==1){
                
                powers[i] = prod;
                i++;
            } 
            prod = prod*2;
            n >>=1;
        }
        int[] res = new int[queries.length];
        int j=0;
        for(int[] query:queries){
            long mul =1;
            for(i=query[0];i<=query[1];i++){
                mul = (mul *powers[i])%mod;
            }
            res[j] = (int) mul;
            j++;
        }
        return res;
        
    }
}