class Solution {
    public int countTime(String time) {
        int res = 1;
        boolean flag1 = false, flag2 = false;
        
        if(time.charAt(0) == time.charAt(1) && time.charAt(0)=='?'){
            res *=24;
            flag1 = true;
        }if(time.charAt(3) == time.charAt(4) && time.charAt(4)=='?'){
            res*=60;
            flag2 = true;
        }
        
        if(flag1 && flag2)
            return res;
        
        for(int i=0;i<time.length();i++){
            if((flag1 && i==0) || (flag2 && i==3)){
                i+=2;
                continue;
            }
            char c = time.charAt(i);
            // System.out.println(res +" "+i +" "+c);
            if(c=='?'){
                switch(i){
                    case 0: res *= time.charAt(1)>'3'?2:3; break;
                    case 1: res *= time.charAt(0)=='2'?4:10; break;
                    case 3: res *= 6; break;
                    case 4: res *= 10; break;
                }
                
            }
            
        }
        return res;
    }
}