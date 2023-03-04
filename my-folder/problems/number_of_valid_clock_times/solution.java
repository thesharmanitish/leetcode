class Solution {
    public int countTime(String time) {
        int count = 0;
        boolean hourflag = false, minflag = false;
        if(time.charAt(0) == '?'){
            if(time.charAt(1) == '?'){
                count  = 24;
                hourflag = true;
            }else if(time.charAt(1) < '4')
                count  = 3;
            else
                count  = 2;
        }
        if(!hourflag && time.charAt(1) == '?'){
            count = time.charAt(0) <'2'?10:4;
        }
        if(time.charAt(3) == '?'){
            if(time.charAt(4) == '?'){
                count  = count ==0?60:count*60;
                minflag = true;
            }else
                count = count ==0?6:count*6;            
        }
        if(!minflag && time.charAt(4) == '?'){
            count = count ==0?10:count*10;   
        }

        return count==0?1:count;
    }
}