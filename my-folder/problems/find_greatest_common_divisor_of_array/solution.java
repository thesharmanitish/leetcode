class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE, min =Integer.MAX_VALUE;
        for(int n:nums){
            if(max<n) max =n;
            if(min>n) min = n;
        }
        
        //gcd(a,b) = gcd(b,a%b)
        while(min>0){
            max = max-min*(max/min);
            int temp = max;
            max = min;
            min = temp;
        }
        return max;
    }
    

}