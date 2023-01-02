class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int[] isPrime =  new int[1001];
        Arrays.fill(isPrime, 1);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i] == 1){
                int x =2, y= i;
                while(x*y <= 1000){
                    isPrime[y*x] *= y ;
                    x++;
                }
                set.add(i);
            }
        }
        
        int count = 0;
        for(int num:nums){
            for(Integer s:set){
                if(num%s == 0 && isPrime[s] == 1){
                        count++;
                        isPrime[s] = 0;
                    }
                
            }
        }
        return count;
    }
}