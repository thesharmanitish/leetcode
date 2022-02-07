class Solution {
    public int reverse(int x) {
        int sum = 0;
        int y=x;
        if(x<0) x *=-1;
        int count = 0;
        while(x>0){
            int rem = x%10;
            x = x/10;
            if(sum!=0 && (sum*10+rem)/sum  <0 ) return 0;
            sum = sum*10+rem;
            count++;
        }
        
        if(y<0) sum*=-1;
        if(y%10 != (int)(sum/Math.pow(10,count-1))) return 0;
        return sum;
    }
}