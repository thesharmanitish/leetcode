class Solution {
    public int[] evenOddBit(int n) {
        boolean flag = false;
        int[] res = new int[2];
        while(n>0){
            if(!flag){
                res[0] = res[0] + ((n&1)==1?1:0);
            }else{
                res[1] = res[1] + ((n&1)==1?1:0);
            }
            n>>=1;
            flag = !flag;
        }
        return res;
    }
}