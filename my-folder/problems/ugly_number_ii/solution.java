class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> tset = new TreeSet<>();
        
        long prev = 0;
        tset.add(prev+1);
        for(int i=0;i<n;i++){
            prev = tset.pollFirst();
            tset.add(prev*2);
            tset.add(prev*3);
            tset.add(prev*5);
        }
        return (int)prev;
    }

    // public int nthUglyNumber(int n) {
    //     int i=1;
    //     while(n>0){
    //        if(isUgly(i))
    //             n--;
    //         if(n==0)
    //             return i;
    //         i++; 
    //     }
    //     return -1;
    // }
    // public boolean isUgly(int n) {
    //     if(n<=0)
    //         return false;
    //     while(n%3==0)
    //         n/=3;
    //     while(n%5 ==0)
    //         n/=5;
    //     return (n & (n - 1)) == 0;
    // }        
}