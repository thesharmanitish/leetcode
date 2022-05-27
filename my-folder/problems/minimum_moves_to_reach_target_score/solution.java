class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        int count = 0;
        while(target>1 && maxDoubles-->0){
            count += 1+ (target&1);
            target >>=1;
        }
        return count+target-1;
    }
}