class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num <10)
            return true;
        if(num%10 ==0)
            return false;
        return true;
        // int t= num, sum=0;
        // while(t>0){
        //     sum+=t%10 + sum*10;
        //     t = t/10;
        // }
        // return sum== num;
    }
}