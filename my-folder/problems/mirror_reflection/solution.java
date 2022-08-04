class Solution {
    public int mirrorReflection(int p, int q) { 
        int m = q, n = p;
        
        while(m%2==0 && n%2==0){
            m /=2;
            n/=2;
        }
        
        if(m%2 ==1 && n%2==0)
            return 2;
        else if(m%2==0 && n%2==1)
            return 0;
        else if(m%2==1 && n%2==1)
            return 1;
        else return -1;        
        
//         int m=1, n=1;
        
//         while(m*p != q*n){
//             n++;
//             m = n*q/p;
//         }
//         if(m%2 ==1 && n%2==0)
//             return 2;
//         else if(m%2==0 && n%2==1)
//             return 0;
//         else if(m%2==1 && n%2==1)
//             return 1;
//         else return -1;
        
    }
}