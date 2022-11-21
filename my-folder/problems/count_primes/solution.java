class Solution {
    public int countPrimes(int n) {
        if(n<2)
            return 0;
        boolean[] arr = new boolean[n];
        int count = 0;
        int i=2, x = (int)Math.sqrt(n);
        for(i=2;i<= x;i++){
            if(!arr[i]){
                count++;
                for(int j=i*i;j<n;j+=i){
                    arr[j] = true;
                }
            }
        }
        for(;i< n;i++){
            if(!arr[i])
                count++;
        }
        return count;

    }
}