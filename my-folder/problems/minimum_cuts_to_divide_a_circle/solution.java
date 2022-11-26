class Solution {
    public int numberOfCuts(int n) {
        if(n==1)
            return 0;
        
        
//         boolean[] prime = new boolean[101];
//         for(int i=2;i<11;i++){
//             for(int j=i+i;j<101;j+=i){
                
//                 prime[j] = true;
//             }
//         }
        if((n&1)==0)
            return n/2;
        else return n;
        
//         if(!prime[n])
//             return n;

        
//         for(int i=7;i>=3;i--){
//             if(prime[i])
//                 continue;
//             if(n%i ==0)
//                 return n/2;
//         }
//         return -1;
    }
}