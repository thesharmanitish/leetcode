class Solution {
         int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int subarrayLCM(int[] nums, int k) {
        
        int n= nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int tmp=nums[i];
            if(tmp>k)continue;
            if(tmp==k)cnt++;
            for(int j=i+1;j<n;j++){
                int lcm = (nums[j]*tmp)/gcd(nums[j],tmp);
                if(lcm==k){
                    cnt++;
                   
                }
                 tmp=lcm;
                if(tmp>k || lcm > k)break;
            }
        }
        return cnt;
    }
}