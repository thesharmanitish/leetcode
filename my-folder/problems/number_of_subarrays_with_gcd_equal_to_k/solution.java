class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        if(nums.length ==1)
            return k==nums[0]?1:0;
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            int currgcd=0;
            for(int j=i;j<nums.length;j++)
            {
                currgcd=gcd(currgcd,nums[j]);
                if(currgcd<k)
                    break;
                res+=(currgcd==k)?1:0;
            }
        }
        return res;
    }
    
    int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}