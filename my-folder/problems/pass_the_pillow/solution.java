class Solution {
    public int passThePillow(int n, int time) {

        int k =time % (n-1);
        int rounds = time/(n-1);
        return (rounds&1)==0?k+1:n-k;
    }
}