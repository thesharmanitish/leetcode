class Solution {
public:
bool sumOfNumberAndReverse(int num) { 
         
//          if(num ==0 )
//              return true;
//         for(int i=num-1;i>=1;i--){

//             string y = to_string(num-i); 
//             reverse(y.begin(),y.end()); 
//             if(stoi(y) == i) 
//                 return true; 
//         } 
//         return false; 
         
        if(num==0) return true; 
         
        int n=num; 
//         string n = to_string(num);
//         if ((num < 20 and num%2 == 0) or (n.length() ==2 and num%11 == 0))
//             return true;
//         if (n.length() <= 2 and num%2 != 0)
//             return false;
        
        for(int i=1; i<=n; i++){ 
             
            int j=0; 
            int temp=i; 
            while(temp){ 
                int digit=temp%10; 
                temp/=10; 
                 
                j=j*10+digit; 
            } 
            if(i+j==num){ 
                return true; 
            } 
             
        } 
        return false; 
    }
};