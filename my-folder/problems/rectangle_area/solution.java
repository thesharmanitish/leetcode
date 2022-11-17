class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xOverlap = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int yOverlap = Math.min(ay2,by2) - Math.max(ay1,by1);
        int overlap = xOverlap >0 && yOverlap >0? xOverlap*yOverlap:-1;
        int sum = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        if(overlap<0)
            return sum;
        return sum - overlap;
    }
}