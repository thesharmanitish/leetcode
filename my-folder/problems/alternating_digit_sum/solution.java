class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0, sign =1, count = 0;
        
        while(n>0){
            sum = sum+  sign*(n%10);
            n = n/10;
            sign *=-1;
            count++;
        }
        if((count&1)==0)
            sum *=-1;
        return sum;
    }
}