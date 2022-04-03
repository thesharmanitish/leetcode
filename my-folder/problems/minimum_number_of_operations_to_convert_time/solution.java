class Solution {
    public int convertTime(String current, String correct) {
        String[] cu = current.split(":");
        String[] co = correct.split(":");
        
        int h = Integer.parseInt(co[0]) - Integer.parseInt(cu[0]);
        int count = 0;
        int m = Integer.parseInt(co[1]) - Integer.parseInt(cu[1]);
        if(h==0 && m==0)
            return 0;
        else if (h==0){
            return logic(m);
        }
        
        if(m>=0){
            count = h;
            
        }else if(m<0){
            count = h-1;
            m = 60-Integer.parseInt(cu[1])+Integer.parseInt(co[1]);
        }
        count+=logic(m);
        return count;
    }
    
    public int logic(int m){
        int count =0;
       if(m>=15){            
            count+=m/15;
            m=m%15;
        }
        if(m>=5){
            count+=m/5;
            m=m%5;
        }
            count+=m;
        return count;
        }
}