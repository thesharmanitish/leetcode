class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
  
        Arrays.sort(tokens);
        int start = 0, end = tokens.length-1, res = 0;
        
        while(start<=end){
            if(power>=tokens[start]){
                power -= tokens[start++];
                res++;
            }else if(res>0 && start<end) {
                power += tokens[end--];
                res--;
            }
             
            else break;
        }
        return res;
    }
}