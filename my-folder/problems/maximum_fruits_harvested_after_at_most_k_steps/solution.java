class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max= 0;
        int start = 0, end = 0, sum = 0;
        while ( end < fruits.length) {

            sum += fruits[end][1];
            
            while(start<=end && !isValid(fruits[start][0], fruits[end][0], startPos, k)){
                
                sum -= fruits[start++][1];
                
            }
            max = Math.max(sum, max);
            end++;
        }
        return max;
    }
    public boolean isValid(int i, int j, int startPos, int k) {
        if(j<=startPos){
            return startPos-i<=k;
        }else if(i>=startPos){
            return j-startPos<= k;
        }else{ //i<startPos<j
            int left = startPos-i, right = j-startPos;
            return left <= right ? (left*2+right <=k) : right*2+left<=k;
        }
        
    }
}