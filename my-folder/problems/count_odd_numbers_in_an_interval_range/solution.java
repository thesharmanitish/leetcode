class Solution {
    public int countOdds(int low, int high) {
        if((high&1)==1)
            high +=1;
        // if((low&1)==1)
        //     low -=1;
        return (high>>1)- (low>>1);
    }
}