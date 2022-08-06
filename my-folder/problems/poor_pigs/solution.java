class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int factor=0;
        while(Math.pow(minutesToTest/minutesToDie +1, factor) <buckets){
            factor++;
        }
        return factor;
    }
}